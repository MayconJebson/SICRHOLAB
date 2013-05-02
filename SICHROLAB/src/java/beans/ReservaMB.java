/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.CategoriaDeEventoJpaController;
import dao.ReservaJpaController;
import dao.SalaJpaController;
import dao.TurmaJpaController;
import dao.UsuarioJpaController;
import dao.exceptions.NonexistentEntityException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.CategoriaDeEvento;
import modelo.Reserva;
import modelo.Sala;
import modelo.Turma;
import modelo.Usuario;

/**
 *
 * @author maycon
 */
@ManagedBean
@RequestScoped
public class ReservaMB {
    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("SICHROLABPU");
    ReservaJpaController reservaDAO = new ReservaJpaController(factory);
    UsuarioJpaController usuarioDAO = new UsuarioJpaController(factory);
    SalaJpaController salaDAO = new SalaJpaController(factory);
    TurmaJpaController turmaDAO = new TurmaJpaController(factory);
    CategoriaDeEventoJpaController categoriaDeEventoDAO = new CategoriaDeEventoJpaController(factory);
    
    private Reserva reserva = new Reserva();
    private Turma turma = new Turma();
    private Usuario usuario = new Usuario();
    private Sala sala = new Sala();
    private CategoriaDeEvento categoriaDeEvento = new CategoriaDeEvento();
    private String mensagem;
    private List<Reserva> reservas = new ArrayList<Reserva>();
    private List<String> listaDeStatus = new ArrayList<String>();
    
    /**
     * Creates a new instance of ReservaMB
     */
    public ReservaMB() {
        addListaDeStatus();
        pesquisar();
    }

    public void inserirReserva(){
        try{
            reserva.setCodigoReserva(null);
            reserva.setDataHora(dataAtual());
            reserva.setTurma(turma);
            reserva.setCategoriaEvento(categoriaDeEvento);
            reserva.setUsuario(usuario);
            reserva.setSala(sala);
            reservaDAO.create(reserva);
            reserva = new Reserva();
            turma = new Turma();
            usuario = new Usuario();
            sala = new Sala();
            categoriaDeEvento = new CategoriaDeEvento();
            setMensagem("Cadastro realizado com sucesso");
        }catch(Exception ex){
           setMensagem("Cadastro já existente no sistema");
           Logger.getLogger(ReservaMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        pesquisar();
    }
    
    public void alterarReserva() {
        try {
            reserva.setDataHora(dataAtual());
            reserva.setTurma(turma);
            reserva.setCategoriaEvento(categoriaDeEvento);
            reserva.setUsuario(usuario);
            reserva.setSala(sala);
            reservaDAO.edit(reserva);
            reserva = new Reserva();
            turma = new Turma();
            usuario = new Usuario();
            sala = new Sala();
            categoriaDeEvento = new CategoriaDeEvento();
            setMensagem("Cadastro alterado com sucesso");
        } catch (NonexistentEntityException ex) {
            setMensagem("Cadastro não pode ser alterado");
            Logger.getLogger(ReservaMB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            setMensagem("Cadastro não pode ser alterado");
            Logger.getLogger(ReservaMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        pesquisar();
    }
    
    public void excluirReserva() {
        try {
            reservaDAO.destroy(reserva.getCodigoReserva());
            reserva = new Reserva();
            turma = new Turma();
            usuario = new Usuario();
            sala = new Sala();
            categoriaDeEvento = new CategoriaDeEvento();
            setMensagem("Cadastro excluído com sucesso");
        } catch (NonexistentEntityException ex) {
            setMensagem("Cadastro não pode ser excluído");
            Logger.getLogger(ReservaMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        pesquisar();
    }
    
    public Date dataAtual(){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        formatador.format(data);
        return data;
    }
    
    public void pesquisar() {
        setReservas(reservaDAO.findReservaEntities());
    }
    
    public List<Reserva> listaReservas() {
        return reservaDAO.findReservaEntities();
    }
    
    public List<Usuario> listaUsuarios() {
        return usuarioDAO.findUsuarioEntities();
    }
    
    public List<Turma> listaTurmas() {
        return turmaDAO.findTurmaEntities();
    }
    
    public List<CategoriaDeEvento> listaCategoriaDeEventos() {
        return categoriaDeEventoDAO.findCategoriaDeEventoEntities();
    }
    
    public List<Sala> listaSalas() {
        return salaDAO.findSalaEntities();
    }
    
    /**
     * @return the reserva
     */
    public Reserva getReserva() {
        return reserva;
    }

    /**
     * @param reserva the reserva to set
     */
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    /**
     * @return the turma
     */
    public Turma getTurma() {
        return turma;
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    /**
     * @return the usuario
     */
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
     * @return the sala
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    /**
     * @return the categoriaDeEvento
     */
    public CategoriaDeEvento getCategoriaDeEvento() {
        return categoriaDeEvento;
    }

    /**
     * @param categoriaDeEvento the categoriaDeEvento to set
     */
    public void setCategoriaDeEvento(CategoriaDeEvento categoriaDeEvento) {
        this.categoriaDeEvento = categoriaDeEvento;
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

    /**
     * @return the reservas
     */
    public List<Reserva> getReservas() {
        return reservas;
    }

    /**
     * @param reservas the reservas to set
     */
    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * @return the listaDeStatus
     */
    public List<String> getListaDeStatus() {
        return listaDeStatus;
    }

    /**
     * @param listaDeStatus the listaDeStatus to set
     */
    public void addListaDeStatus() {
        listaDeStatus.add("Reserva Validada");
        listaDeStatus.add("Reserva Pendente");
    }
}
