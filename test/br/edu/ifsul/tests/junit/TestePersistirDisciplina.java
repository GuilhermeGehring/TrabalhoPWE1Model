/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.tests.junit;

import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Instituicao;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author guilherme
 */
public class TestePersistirDisciplina {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirDisciplina() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TrabalhoPWE1ModelPU");
        em = emf.createEntityManager();        
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        Disciplina obj1 = new Disciplina();
        obj1.setNome("Banco de Dados");         
        obj1.setDescricao("Matéria voltada para banco de dados relacional");
        obj1.setCargaHoraria(4.0);
        obj1.setConhecimentosMinimos("Lógica de Programação");
        obj1.setCurso(em.find(Curso.class, 1));
        
        em.getTransaction().begin();
        em.persist(obj1);        
        em.getTransaction().commit();        
    }
    
}
