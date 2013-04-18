/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.DisciplinaJpaController;
import dao.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Disciplina;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Anderson
 */
@ManagedBean
@RequestScoped
public class DisciplinaMB {

    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("SICHROLABPU");
    DisciplinaJpaController disciplinaDAO = new DisciplinaJpaController(factory);
    
    private Disciplina disciplina = new Disciplina();
    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
    
    private String disciplinaPesquisada;
    private String mensagem;
    
    public DisciplinaMB() {
        //pesquisar();
    }
    
    public void inserirDisciplina(){
        try{
            disciplinas = new ArrayList<Disciplina>();
            disciplina.setCod_disciplina(null);
            disciplinaDAO.create(disciplina);
            disciplina = new Disciplina();
            setMensagem("Cadastro realizado com sucesso");
        }catch(Exception ex){
            setMensagem("Cadastro já existente no sistema");
            Logger.getLogger(DisciplinaMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        pesquisar();
    }
    
    public void alterarCategoriaDeEvento() {
        try {
            disciplinas = new ArrayList<Disciplina>();
            disciplinaDAO.edit(disciplina);
            disciplina = new Disciplina();
            setMensagem("Cadastro alterado com sucesso");
        } catch (NonexistentEntityException ex) {
            setMensagem("Cadastro não pode ser alterado");
            Logger.getLogger(DisciplinaMB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            setMensagem("Cadastro não pode ser alterado");
            Logger.getLogger(DisciplinaMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        pesquisar();
    }
    
    public void excluirSala() {
        try {
            disciplinaDAO.destroy(disciplina.getCod_disciplina());
            disciplina = new Disciplina();
            setMensagem("Cadastro excluído com sucesso");
        } catch (NonexistentEntityException ex) {
            setMensagem("Cadastro não pode ser excluído");
            Logger.getLogger(DisciplinaMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        pesquisar();
    }    
    
    public void pesquisar() {
        disciplinas = disciplinaDAO.findDisciplinaEntities();
    }

    /**
     * @return the disciplina
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the disciplinas
     */
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    /**
     * @param disciplinas the disciplinas to set
     */
    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    /**
     * @return the disciplinaPesquisada
     */
    public String getDisciplinaPesquisada() {
        return disciplinaPesquisada;
    }

    /**
     * @param disciplinaPesquisada the disciplinaPesquisada to set
     */
    public void setDisciplinaPesquisada(String disciplinaPesquisada) {
        this.disciplinaPesquisada = disciplinaPesquisada;
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