package com.engenha;

import java.util.ArrayList;
import java.util.Random;

public class Cenario {
	Terreno tipoTerreno;
	String descricao, outside;
	int [] tamanho = {Tela.getWidth(),Tela.getHeight()};
	public ArrayList<Sala> salas;
	public ArrayList<Personagem> personagens;
	int[] posicaoInicial = {10,10};
	boolean acabouDeEntrar = true;


	Cenario (String d, String o, Terreno terr, int posX, int posY){
		descricao = d;
		tipoTerreno = terr;
		posicaoInicial[0] = posX;
		posicaoInicial[1] = posY;
		outside = o;
		salas = new ArrayList<Sala>();
		personagens = new ArrayList<>();

		// DETECTAR SE TEM SALA INICIAL OU NÃO. SE EM ALGUM MOMENTO FOR DEFINIDA A SALA INICIAL, FILTRAR PARA QUE AS POSIÇÕES POSSÍVEIS SEJAM SOMENTE DENTRO DAS SALAS
	}

	public void addSala(Sala s){
		salas.add(s);
	}

	public void update(){

		// CAMADA DE FUNDO: O CHÃO / TERRENO DO CENÁRIO
		for ( int j=0 ; j<tamanho[1] ; j++ )
			  for ( int i=0 ; i<tamanho[0] ; i++ )
			  		Tela.setTile(i, j, tipoTerreno );

		// PRÓXIMA CAMADA: O CHÃO E PAREDES DAS SALAS
		for ( int i=0 ; i<salas.size() ; i++ )
			salas.get(i).update();

		// VERIFICANDO SE CHEGOU NA SAÍDA DA SALA
		int sala = salaAtual();
		if ( sala!=0 ) acabouDeEntrar = false;

		if ( sala>=0 && salas.size()>0 )
		if ( salas.get(sala).descricao=="o curandeiro" ) Jogador.stats.curar();
		else if ( salas.get(sala).descricao=="a ferraria" ){
			Tela.quest[0] = "Olá amigo! Infelizmente não tenho armas pra vender... Os goblins invadiram minha mina, a sudeste.";
			Tela.quest[1] = "Se você matar todos os goblins lá, eu posso te recompensar";
		} else {
			Tela.quest[0] = "";
			Tela.quest[1] = "";
		}

		if ( !acabouDeEntrar ){
			// PRÓXIMA SALA
			if ( sala == salas.size()-1 ) {
				if ( Main.arton.canGoNextCenario() ) {
					int x = Jogador.posicao[0]<=1 ? Tela.width-2 : (Jogador.posicao[0]>=Tela.width-2 ? 1 : Jogador.posicao[0]);
					int y = Jogador.posicao[1]<=1 ? Tela.height-2 : (Jogador.posicao[1]>=Tela.height-2 ? 1 : Jogador.posicao[1]);

					Jogador.posicao[0] = -1;
					Jogador.posicao[1] = -1;
					Main.arton.nextCenario(x, y);
				}
			} else // SALA ANTERIOR
			if ( sala==0 ){
				if ( Main.arton.canGoPrevCenario() ){
					int x = Jogador.posicao[0]<=1 ? Tela.width-2 : (Jogador.posicao[0]>=Tela.width-2 ? 1 : Jogador.posicao[0]);
					int y = Jogador.posicao[1]<=1 ? Tela.height-2 : (Jogador.posicao[1]>=Tela.height-2 ? 1 : Jogador.posicao[1]);

					Jogador.posicao[0] = -1;
					Jogador.posicao[1] = -1;
					Main.arton.prevCenario(x, y);
				}
			}
		}
	}

	public void playerEnter(){
		Jogador.mover(posicaoInicial);
		Jogador.update();
		acabouDeEntrar = true;
	}
	public void playerEnter(int x, int y){
		int[] pos = { x, y };
		Jogador.mover(pos);
		Jogador.update();
		acabouDeEntrar = true;
	}

	public String descricaoSalaAtual(){
		int s = salaAtual();
		return s==-1 ? outside : salas.get(s).descricao;
	}

	public int salaAtual() {
		int x = Jogador.posicao[0], y = Jogador.posicao[1];

		for (int i = 0; i < salas.size(); i++) {
			Sala s = salas.get(i);
			if (x >= s.posicao[0] && x < s.posicao[0] + s.tamanho[0] && y >= s.posicao[1] && y < s.posicao[1] + s.tamanho[1])
				return i;
		}
		return -1;
	}

	public int salaAtual(int x, int y){
		for (int i = 0; i < salas.size(); i++) {
			Sala s = salas.get(i);
			if (x >= s.posicao[0] && x < s.posicao[0] + s.tamanho[0] && y >= s.posicao[1] && y < s.posicao[1] + s.tamanho[1])
				return i;
		}
		return -1;
	}

	public String descrever(){
		return "Você está n" + descricao + ", n" + descricaoSalaAtual();
	}

	public void addNPC(int spriteIndex){
		Personagem p = new Personagem(spriteIndex);

		Random r = new Random();
		int x = r.nextInt(Tela.width);
		int y = r.nextInt(Tela.height);

		while( salaAtual()!=-1 ){
			x = r.nextInt(Tela.width);
			y = r.nextInt(Tela.height);
		}
		p.posicao[0] = x;
		p.posicao[1] = y;

		personagens.add(p);
	}

}
