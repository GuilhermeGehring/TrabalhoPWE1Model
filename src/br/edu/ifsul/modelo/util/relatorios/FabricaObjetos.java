/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo.util.relatorios;

import br.edu.ifsul.modelo.Instituicao;
import java.util.ArrayList;
import java.util.List;

public class FabricaObjetos {

    public static List<Instituicao> carregaCursos() {
        List<Instituicao> lista = new ArrayList<>();
        Instituicao i1 = new Instituicao();
        i1.setNome("IMED");
        i1.setAnoFundacao(2020);
        lista.add(i1);
        Instituicao i2 = new Instituicao();
        i2.setNome("IFSUL");
        i2.setAnoFundacao(2007);
        lista.add(i2);
        return lista;
    }
}
