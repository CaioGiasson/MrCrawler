package com.engenha;

import java.awt.*;
import java.util.ArrayList;

public class Personagem {
    int vida = 50, vidaMax = 50;
    int XP = 0;
    int ataque = 30, defesa = 20;
    Raca raca;

    int sprite;
    int[] posicao = {0,0};

    Personagem(int spriteIndex){
        sprite = spriteIndex;
    }

    Personagem(int spriteIndex, int v, int a, int d){
        sprite = spriteIndex;
        vida = v*1;
        vidaMax = v*1;
        ataque = a;
        defesa = d;
    }

    public void atacar(Personagem alvo){
        alvo.receberDano(ataque);
        alvo.contraAtacar(this);
    }

    public void contraAtacar(Personagem alvo){
        alvo.receberDano(ataque);
    }

    public void receberDano(int dano){
        vida = Math.max(0, vida-(dano-defesa));
        if ( vida==0 ) morrer();
    }

    public void morrer(){
        if ( Jogador.stats.vida==0 ) Tela.gameOver = true;
        else Jogador.getXP(1);
    }

    public void curar(){
        vida = vidaMax;
    }

}
