package com.engenha;

public class Terreno {
    String nome, descricao;
    int custoEnergia;
    int danoPorTurno;

    Terreno(String n , int e, int d){
        nome = n;
        custoEnergia = e;
        danoPorTurno = d;
    }
}
