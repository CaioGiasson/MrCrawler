package com.engenha;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends JPanel implements ActionListener {

    public static Mundo arton;
    public static JFrame f = new JFrame();

	static Terreno [] sprites = {
			new Terreno("Madeira",1,0 , "assets/tile-wood.jpeg"),
			new Terreno("Calcada",1,0 , "assets/tile-rock.jpeg"),
			new Terreno("Floresta",3,0,"assets/tile-grass.jpeg"),
			new Terreno("Caverna",2,0,"assets/tile-cave.jpeg"),
			new Terreno("Jogador",2,0,"assets/char-pj.png"),
			new Terreno("Aliado",2,0,"assets/char-ally.png"),
			new Terreno("Inimigo",2,0,"assets/char-enemy.png"),
	};

    public Main(){
		addKeyListener(new Controle());
		setFocusable(true);
	}

    public static void main(String[] args) {
		// GERANDO O FRAME PRA DEPOIS MOSTRAR TUDO
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setSize(1000, 700);
		f.setLocationRelativeTo(null);
		f.add(new Main());
		f.setVisible(true);

        arton = new Mundo();

        // PRIMEIRO CENARIO
        Cenario c1 = new Cenario("a cidade", "as ruas da cidade", sprites[1], 5, 10 );
        c1.addSala(new Sala("o curandeiro", 2,2, sprites[0]));
        c1.addSala(new Sala("a ferraria", 12,12, sprites[0]));
        c1.addSala(new Sala("o mercadinho", 0,18, sprites[0]));
        c1.addSala(new Sala("a guilda", 24,4, sprites[0]));
        c1.addSala(new Sala("a taverna", 35,8, sprites[0]));
		c1.addSala(new Sala("a saída", 28,22, sprites[2]));
        c1.salas.get(1).setSize(12,6);
        c1.salas.get(4).setSize(20,8);
		c1.salas.get(5).setSize(5,2);
		c1.salas.get(0).addNPC(5);
		c1.salas.get(1).addNPC(5);
		c1.salas.get(2).addNPC(5);
		c1.salas.get(3).addNPC(5);
		c1.salas.get(4).addNPC(5);
		c1.addNPC(5);
		c1.addNPC(5);
		c1.addNPC(5);
        arton.addCenario(c1);

        // SEGUNDO CENARIO
        Cenario c2 = new Cenario("a floresta", "uma trilha", sprites[2],30,0);
		c2.addSala(new Sala("a entrada", 28,0, sprites[0]));
		c2.addSala(new Sala("a saída", 38,16, sprites[3]));
		c2.salas.get(0).setSize(5, 2);
		c2.salas.get(1).setSize(2,5);
		c2.addNPC(6);
		c2.addNPC(6);
		c2.addNPC(6);
		c2.addNPC(6);
		c2.addNPC(6);
		c2.addNPC(6);
        arton.addCenario(c2);

        //TERCEIRO CENARIO
        Cenario c3 = new Cenario("a caverna", "um dos vários túneis", sprites[3],0,16);
        c3.addSala(new Sala("a entrada", 0,16, sprites[2]));
        c3.addSala(new Sala("um dos vários túneis", 2,16, sprites[1]));
        c3.addSala(new Sala("um dos vários túneis", 10,16, sprites[1]));
        c3.addSala(new Sala("um dos vários túneis", 20,17, sprites[1]));
		c3.addSala(new Sala("um dos vários túneis", 28,9, sprites[1]));
		c3.addSala(new Sala("um dos vários túneis", 26,5, sprites[1]));
		c3.addSala(new Sala("um dos vários túneis", 35,8, sprites[1]));
		c3.addSala(new Sala("um dos vários túneis", 33,15, sprites[1]));
		c3.addSala(new Sala("um dos vários túneis", 11,7, sprites[1]));
		c3.addSala(new Sala("um dos vários túneis", 4,3, sprites[1]));
		c3.addSala(new Sala("um dos vários túneis", 15,8, sprites[1]));
		c3.addSala(new Sala("um dos vários túneis", 16,11, sprites[1]));
		c3.salas.get(0).setSize(2,5);
		c3.salas.get(1).setSize(8,5);
		c3.salas.get(2).setSize(12,2);
		c3.salas.get(3).setSize(10,5);
		c3.salas.get(4).setSize(2,8);
		c3.salas.get(5).setSize(9,4);
		c3.salas.get(6).setSize(1,7);
		c3.salas.get(7).setSize(5,3);
		c3.salas.get(8).setSize(15,1);
		c3.salas.get(9).setSize(7,8);
		c3.salas.get(10).setSize(1,4);
		c3.salas.get(11).setSize(8,3);
		c3.salas.get(1).addNPC(6);
		c3.salas.get(1).addNPC(6);
		c3.salas.get(2).addNPC(6);
		c3.salas.get(3).addNPC(6);
		c3.salas.get(3).addNPC(6);
		c3.salas.get(4).addNPC(6);
		c3.salas.get(5).addNPC(6);
		c3.salas.get(6).addNPC(6);
		c3.salas.get(6).addNPC(6);
		c3.salas.get(7).addNPC(6);
		c3.salas.get(8).addNPC(6);
		c3.salas.get(9).addNPC(6);
		c3.salas.get(10).addNPC(6);
		c3.salas.get(11).addNPC(6);
		c3.salas.get(11).addNPC(6);
		c3.salas.get(9).addNPC(6);
		c3.salas.get(9).addNPC(6);
		c3.salas.get(9).addNPC(6);
		c3.salas.get(9).addNPC(6);
		c3.salas.get(9).addNPC(6);
		arton.addCenario(c3);

        EventQueue.invokeLater(new Runnable() {
            @Override public void run() {
                f.setVisible(true);
            }
        });

        Tela.frame.update();
    }

	public void paint(Graphics g) {
    	Tela.imprimir(g, this);
	}

	public void actionPerformed(ActionEvent e) {
		arton.update();
		Jogador.update();
    	repaint();
	}

    static public void update(){
        arton.update();
        Jogador.update();
        f.repaint();
    }
}
/*

ROGUELIKE EXPERIMENTO 1
Multiplayer AsciiArt Roguelike

- Temática: Fantasia Medieval sob ataque
- Combate: Turn based, cada jogador tem até 6 segundos pra fazer seu turno
- Narrativa: Escolha um dos lados: Alienígenas invasores, ou nativos usuários de magia
- Monstros: Cada lado tem como inimiga a facção oposta, porém, o mundo continua populado por lobos, goblins, trolls, etc.
- Equipamentos: Podem ser hi tech ou clássicos de fantasia medieval
- Movimentação: 8-way

RULESET
-> O jogo vai ser WEB. Um dos jogadores cria a campanha, com nome e senha. Os outros encontram a campanha pelo nome e registram nela usando a senha.
-> O criador da campanha decide se ela começa no lado invasor ou invadido.
-> O jogo será mundo aberto, e diferente de ADOM ou alguns outros roguelikes, os desafios não são maiores quanto mais longe da cidade "inicial", por que uma das N cidades será sorteada para ser a inicial do grupo a cada ciclo.
-> Na primeira execução o jogo "cria" um grupo de NPCs que serão os inimigos. Quando eles forem derrotados, o ciclo termina.
-> No novo ciclo, os jogadores fazem parte obrigatoriamente da facção oposta, e terão como inimigos os personagens do ciclo anterior.
-> Cada ciclo deve ter duração aproximada de UMA SESSÃO DE JOGO, portanto, algo entre duas e quatro horas, dependendo da concentração e habilidade dos jogadores.
-> O jogo terá contagem contínua de tempo para a campanha
-> O jogo deverá ter um sistema automatizado de geração de "rumores". Esses rumores serão coisas faladas pelos NPCs. Num ciclo, os jogadores encontrarão rumores relacionados ao ciclo passado, portanto, rumores como "Oh, um grupo de invasores passou pela cidade X no dia Y do mês Z, ano Tal"
-> Alguns rumores são falsos, e os jogadores precisam juntar vários rumores, e decidir para qual cidade ir.
-> No caminho eles precisam acampar pra recuperar energias, e encontrarão inimigos aleatórios.
-> O jogo terá "dia e noite".
-> As cidades serão dominadas por alguma das facções. Pra entrar em uma cidade dominada pela facção inimiga, é necessário entrar "de noite", ou com muito poder de fogo
-> Os personagens ganham XP, porém, a evolução é bem lenta. Dificilmente vão ganhar mais do que dois níveis por sessão.
-> Evitar batalhas usando diplomacia, furtividade, ou outras formas, rende a mesma recompensa.
-> Armas e/ou magias com dano em área causam dano a construções. NPCs podem ser mortos.
-> Todas as deformações no cenário são permanentes (destruição de estruturas, morte de NPCs, etc), porém, após algum tempo, elas são reconstruídas (sempre fica registro histórico de que "no ano TAL foi destruído esse prédio")
-> O mapa inicial não é procedural. Toda campanha começa "no mesmo mundo, no mesmo ano", mas cada uma vai transformar o mundo de maneira diferente.

MOVIMENTAÇÃO
-> Cada turno dura 6 segundos. Cada jogador tem somente UMA ação no seu turno. Essa ação pode ser movimento OU ataque.
-> Os personagens poderão ter habilidades aprendidas. As habilidades NÃO SÃO relacionadas a classes. Não há classes. Há apenas facções.
-> Cada vez que usa uma habilidade qualquer, ganha XP naquela habilidade, ficando melhor naquilo. Um cara que fique o tempo todo usando espada, fica fodão na espada.
-> Tudo custa "XP". Aumentar atributos, aprender habilidades, aumentar HP, aumentar Mana, etc
-> Cada jogador começa com uma "ficha limpa" e tem uma quantidade de XP inicial para usar na ficha, podendo inclusive comprar habilidades
-> Se um jogador DORMIR NO PONTO, e não fizer sua ação nos 6 segundos, ele simplesmente ficou parado no lugar. Se tiver um inimigo por perto, o personagem repete o ataque usado mais recentemente
-> Os jogadores podem dar "pause" a qualquer momento.
-> É necessário que 3/4 dos jogadores estejam online para jogar. Se mais do que 1/4 ficarem offline, o jogo fica pausado automaticamente. Os jogadores podem mexer na ficha livremente enquanto está pausado, e é recomendável que façam isso com o jogo pausado...
-> Altamente recomendado jogarem com audio via Skype.

O MAPA
-> Possui várias cidades, cada uma dominada por uma facção
-> Entrar em uma facção rival durante o dia faz vc ser atacado por geral

FACÇÕES
-> O "grupo boss" fica no final de alguma masmorra. Pode ser uma torre, um castelo, uma caverna, whatever. O grupo precisa chegar ao final dela pra combatê-los

MORTE
-> Quando um personagem morre, já era. Os outros podem pegar seu equipamento, que fica jogado no chão.
-> O grupo precisa ir pra uma cidade aliada e recrutar outro personagem na taverna. O jogador monta um novo personagem com a mesma quantidade de XP que tinha o antigo, porém, ouro inicial (apesar de o grupo poder ajudar com o loot, por que o jogo é cooperativo). Porém, ele perde experiência em skills

TELA
-> A tela será composta por caracteres, 80x50
-> A tela fica "centrada" na posição intermediária entre os jogadores. Se algum dos jogadores não quiser colaborar, o criador da sala pode bani-lo da sala.

ATRIBUTOS PRIMÁRIOS (JOGADOR PODE EDITAR GASTANDO PONTOS DE XP)

FORÇA 			10
DESTREZA 		10
VIGOR 			10
INTELIGÊNCIA		10

ATRIBUTOS SECUNDÁRIOS (JOGADOR NÃO PODE EDITAR, MAS SÃO CALCULADOS COM BASE NOS ATRIBUTOS PRIMÁRIOS E SKILLS)

HP 				VIGOR * 10 + SKILLS + ITENS
MANA 			INT * 10 + SKILLS + ITENS
DEFESA 			10 + DESTREZA + VIGOR + ARMADURA + ESCUDO + SKILLS + MAGIAS + ITENS
INICIATIVA 		INICIATIVA + ITENS + MAGIAS + SKILLS
ENERGIA 			VIGOR * 100 + SKILLS + ITENS + MAGIAS

EQUIPAMENTO
Cada personagem pode ter 1 arma de duas mãos, OU 1 arma de uma mão OU usar ataque desarmado
Cada personagem pode usar até 1 armadura

-> Usar uma arma que não tenha proficiência significa ter metade do ataque e do dano, tanto armas quanto magias
-> Usar uma armadura que não tenha proficiência significa ter o dobro do custo de energia para agir

Cada skill custa 5 XP
SKILLS DE PROFICIÊNCIA DE ATAQUE
Algumas skills não possuem hierarquia entre si
-> Ataque desarmado
-> Armas de uma mão
-> Armas de duas mãos
-> Duas armas
-> Armas improvisadas
-> Armas enormes
-> Armas de disparo
-> Armas de fogo
-> Armas de raio
-> Armas de arremesso
-> Armas naturais
-> Escudo
* COMPRAR UMA SKILL DE PROFICIÊNCIA DÁ +5 EM ATAQUE E DANO COM A DETERMINADA ARMA
* CADA ACERTO RENDE 1 XP. CHEGANDO EM 100, A SKILL GANHA NÍVEL, PORTANTO, +1 EM ATAQUE E DANO

Algumas skills podem ser compradas mais de uma vez
-> Vitalidade (+50 PV)
-> Reserva (+50 Mana)
-> Regeneração (Recupera 1PV por turno)
-> Recuperação arcana (Recupera 1 Mana por turno)
-> Life steal (Causar dano cura 10%, arredonda pra baixo)
-> Riqueza (+1000 gold, +100% gold de drops)
-> Especialista em escola (Gasta 1PM a menos pra manter e/ou conjurar magias daquela escola, mas nunca pra 0PM)
-> Sortudo (Rola novamente 1d20 entre os d20 de uma rolagem, ficando com o melhor dos dois resultados)


SKILLS DE COMBATE EM GERAL
-> Blink (4 quadradinhos)
-> Investida (3 quadradinhos)
-> Taunt (Provoca TODOS os alvos ao redor)
-> Fear (Assusta UM alvo)
-> Stun (Ataca UM alvo)
-> Empurrar (Empurra UM alvo 2 quadrados pra trás, e se bater em obstáculo, toma dano. Se o obstáculo for outro inimigo os dois tomam dano da colisão)
-> Ataque letal (Tira X do ataque, pra somar X no dano)
-> Ricochete (Arma de arremesso volta pra você)

SKILLS DE PERÍCIA
-> Furtividade (DES)
-> Picklock (DES)
-> Percepção (INT)
-> Lábia (INT)
-> Conhecimentos (INT)
* Ter uma perícia treinada concede +1d20 num teste daquela perícia
* Cada uso fornece 1 de XP, com 100 XP a perícia ganha nível, e cada nível extra dá +1d20

SKILLS GERAIS
-> Resiliente (Requer VIG15, +500 ENERGIA, +50% eficiência de descanso e comida, +1d20 em qualquer teste de vigor)
-> Incansável (Requer Resiliente e VIG20, Não precisa de descanso - exceto se quiser conjurar magias. Daí precisa de 1h de canalização. Ganha +1d20 em testes de vigor, não precisa se alimentar nem respirar)
-> Atlético (+10 em perícias baseadas em destreza e força, inclusive iniciativa)
-> Asas (Deslocamento de vôo, dois quadrados por turno, sem curvas entre cada um desses dois quadrados. Não consegue voar "parado", então precisa se deslocar ao menos 2 quadrados em linha, todo turno. Caso não especifique uma direção, segue dois quadrados na mesma direção adotada previamente)

PS: SKILLS SÃO SEMPRE CUMULATIVAS. Personagens com "Incansável" jogam +2d20 em testes de vigor, por que possuem incansável + resiliente

Outras skills possuem hierarquia entre si, cumprindo os requisitos
-> Armaduras leves > Armaduras médias (CON20) > Armaduras pesadas (CON30)
-> Magias simples > Magias intermediárias (INT20) > Magias avançadas (INT30) > Magias épicas (INT40)
* Skills de magia ganham 1XP pra cada uso da magia, acertando ou não, e com 100XP ganham nível. Cada nível concede uma magia conhecida a mais
* Skills de armadura ganham 1 XP a cada ataque evitado, e com 100XP ganham nível. Cada nível dá +3 de defesa

MAGIAS CONHECIDAS
1 pra cada nível em "Magias", cada nível adicional da skill ganha 1 magia conhecida
+1 magia conhecida pra cada 5 de inteligência

MONTAGEM DOS PERSONAGENS
-> Começa com 10 XP
-> Cada ponto de atributo custa 1 XP
-> Cada skill custa 5 XP
-> Começa com 500 de gold


MAGIAS EXISTENTES POSSUEM ESCOLAS. CADA VEZ QUE O CHAR USA UMA MAGIA DE UMA ESCOLA, GANHA XP NAQUELA ESCOLA
Lista de magias existentes, por escola.

Castar uma magia custa:
Básica: 5PM + 1PM por turno
Intermediária : 10PM + 2PM por turno
Avançada: 15PM + 3PM por turno
Épica: 20PM + 4PM por turno

ESCOLA ELEMENTAL FOGO
BÁSICAS:
	Raio de fogo > +2 ATK, +2 DANO
	Escudo de fogo > +2 DEF, 2 DANO A QUEM ATACA
	Brasas > 5 DANO EM QUEM PISAR
	Resistência a calor > Reduz 20 pontos de dano de fogo, no total (cumulativo, não por turno)
INTERMEDIÁRIAS
	Chamas > +5 ATK, +5 DANO, 1 quadradinho ao redor do alvo
	Armadura de fogo > +5 DEF, 5 DANO A QUEM ATACA
	Imolação > 10 DANO EM QUEM PISAR
	Proteção contra chamas > Reduz 10 pontos de dano de fogo POR TURNO
AVANÇADAS
	Bola de fogo > +10 ATK, +10 DANO, 2 quadradinhos ao redor do alvo
	Supernova > 10 de dano ao redor do conjurador
	Muralha de fogo > 20 de dano em quem passar
	Alma de fogo > Imune a fogo
ÉPICAS
	Incinerar > +30 ATK, +30 DANO, UM ÚNICO ALVO, MAS É FODÃO
	Onda de fogo > 20 DE DANO PRA UMA DIREÇÃO
	Avatar do fogo > Recupera 1/4 do dano causado por suas magias de fogo como PV, e 1/4 como Mana

ESCOLA ELEMENTAL VENTO
ESCOLA ELEMENTAL TERRA
ESCOLA ELEMENTAL ÁGUA
ESCOLA DO TEMPO
ESCOLA DA LUZ
ESCOLA DAS TREVAS
ESCOLA DO VOID
ESCOLA DE INVOCAÇÃO

FUTURAMENTE VAMOS IMPLEMENTAR ESCOLAS MISTAS, OU SEJA, ALGUMAS MAGIAS TEM PRÉ-REQUISITO O CARA TER NÍVEL X EM MAIS DE UMA ESCOLA

EQUIPAMENTO
ARMAS
	NOME					CATEGORIA				+ATAQUE			+DANO 		PREÇO
	Adaga					Arma de uma mão			+5				+1 			150
	Espada curta				Arma de uma mão			+4				+2			250
	Espada bastarda			Arma de duas mãos 		+3				+6			300
	Machado gigantesco		Arma enorme 				+1				+8			500
	Barril					Arma improvisada 			+3				+2 			30
	Cadeira					Arma improvisada 			+1				+4 			30
	Garrafa 					Arma improvisada			+5				+1 			15
	Manopla 					Ataque desarmado 			+5				+1			120
	Manopla com espinhos		Ataque desarmado 			+5				+3			250
	Arco 					Armas de disparo			+3				+3 			150
	Besta 					Armas de disparo	 		+3				+4 			300
	Pistola 					Armas de fogo 			+5 				+5 			1000
	Rifle 					Armas de fogo 			+8				+8			2000
	Kama 					Arma de uma mão 			+2 				+8 			400
	Pistola laser 				Arma de raio	 			+4 				+12			2000
	Rifle laser 				Arma de raio				+12				+4			2000
	Machadinha				Arma de arremesso 		+1				+4			20
	Azagaia					Arma de arremesso			+2				+6			50
	Chakram 					Arma de arremesso 		+0 				+5 			100

ARMADURAS
	NOME					CATEGORIA				DEF				HP			PREÇO
	Broquel 					Escudo+duas mãos			+2				+0			100
	Escudo de madeira 			Escudo 					+5 				+0 			200
	Escudo de aço 			Escudo 					+10 				+0 			350
	Escudo de torre			Escudo 					+15 				+0 			500
	Armadura de couro 		Armadura leve 			+4 				+30			100
	Peitoral de aço 			Armadura média 			+8 				+50 			200
	Cota de malha 			Armadura média 			+4 				+100 		250
	Armadura completa 		Armadura pesada 			+10				+100 		500
	Traje espacial 				Armadura média			+2				+150		800


EXEMPLO DE PERSONAGEM, COM 10 XP
Hank, o guarda
FOR 			10
DES 			15
VIG 			10
INT 			10
Proficiência em Arma de disparo

ATAQUE		15 + 3 ARCO + 5 SKILL DE PROFICIÊNCIA = +23
DANO 		15 + 3 ARCO + 5 SKILL DE PROFICIÊNCIA = +23
DEFESA 		15 + 10 = 25
HP 			100
MANA 		0
INICIATIVA 	1d20
EQUIPAMENTO:
CUSTO 	NOME
150 		Arco
GRANA EXTRA: 350 moedas


EXEMPLO DE MONSTRO

GOBLIN

FOR 			11
DES 			12
VIG 			12
INT 			10
PROFICIENCIA ARMA DE UMA MÃO

ATAQUE 		11 + 4 ESPADA + 5 SKILL = +20
DANO 		11 + 2 ESPADA + 5 SKILL = +18
DEFESA 		12+12 = 24
HP 			120
MANA 		0
INICIATIVA 	1d20
EQUIPAMENTO:
Espada curta


EQUAÇÃO DE ATAQUE:
ATAQUE: 1d20 pra cada 10 de ataque, e soma o excedente
DEFESA: 1d20 pra cada 10 de defesa, e soma o excedente
Compara os resultados, se o ataque empatar ou passar é um acerto.
Se acertar, causa 1d20 pra cada 10 do dano, e soma o excedente.

EXEMPLO HANK CONTRA O GOBLIN
ATAQUE DO HANK: 2d20 + 3
DEFESA DO GOBLIN: 2d20 + 4
DANO: 2d20+3

EXEMPLO GOBLIN CONTRA O HANK
ATAQUE DO GOBLIN: 2d20
DEFESA DO HANK: 2d20+5
DANO DO GOBLIN: 1d20+8




RAÇAS (Cada uma confere 10 pontos)
Humano: 2 skills extra
Goblin: T-1, DES+3, VIG+2, 1 skill de proficiência em arma
Elfo: DES +5, INT+2, CON-2, proficiência em arco OU Magias simples
Gnomo: T-1, INT+5, proficiência em Magias simples
Djinn: INT+5, Proficiência em magias
Draconiano: FOR+5, VIG+5, Tem armas naturais (2 garras, sem proficiência)
Walker: Tamanho da raça original, DES-2 FOR+2 Resiliente, Incansável
Eagle: Asas, VIG+5
Anão: VIG+5, Resiliente
Troll: FOR+5, Regeneração
Elementalista: Proficiência em magias simples e intermediárias
Abençoado: Sortudo, Abençoado
Orc: T+!, FOR+5, VIG+4, 1 skill de proficiência em arma, INT-3, DES-1
Meio-orc FOR+3, VIG+2, 1 skill de proficiência em arma
Hobgoblin: FOR+4, DES+2, VIG+2, 1 skill de proficiência em arma, INT-3
Minotauro: FOR+10
Centauro: T+1, FOR+3, VIG+4, INT-2, Armas naturais (2x cascos), com proficiência
Fauno: INT+5, VIG+5
Sprite: T-2, INT+5, DES+5, Proficiência em Magias simples, FOR-3, VIG-2
Dark elf:
Halfling:


SKILLS DE AMBIENTE






TAMANHO (T)
Normal: 0
Raças pequenas <0
Raças grandes >0

Carga que personagem carrega: FOR*3 + T*20, valor mínimo = FOR - T*2
Ataque: -T*5
Defesa: -T*5
Dano: +T*5
PV: +T*20
Furtividade: -T*10
Iniciativa: -T*10
Medir força: +T*10

Maiores:
+ Carga
+ Dano
+ PV
+ Perícia medir força

Menores:
+ Ataque
+ Defesa
+ Perícia Furtividade
+ Perícia iniciativa







Estrutura de objetos

Class raca
    string nome
    int For
    int Des
    arrayList Habilidades
    int Vig
    int BonusINT
    int tamanho

Class Mundo
	int tempo
	array list cenarios
	int cenario inicial

class Personagem
	int xp
	Int for, des, vig, int
	raça
	int	hp, mana, def, descanso, comida
	int 	arma atual
	int 	armadura atual
	int dinheiro

	array list habilidades
	array list inventario

	Personagem(for, des, vig, int, raça, habilidades, inventario)
	Personagem(int numeroPontos)

	usarEnergia(){
		desconto energia do personagem
		conto o tempo do mundo
	}
	subirEnergia(){
		somo energia do personagem
		conto o tempo do mundo
	}

class Acao
	int custoEnergia

class Ataque extends Acao

class Habilidade extends Acao


class Item
	String nome
	double peso
	int preco


class Arma extends Item
class Armadura extends Item
class Escudo extends Item
Class Consumiveis extends Item
	int energiaParaConsumir
	int danoCurado
	int bonusFOR, bonusDES
	int duracao

class Npc
class Lojista extends Npc

class Terreno
	String nome
	String descricao
	Int custoEnergia
	Int danoPorTurno

class Sala

	int [] tamanho
	Terreno terreno
    int x
    int y
    int [] Posiccao
class Cenario
	Terreno tipoTerreno
	int[] tamanho
	ArrayList<Sala> salas
	int [] posicaoInicial
	int salaInicial

Class Missao








    Vinícius (BSI) 41 99947-1627



 */
