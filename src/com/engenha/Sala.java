package com.engenha;

import java.util.ArrayList;
import java.util.Random;

public class Sala {

    String descricao;
    int tamanho[] = {8,5};
    int posicao[] = {1,1};
    int posicaoInicial [] = {2,2};
    Terreno tipoTerreno;

    ArrayList<Personagem> personagens;

    Sala(String desc, int posX, int posY, Terreno terr){
        descricao = desc;
        posicao[0] = posX;
        posicao[1] = posY;
        tipoTerreno = terr;
        personagens = new ArrayList<>();
    }

    void setSize(int tamX, int tamY){
        tamanho[0] =  tamX;
        tamanho[1] =  tamY;
    }

    void setInicio(int posX, int posY){
        posicaoInicial[0] = posX;
        posicaoInicial[1] = posY;
    }

    public void update(){
        for ( int j=posicao[1] ; j<tamanho[1]+posicao[1] ; j++ )
            for ( int i=posicao[0] ; i<tamanho[0]+posicao[0] ; i++ ){
                boolean parede = j==posicao[1] || i==posicao[0];
                parede = parede || i==tamanho[0]+posicao[0]-1;
                parede = parede || j==tamanho[1]+posicao[1]-1;

                if ( parede ) Tela.setTile(i,j, tipoTerreno );
                else Tela.setTile(i,j, tipoTerreno );
            }
    }

    public void addNPC(int spriteIndex){
        Personagem p = new Personagem(spriteIndex);

        Random r = new Random();
        p.posicao[0] = r.nextInt(tamanho[0]) + posicao[0];
        p.posicao[1] = r.nextInt(tamanho[1]) + posicao[1];

        personagens.add(p);
    }
}
