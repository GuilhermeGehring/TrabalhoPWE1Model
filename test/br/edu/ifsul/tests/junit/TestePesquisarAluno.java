/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.tests.junit;

import br.edu.ifsul.modelo.Aluno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author guilherme
 */
public class TestePesquisarAluno {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPWE1ModelPU");
        EntityManager em = emf.createEntityManager();
        // Lembrar que a consulta é na classe Aluno com A Maiúsculo
        List<Aluno> lista = em.createQuery("from Aluno").getResultList();
        for (Aluno a : lista) {
            System.out.println("Objeto: " + a.getNomeUsuario());
        }
        em.close();
        emf.close();
    }

}
