package com.engenha;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public final class Tela {

	static int width = 40;
	static int height = 24;
	static Terreno[][] tiles = new Terreno[width][height];
	static Main frame;
	static JPanel panel;

	static boolean gameOver = false;
	static boolean vitoria = false;

	static String[] quest = {"", ""};

	static int[] playerPosition = {1,1};

	public static void imprimir(Graphics g, Main m){
		// FUNDO
		g.setColor(color(10, 10, 10));
		g.fillRect(0, 0, 1000, 700);

		// LINHAS DE GRADE
		g.setColor(color(33, 33, 33));
		for (int xx = 0; xx <= 1000; xx += 25)
			g.drawLine(xx, 0, xx, 600);
		for (int yy = 0; yy <= 600; yy += 25)
			g.drawLine(0, yy, 1000, yy);

		if ( !ready() ) return;

		// TERRENO
		Graphics2D g2 = (Graphics2D) g;

		for ( int j=0 ; j<height ; j++ )
			for ( int i=0 ; i<width ; i++ ){
				try {
					g2.drawImage(tiles[i][j].print(), i*25, j*25, 25, 25, m);
				} catch (Exception e){
					System.out.println(e);
				}
			}

		// JOGADOR
		lifeBar(Jogador.stats, g);
		g2.drawImage(Main.sprites[4].sprite, playerPosition[0]*25, playerPosition[1]*25, 25, 25, m);

		// NPC FORA DAS SALAS
		Cenario c = Main.arton.cenarios.get(Main.arton.cenarioAtual);
		for( int i=0 ; i<c.personagens.size() ; i++ ){
			if ( c.personagens.get(i).vida>0 ){
				lifeBar(c.personagens.get(i), g);
				g2.drawImage(Main.sprites[ c.personagens.get(i).sprite ].sprite, c.personagens.get(i).posicao[0]*25, c.personagens.get(i).posicao[1]*25, 25, 25, m);
			}
		}

		// NPC DAS SALAS
		ArrayList<Sala> salas = c.salas;
		for ( int i=0 ; i<salas.size() ; i++ ){
			for(int j=0 ; j<salas.get(i).personagens.size() ; j++){
				if ( salas.get(i).personagens.get(j).vida>0 ){
					lifeBar(salas.get(i).personagens.get(j), g);
					g2.drawImage(Main.sprites[ salas.get(i).personagens.get(j).sprite ].sprite, salas.get(i).personagens.get(j).posicao[0]*25, salas.get(i).personagens.get(j).posicao[1]*25, 25, 25, m);
				}
			}
		}

		// TEXTOS
		g.setColor(color(220, 220, 220));
		g.drawString(Main.arton.cenarios.get(Main.arton.cenarioAtual).descrever(), 25, 625);
		g.setColor(color(150, 150, 255));
		g.drawString(quest[0], 25, 650);
		g.drawString(quest[1], 25, 665);
		quest[0] = "";
		quest[1] = "";


		g2.finalize();

		if ( gameOver ) printGameOver(g);
		else if ( vitoria ) printVitoria(g);
	}

	public static void printGameOver(Graphics g){
		g.setColor(color(0, 0, 0));
		g.fillRect(0, 300, 1000, 100);
		g.setColor(color(255, 0, 0));
		g.drawString("You died!", 450, 350);
	}

	public static void printVitoria(Graphics g){
		g.setColor(color(0, 0, 0));
		g.fillRect(0, 300, 1000, 100);
		g.setColor(color(0, 255, 0));
		g.drawString("Você venceu!", 450, 350);
	}

	public static void lifeBar(Personagem p, Graphics g){
		g.setColor(color(255, 255, 255));
		g.fillRect(p.posicao[0]*25, p.posicao[1]*25 + 20, 25, 5);
		g.setColor(color(0, 255, 0));
		int w = (25 * p.vida ) / p.vidaMax;
		g.fillRect(p.posicao[0]*25, p.posicao[1]*25 + 20, w, 5);

	}

	public static void setPlayer(int[] pos){
		playerPosition = pos;
	}

	public static boolean ready(){
		for ( int j=0 ; j<height ; j++ )
			for ( int i=0 ; i<width ; i++ )
				if ( tiles[i][j]==null )
					return false;
		return true;
	}

	public static void setSize(int w, int h){
		width = w;
		height = h;
	}

	public static void setTile(int i, int j, Terreno t){
		try{
			tiles[i][j] = t;
		} catch(Exception e){}

	}

	public static int getWidth(){
		return width;
	}

	public static int getHeight(){
		return height;
	}

	static Color color(int red, int green, int blue) {
		return new Color(red, green, blue);
	}

}
