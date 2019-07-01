package br.edu.ifsul.modelo.util.relatorio;

import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Instituicao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FabricaObjetos {

    public static List<Curso> carregaCursos() {
        List<Curso> lista = new ArrayList<>();

        Instituicao i = new Instituicao();
        i.setNome("IMED");
        i.setAnoFundacao(2020);

        Disciplina d1 = new Disciplina();

        d1.setNome("Banco de Dados");
        d1.setDescricao("Matéria voltada para banco de dados relacional");
        d1.setCargaHoraria(4.0);
        d1.setConhecimentosMinimos("Lógica de Programação");

        Disciplina d2 = new Disciplina();

        d2.setNome("Banco de Dados 2");
        d2.setDescricao("Matéria voltada para banco de dados não-relacional");
        d2.setCargaHoraria(4.0);
        d2.setConhecimentosMinimos("Lógica de Programação");

        Curso c1 = new Curso();
        c1.setInstituicao(i);
        c1.setId(1);
        c1.setNome("Engenharia Elétrica");
        c1.setDescricao("Dsads");
        c1.setSigla("CC");
        c1.setInicioAtividades(Calendar.getInstance());
        c1.getDisciplinas().add(d1);
        c1.getDisciplinas().add(d2);
        lista.add(c1);

        Curso c2 = new Curso();
        c2.setInstituicao(i);
        c2.setId(2);
        c2.setNome("Ciência da Computação");
        c2.setDescricao("Dsads");
        c2.setSigla("EE");
        c2.setInicioAtividades(Calendar.getInstance());
        lista.add(c2);

        return lista;
    }
}
