/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.tests.junit;

import br.edu.ifsul.modelo.Especialidade;
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
public class TestePersistirEspecialidade {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirEspecialidade() {
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
        Especialidade obj1 = new Especialidade();
        obj1.setNome("Banco de Dados Relacional");
        
        Especialidade obj2 = new Especialidade();
        obj2.setNome("Java");
        
        Especialidade obj3 = new Especialidade();
        obj3.setNome("PHP");
        
        Especialidade obj4 = new Especialidade();
        obj4.setNome("Redes de Computadores");
        
        em.getTransaction().begin();
        em.persist(obj1);
        em.persist(obj2);
        em.persist(obj3);
        em.persist(obj4);
        em.getTransaction().commit();        
    }
    
}
