/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.tests.junit;

import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Professor;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
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
public class TestePersistirProfessor {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirProfessor() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("OSEletronicosModelPU");
        em = emf.createEntityManager();        
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        Professor obj = new Professor();
        obj.setEmail("joao@gmail.com");
        obj.setNome("joao");        
        obj.setNascimento(Date.from(Instant.MIN));        
        obj.setTitulacao("Titulação 1");
        obj.setTopicosInteresse("Tópico 1");
        obj.setEspecialidade(em.find(Especialidade.class, 1));        
        
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();        
    }
    
}
