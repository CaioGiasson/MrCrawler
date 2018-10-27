package com.engenha;

import java.util.ArrayList;

public class Cenario {
    Terreno tipoTerreno;
    int [] tamanho = {24,24};
    public ArrayList<Sala> salas;
    int[] posicaoInicial = {1,1};
    int[] posicaoJogador = {1,1};
    int salaInicial = -1;

    Cenario (Terreno terr, int posX, int posY){
        tipoTerreno = terr;
        posicaoInicial[0] = posX;
        posicaoInicial[0] = posY;
        posicaoJogador = posicaoInicial;
        salas = new ArrayList<Sala>();
    }

    public void addSala(Sala s, boolean inicial ){
        salas.add(s);
        if (inicial) salaInicial = salas.size() -1;
    }
}
