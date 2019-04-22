/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.tests.junit;

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Nota;
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
public class TestePersistirNota {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirNota() {
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
        Nota obj1 = new Nota();
        obj1.setNota01(10.0);
        obj1.setNota02(5.3);
        obj1.setMedia(obj1.gerarMedia(obj1.getNota01(), obj1.getNota02()));
        obj1.setAluno(em.find(Aluno.class, 1));
        obj1.setDisciplina(em.find(Disciplina.class, 1));
        
        em.getTransaction().begin();
        em.persist(obj1);        
        em.getTransaction().commit();        
    }
    
}
