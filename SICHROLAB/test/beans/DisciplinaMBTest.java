/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import modelo.Disciplina;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maycon
 */
public class DisciplinaMBTest {
    
    public DisciplinaMBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inserirDisciplina method, of class DisciplinaMB.
     */
    @Test
    public void testInserirDisciplina() {
        System.out.println("inserirDisciplina");
        DisciplinaMB instance = new DisciplinaMB();
        instance.getDisciplina().setCod_disciplina("BSI2102");
        instance.getDisciplina().setCarga_horaria(60);
        instance.getDisciplina().setCurso("Sistemas de Informação");
        instance.getDisciplina().setNome("Redes");
        Disciplina d = instance.getDisciplina();
        instance.inserirDisciplina();
        assertEquals(d, instance.disciplinaDAO.findDisciplina("BSI2102"));
    }

    /**
     * Test of alterarDisciplina method, of class DisciplinaMB.
     */
    @Test
    public void testAlterarDisciplina() {
        System.out.println("alterarDisciplina");
        DisciplinaMB instance = new DisciplinaMB();
        instance.setDisciplina(instance.disciplinaDAO.findDisciplina("BSI2101"));
        Disciplina d = instance.getDisciplina();
        instance.alterarDisciplina();
        assertEquals(d, instance.disciplinaDAO.findDisciplina(d.getCod_disciplina()));
    }

    /**
     * Test of excluirDisciplina method, of class DisciplinaMB.
     */
    @Test
    public void testExcluirDisciplina() {
        System.out.println("excluirDisciplina");
        DisciplinaMB instance = new DisciplinaMB();
        instance.setDisciplina(instance.disciplinaDAO.findDisciplina("BSI2103"));
        String s = instance.getDisciplina().getCod_disciplina();
        instance.excluirDisciplina();
        assertNull(instance.disciplinaDAO.findDisciplina(s));
    }

    /**
     * Test of pesquisar method, of class DisciplinaMB.
     */
    @Test
    public void testPesquisar() {
        System.out.println("pesquisar");
        DisciplinaMB instance = new DisciplinaMB();
        instance.pesquisar();
        List<Disciplina> d = instance.disciplinaDAO.findDisciplinaEntities();
        assertEquals(d, instance.getDisciplinas());
    }

    /**
     * Test of pesquisarPorNomeDaDisciplina method, of class DisciplinaMB.
     */
    @Test
    public void testPesquisarPorNomeDaDisciplina() {
        System.out.println("pesquisarPorNomeDaDisciplina");
        DisciplinaMB instance = new DisciplinaMB();
        instance.setNome_disciplina("Redes");
        String nomeDaDisciplina = instance.getNome_disciplina();
        instance.pesquisarPorNomeDaDisciplina(); 
        List<Disciplina> d = new ArrayList<Disciplina>();
        for(Disciplina s : instance.disciplinaDAO.findDisciplinaEntities()){
            if(s.getNome().toUpperCase().contains(nomeDaDisciplina.toUpperCase())){
                d.add(s);
            }
        }
        assertEquals(d, instance.getDisciplinas());
    }

    /**
     * Test of pesquisarDisciplinaPorCurso method, of class DisciplinaMB.
     */
    @Test
    public void testPesquisarDisciplinaPorCurso() {
        System.out.println("pesquisarDisciplinaPorCurso");
        DisciplinaMB instance = new DisciplinaMB();
        instance.setCurso_disciplina("Sistemas de Informação");
        instance.pesquisarDisciplinaPorCurso();
        List<Disciplina> d = new ArrayList<Disciplina>();
        for(Disciplina s : instance.disciplinaDAO.findDisciplinaEntities()){
            if(s.getCurso().toUpperCase().contains(instance.getCurso_disciplina().toUpperCase())){
                d.add(s);
            }
        }
        assertEquals(d, instance.getDisciplinas());
    }

    /**
     * Test of getDisciplina method, of class DisciplinaMB.
     */
    @Test
    public void testGetDisciplina() {
        System.out.println("getDisciplina");
        DisciplinaMB instance = new DisciplinaMB();
        Disciplina expResult = instance.getDisciplina();
        Disciplina result = instance.getDisciplina();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDisciplina method, of class DisciplinaMB.
     */
    @Test
    public void testSetDisciplina() {
        System.out.println("setDisciplina");
        Disciplina disciplina = new Disciplina();
        DisciplinaMB instance = new DisciplinaMB();
        instance.setDisciplina(disciplina);
        assertEquals(disciplina, instance.getDisciplina());
    }

    /**
     * Test of getDisciplinas method, of class DisciplinaMB.
     */
    @Test
    public void testGetDisciplinas() {
        System.out.println("getDisciplinas");
        DisciplinaMB instance = new DisciplinaMB();
        List expResult = instance.getDisciplinas();
        List result = instance.getDisciplinas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDisciplinas method, of class DisciplinaMB.
     */
    @Test
    public void testSetDisciplinas() {
        System.out.println("setDisciplinas");
        List<Disciplina> disciplinas = new ArrayList<Disciplina>();
        DisciplinaMB instance = new DisciplinaMB();
        instance.setDisciplinas(disciplinas);
        assertEquals(disciplinas, instance.getDisciplinas());
    }

    /**
     * Test of getDisciplinaPesquisada method, of class DisciplinaMB.
     */
    @Test
    public void testGetDisciplinaPesquisada() {
        System.out.println("getDisciplinaPesquisada");
        DisciplinaMB instance = new DisciplinaMB();
        String expResult = instance.getDisciplinaPesquisada();
        String result = instance.getDisciplinaPesquisada();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDisciplinaPesquisada method, of class DisciplinaMB.
     */
    @Test
    public void testSetDisciplinaPesquisada() {
        System.out.println("setDisciplinaPesquisada");
        String disciplinaPesquisada = "Redes";
        DisciplinaMB instance = new DisciplinaMB();
        instance.setDisciplinaPesquisada(disciplinaPesquisada);
        assertEquals(disciplinaPesquisada, instance.getDisciplinaPesquisada());
    }

    /**
     * Test of getMensagem method, of class DisciplinaMB.
     */
    @Test
    public void testGetMensagem() {
        System.out.println("getMensagem");
        DisciplinaMB instance = new DisciplinaMB();
        String expResult = instance.getMensagem();
        String result = instance.getMensagem();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMensagem method, of class DisciplinaMB.
     */
    @Test
    public void testSetMensagem() {
        System.out.println("setMensagem");
        String mensagem = "Teste";
        DisciplinaMB instance = new DisciplinaMB();
        instance.setMensagem(mensagem);
        assertEquals(mensagem, instance.getMensagem());
    }

    /**
     * Test of getNome_disciplina method, of class DisciplinaMB.
     */
    @Test
    public void testGetNome_disciplina() {
        System.out.println("getNome_disciplina");
        DisciplinaMB instance = new DisciplinaMB();
        String expResult = instance.getNome_disciplina();
        String result = instance.getNome_disciplina();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome_disciplina method, of class DisciplinaMB.
     */
    @Test
    public void testSetNome_disciplina() {
        System.out.println("setNome_disciplina");
        String nome_disciplina = "Redes";
        DisciplinaMB instance = new DisciplinaMB();
        instance.setNome_disciplina(nome_disciplina);
        assertEquals(nome_disciplina, instance.getNome_disciplina());
    }

    /**
     * Test of getCurso_disciplina method, of class DisciplinaMB.
     */
    @Test
    public void testGetCurso_disciplina() {
        System.out.println("getCurso_disciplina");
        DisciplinaMB instance = new DisciplinaMB();
        String expResult = instance.getCurso_disciplina();
        String result = instance.getCurso_disciplina();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCurso_disciplina method, of class DisciplinaMB.
     */
    @Test
    public void testSetCurso_disciplina() {
        System.out.println("setCurso_disciplina");
        String curso_disciplina = "Sistemas de Informação";
        DisciplinaMB instance = new DisciplinaMB();
        instance.setCurso_disciplina(curso_disciplina);
        assertEquals(curso_disciplina, instance.getCurso_disciplina());
    }
}
