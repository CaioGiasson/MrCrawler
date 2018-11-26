package com.engenha;

import java.awt.event.*;

public class Controle extends KeyAdapter {

	public void keyPressed(KeyEvent kEve) {
		int key = kEve.getKeyCode();
		if (key == KeyEvent.VK_RIGHT) Jogador.andar(1,0);
		if (key == KeyEvent.VK_DOWN) Jogador.andar(0,-1);
		if (key == KeyEvent.VK_LEFT) Jogador.andar(-1,0);
		if (key == KeyEvent.VK_UP) Jogador.andar(0,1);

		Main.arton.update();
		Jogador.update();
		Main.f.repaint();
	}
}

