package com.engenha;

import java.awt.*;
import java.util.ArrayList;

public final class Jogador{

	static Personagem stats = new Personagem(4, 100, 40, 25);
	static int[] posicao = {10,10};

	public static void update(){
		stats.posicao = posicao;
		Tela.setPlayer(posicao);
	}

	public static void mover(int[] pos){
		if ( pos[0]>=0 && pos[0]<=Tela.width && pos[1]>=0 && pos[1]<=Tela.height ) {
			posicao[0] = pos[0];
			posicao[1] = pos[1];
			stats.posicao = posicao;
		}
	}

	public static void andar(int x, int y){
		int nx = posicao[0]+x;
		int ny = posicao[1]-y;
		if ( podeAndarPara(nx, ny) ){
			posicao[0] = nx;
			posicao[1] = ny;
			stats.posicao = posicao;
		}
	}

	public static boolean podeAndarPara(int x, int y){
		if ( stats.vida==0 ) return false;

		// VERIFICANDO SE É UMA POSIÇÃO DENTRO DA TELA
		if ( x>=0 && x<Tela.width && y>=0 && y<Tela.height ){
			// VERIFICANDO SE TEM ALGUM NPC DO CENÁRIO
			Cenario c = Main.arton.cenarios.get(Main.arton.cenarioAtual);
			for( int i=0 ; i<c.personagens.size() ; i++ ){
				Personagem p = c.personagens.get(i);
				if ( p.posicao[0]==x && p.posicao[1]==y ) {
					if ( p.vida>0 ){
						if ( p.sprite==6 ) Jogador.stats.atacar(p);
						return false;
					}
				}
			}

			// VERIFICANDO SE TEM ALGUM NPC DA SALA ATUAL
			ArrayList<Sala> salas = c.salas;
			for ( int i=0 ; i<salas.size() ; i++ ){
				for(int j=0 ; j<salas.get(i).personagens.size() ; j++){
					Personagem p = salas.get(i).personagens.get(j);
					if ( p.posicao[0]==x && p.posicao[1]==y ) {
						if ( p.vida>0 ){
							if ( p.sprite==6 ) Jogador.stats.atacar(p);
							return false;
						}
					}
				}
			}

			return true;
		}
		return false;
	}

	public static void getXP(int xp){
		stats.XP += xp;
		if ( stats.XP>25 ) Tela.vitoria = true;
	}

}
