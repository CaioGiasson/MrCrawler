package com.engenha;

public class Sala {

    String descricao;
    int tamanho[] = {4,3};
    int posicaoNoCenario[] = {1,1};
    int posicaoInicial [] = {2,2};
    Terreno tipoTerreno;

    Sala(String desc, int posX, int posY, Terreno terr){
        descricao = desc;
        posicaoNoCenario[0] = posX;
        posicaoNoCenario[1] = posY;
        tipoTerreno = terr;
    }

    void setSize(int tamX, int tamY){
        tamanho[0] =  tamX;
        tamanho[1] =  tamY;
    }

    void setInicio(int posX, int posY){
        posicaoInicial[0] = posX;
        posicaoInicial[1] = posY;
    }
}
