package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Star Wars: Episódio I – A Ameaça Fantasma",1999);
        meuFilme.setDuracaoEmMinutos(136);
        meuFilme.setIncluidoNoPlano(true);
        meuFilme.avaliacao(5.5);
        meuFilme.avaliacao(10);
        meuFilme.avaliacao(8);
        meuFilme.avaliacao(2);

        meuFilme.exibeFichaTecnica();
        System.out.printf("A duração desse filme é: %s%n", meuFilme.getDuracaoEmMinutos());

        System.out.printf("A media desse filme é: %.2f%n", meuFilme.obterMedia());
        System.out.printf("Total de avaliações: %s%n", meuFilme.getTotalDeAvaliacoes());

        Serie serie = new Serie("Lost",2000);
        serie.exibeFichaTecnica();
        serie.setTemporada(10);
        serie.setEpisodiosPorTemporada(10);
        serie.setMinutosPorEpisodio(50);

        Filme filme2 = new Filme("Avatar: O Caminho da Água",2023);
        filme2.setDuracaoEmMinutos(192);
        filme2.setIncluidoNoPlano(true);
        filme2.exibeFichaTecnica();

        System.out.printf("Duração para maratonar %s: %s%n", serie.getNome(),serie.getDuracaoEmMinutos());
        CalculadoraDeTempo calculadoraDeTempo  = new CalculadoraDeTempo();
        calculadoraDeTempo.inclui(meuFilme);
        calculadoraDeTempo.inclui(filme2);
        calculadoraDeTempo.inclui(serie);
        System.out.printf("Tempo total para ver os filmes e a Serie: %s%n", calculadoraDeTempo.getTempoTotal());

        FiltroRecomendacao filtroRecomendacao = new FiltroRecomendacao();
        filtroRecomendacao.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(serie);
        episodio.setTotalVisualizacoes(300);
        filtroRecomendacao.filtra(episodio);

        Filme filme3 = new Filme("As Branquelas",2004);
        filme3.setDuracaoEmMinutos(109);

        ArrayList<Filme> listaDeFilmes = new ArrayList<Filme>();
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(filme2);
        listaDeFilmes.add(filme3);
        System.out.printf("Tamanho da lista %s%n",listaDeFilmes.size());
        System.out.printf("Primeiro filme: %s%n",listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
    }
}