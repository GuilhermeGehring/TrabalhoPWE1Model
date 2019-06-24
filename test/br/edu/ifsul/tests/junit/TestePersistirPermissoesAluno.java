package br.edu.ifsul.tests.junit;

import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Aluno;
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
public class TestePersistirPermissoesAluno {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirPermissoesAluno() {
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
        Aluno obj = em.find(Aluno.class, "GGEHRING");
        obj.getPermissoes().add(em.find(Permissao.class, "ADMINISTRADOR"));
        obj.getPermissoes().add(em.find(Permissao.class, "USUARIO"));
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

}
