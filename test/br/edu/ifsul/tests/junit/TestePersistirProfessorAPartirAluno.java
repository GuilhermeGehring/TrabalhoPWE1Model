/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.tests.junit;

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Professor;
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
public class TestePersistirProfessorAPartirAluno {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirProfessorAPartirAluno() {
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
        Aluno aluno = em.find(Aluno.class, 1);
        Professor obj = new Professor(aluno);
        obj.setTitulacao("Titulação 1");
        obj.setTopicosInteresse("Tópico 2");
        obj.setEspecialidade(em.find(Especialidade.class, 1));
        
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }
    
}
