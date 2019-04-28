package br.edu.ifsul.tests.junit;

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
public class TestePersistirAlunoDisciplina {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirAlunoDisciplina() {
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
        Aluno obj = em.find(Aluno.class, 1);
        obj.getDisciplinas().add(em.find(Disciplina.class, 3));
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();        
    }
    
}
