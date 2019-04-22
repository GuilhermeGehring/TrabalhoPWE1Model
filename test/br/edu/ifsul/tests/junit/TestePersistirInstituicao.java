/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.tests.junit;

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
public class TestePersistirInstituicao {

    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirInstituicao() {
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
        Instituicao obj1 = new Instituicao();
        obj1.setNome("Instituto Federal Sul-riograndense");                
        obj1.setAnoFundacao(Calendar.getInstance());        
        
        em.getTransaction().begin();
        em.persist(obj1);        
        em.getTransaction().commit();        
    }
    
}
