package com.engenha;

import java.util.ArrayList;

public class Mundo {
    int tempo;
    ArrayList<Cenario> cenarios;
    int cenarioAtual = 0;

    Mundo( ){
        tempo = 1;
        cenarios = new ArrayList<>();
    }

    public void addCenario(Cenario c){
        cenarios.add(c);
    }

    public void nextCenario(int x, int y){
        if ( cenarioAtual<cenarios.size()-1 ) {
            cenarioAtual++;
            cenarios.get(cenarioAtual).update();
            cenarios.get(cenarioAtual).playerEnter(x, y);
            Jogador.update();
            Main.f.repaint();
        }
    }

    public void prevCenario(int x, int y){
        if ( cenarioAtual>0 ) {
            cenarioAtual--;
            cenarios.get(cenarioAtual).update();
            cenarios.get(cenarioAtual).playerEnter(x, y);
            Jogador.update();
            Main.f.repaint();
        }
    }

    public boolean canGoNextCenario(){ return cenarioAtual<cenarios.size()-1; }
    public boolean canGoPrevCenario(){ return cenarioAtual>0; }

    public boolean isThereNextCenario(){
        if ( cenarioAtual==cenarios.size()-1 ) return false;
        return true;
    }

    public void prevCenario(){
        if ( cenarioAtual>0 ){
            cenarioAtual--;
            Main.arton.update();
            Jogador.update();
            Main.f.repaint();
        }

    }

    public void update(){
        cenarios.get(cenarioAtual).update();
    }
}
