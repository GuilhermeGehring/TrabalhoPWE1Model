package br.edu.ifsul.tests.junit;

import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Disciplina;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Jorge
 */
public class TestePersistirDisciplinaAluno {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirDisciplinaAluno() {
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
        Disciplina d = em.find(Disciplina.class, 1);
        d.getAlunos().add(em.find(Aluno.class, "GGEHRING"));
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
    }

}
