package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme filme1 = new Filme("Star Wars: Episódio I – A Ameaça Fantasma",1999);
        Filme filme2 = new Filme("Avatar: O Caminho da Água",2023);
        Filme filme3 = new Filme("As Branquelas",2004);
        Serie serie = new Serie("Lost",2000);

        List<Titulo> lista = new ArrayList<>();
        lista.add(filme1);
        lista.add(filme2);
        lista.add(filme3);
        lista.add(serie);

        for (Titulo item :lista){
            System.out.println(item.getNome());
        }

        Collections.sort(lista);

        System.out.println(lista);
    }
}