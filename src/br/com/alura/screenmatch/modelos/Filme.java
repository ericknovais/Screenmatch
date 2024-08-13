package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Filme extends Titulo  implements Classificavel {

    private String diretor;

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Filme (String nome,Integer anoDeLancamento) {
        super(nome,anoDeLancamento);
    }

    @Override
    public int getClassificavel() {
        return (int) obterMedia() / 2;
    }

    @Override
    public String toString() {
        return "Filme: %s (%s)".formatted(this.getNome(),this.getAnoDeLancamento());
    }
}