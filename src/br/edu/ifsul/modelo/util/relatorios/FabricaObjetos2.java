package br.edu.ifsul.modelo.util.relatorios;

import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Instituicao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FabricaObjetos2 {

    public static List<Curso> carregaProdutos() {
        List<Curso> lista = new ArrayList<>();
        Instituicao i = new Instituicao();
        i.setNome("IMED");
        i.setAnoFundacao(2020);
        Curso c1 = new Curso();
        c1.setInstituicao(i);
        c1.setId(1);
        c1.setNome("Engenharia Elétrica");
        c1.setDescricao("Dsads");
        c1.setSigla("CC");
        c1.setInicioAtividades(Calendar.getInstance());
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
