package com.engenha;

import java.awt.*;

public class Terreno {
    String nome, descricao;
    int custoEnergia;
    int danoPorTurno;
    public Image sprite;

    Terreno(String n , int e, int d, String s){
        nome = n;
        custoEnergia = e;
        danoPorTurno = d;
        try {
            sprite = Toolkit.getDefaultToolkit().getImage(s);
        } catch (Exception exception){
            System.out.println("Erro no nome do sprite de terreno...");
        }
    }

    public Image print(){
        return sprite;
    }
}
