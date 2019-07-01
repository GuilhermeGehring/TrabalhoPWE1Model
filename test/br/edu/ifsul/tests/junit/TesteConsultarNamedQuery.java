package br.edu.ifsul.tests.junit;

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Permissao;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Telmo Junior
 */
public class TesteConsultarNamedQuery {

    EntityManagerFactory emf;
    EntityManager em;

    public TesteConsultarNamedQuery() {
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
    public void teste() throws IOException {
//        List<Aluno> lista = em.createNamedQuery("todosAlunoOrdemNome").getResultList();
//        for (Aluno u : lista) {
//            System.out.println("Email: " + u.getEmail());
//            System.out.println("Senha: " + u.getSenha());
//        }

        List<Disciplina> listaa = em.createNamedQuery("todosDisciplinaOrdemNome").getResultList();
        for (Disciplina d : listaa) {
            System.out.println("Nome: " + d.getNome());
            for (Aluno a : d.getAlunos()) {
                System.out.println("    Aluno: " + a.getNomeUsuario());
            }
        }

//        List<Aluno> usus = em.createNamedQuery("autenticacaoAluno").setParameter("paramEmail", "usuario@gmail.com").setParameter("paramSenha", "teste1").getResultList();
//        if (usus.isEmpty()) {
//            System.out.println("Nao autenticou");
//        } else {
//            System.out.println("Aluno " + usus.get(0).getNome() + "autenticado !!!");
//        }
    }

}
