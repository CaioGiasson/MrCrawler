package com.engenha;

import java.util.ArrayList;

public class Mundo {
    int tempo;
    ArrayList<Cenario> cenarios;
    int cenarioInicial;
    Personagem jogador;

    Mundo( ){
        jogador =  new Personagem();
        tempo = 1;
        cenarios = new ArrayList<Cenario>();
    }

    public void addCenario(Cenario c, boolean inicial ){
        cenarios.add(c);
        if (inicial) cenarioInicial = cenarios.size() -1;
    }
}
