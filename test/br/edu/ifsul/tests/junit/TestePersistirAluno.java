/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.tests.junit;

import br.edu.ifsul.modelo.Aluno;
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
public class TestePersistirAluno {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirAluno() {
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
    public void teste() {
        Aluno obj = new Aluno();
        obj.setNomeUsuario("GGEHRING");
        obj.setNome("Guilherme");
        obj.setEmail("usuario@gmail.com");
        obj.setSenha("teste1");
        obj.setNascimento(Calendar.getInstance());
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

}
