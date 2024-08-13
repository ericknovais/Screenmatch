package br.com.alura.screenmatch.modelos;

public class Serie extends Titulo{
    private int temporada;
    private boolean ativa;
    private  int episodiosPorTemporada;
    private int minutosPorEpisodio;

    public Serie(String nome, Integer anoDeLancamento) {
        super(nome,anoDeLancamento);
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    @Override
    public int getDuracaoEmMinutos() {
        return temporada * episodiosPorTemporada * minutosPorEpisodio;
    }

    @Override
    public String toString() {
        return "Série: %s (%s)".formatted(this.getNome(),this.getAnoDeLancamento());
    }
}
