package br.com.mvbos.lgj.base;

public class Jogador implements Comparable<Jogador>{
    private String nome;
    private int pontuacao;

    public Jogador(String nome, int pontuacao){
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public int compareTo(Jogador outro){
        if(this.getPontuacao() - outro.getPontuacao() != 0){
            return outro.getPontuacao() - this.getPontuacao();
        }
        return this.getNome().compareTo(outro.getNome());
    }
}
