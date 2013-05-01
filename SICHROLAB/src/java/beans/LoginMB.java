/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.CategoriaUsuarioJpaController;
import dao.UsuarioJpaController;
import dao.exceptions.NonexistentEntityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.CategoriaUsuario;
import modelo.Usuario;


@ManagedBean
@SessionScoped
public class LoginMB {
    
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("SICHROLABPU");
    
    UsuarioJpaController daoUsuario = new UsuarioJpaController(factory);
    
    private Usuario usuario = new Usuario();;
    
    private String mensagem;

    public LoginMB() {
    }
    
    public String login(){
        //acessar o banco de dados e validar;
        usuario = daoUsuario.findUsuario(this.usuario);
        
        if (usuario!=null){
            setMensagem("");
            return "/index.xhtml";
        }
        
        usuario = new Usuario();
        setMensagem("Login ou senha incorreto!");
        return "/login.xhtml";
       
    }
    
     public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
