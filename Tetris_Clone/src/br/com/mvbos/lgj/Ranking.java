package br.com.mvbos.lgj;
import br.com.mvbos.lgj.base.Jogador;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ranking {
    private ArrayList<Jogador> jogadores = new ArrayList<>();

    public void adiciona(String nome, int pontuacao){
        Jogador jogador = new Jogador(nome, pontuacao);
        jogadores.add(jogador);
    }

    public void gravar(){
        try {
            System.out.println(System.getProperty("user.dir"));
            FileOutputStream arquivo = new FileOutputStream(System.getProperty("user.dir") + "/arquivo.txt");
            PrintStream saida = new PrintStream(arquivo);
            for(int i = 0; i < jogadores.size(); i++){
                saida.println(jogadores.get(i).getPontuacao()+" - "+ jogadores.get(i).getNome());
            }
        }catch (Exception e){}
    }

    public void ordenar(){
        Collections.sort(jogadores);
    }

    public void imprimir(Graphics2D g, int y) {
        try {
            for (int i = 0; i < 10; i++) {
                g.drawString(jogadores.get(i).getPontuacao() + " - " + jogadores.get(i).getNome(), 170, y);
                y = y + 35;
            }

        }catch (Exception e){}

    }

    public void leArquivo(){
        try {
            FileInputStream arquivo = new FileInputStream(System.getProperty("user.dir") + "/arquivo.txt");
            Scanner entrada = new Scanner(arquivo);
            while (entrada.hasNext()) {
                String linha = entrada.nextLine();
                String[] valores = linha.split(" - ");
                int pontuacao = Integer.parseInt(valores[0]);
                String nome = valores[1];
                jogadores.add(new Jogador(nome, pontuacao));
            }
        }catch (Exception e){}
    }

}

