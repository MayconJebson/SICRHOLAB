/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.UsuarioJpaController;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Usuario;


@ManagedBean
@SessionScoped
public class LoginMB {
    
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("SICHROLABPU");
    
    UsuarioJpaController daoUsuario = new UsuarioJpaController(factory);
    
    private Usuario usuario;
    
    private String mensagem;

    public LoginMB() {
        usuario = new Usuario();
    }
    
    public String login(){
        //acessar o banco de dados e validar;
        usuario = daoUsuario.findUsuario(this.usuario);
        
        if (usuario!=null){
            setMensagem("");
            return "/usuario.xhtml";
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
