package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.execao.ErroDeConversaoDeAnoException;

public class Titulo implements Comparable<Titulo> {

    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private int duracaoEmMinutos;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;

    public Titulo(String nome, int anoDeLancamento) {
        this.setNome(nome);
        this.setAnoDeLancamento(anoDeLancamento);
    }

    public Titulo(TituloOmbd tituloOmbd) {
        this.setNome(tituloOmbd.title());
        if(tituloOmbd.year().length()>4)
        {
            throw new ErroDeConversaoDeAnoException("Não consegui converter o ano " +
                    "porque tem mais de 04 caracteres.");
        }
        this.setAnoDeLancamento(Integer.valueOf(tituloOmbd.year()));
        this.setDuracaoEmMinutos(Integer.valueOf(tituloOmbd.runtime().substring(0,3)));
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void  exibeFichaTecnica()
    {
        System.out.println("""
                
                Título: %s
                Ano de lançamento: %s
                """.formatted(nome,anoDeLancamento));
    }

    public   void avaliacao(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double obterMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    public int getTotalDeAvaliacoes(){
        return  totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo titulo) {
        return this.getNome().compareTo(titulo.getNome());
    }

    @Override
    public String toString() {
        return ("(nome: %s, " +
                "ano de lançamento: %s, " +
                "duração: %s)").formatted(this.nome,this.anoDeLancamento,this.duracaoEmMinutos);
    }
}