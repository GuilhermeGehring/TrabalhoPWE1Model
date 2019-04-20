/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.tests.junit;

import br.edu.ifsul.modelo.Curso;
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
public class TestePersistirCurso {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirCurso() {
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
        Curso obj1 = new Curso();
        obj1.setNome("Ciência da Computação"); 
        obj1.setSigla("CC");
        obj1.setDescricao("Curso de bacharelado em Ciência da Computação");
        obj1.setInicioAtividades(Calendar.getInstance());
        obj1.setInstituicao(em.find(Instituicao.class, 1));
        
        em.getTransaction().begin();
        em.persist(obj1);        
        em.getTransaction().commit();        
    }
    
}
