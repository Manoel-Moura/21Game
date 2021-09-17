package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exceptions.exceptionPorNumeroDeEntradaInvalida;
import exceptions.exceptionPorNumeroDeJogadoresInvalidos;

public class Partida {

	Scanner teclado = new Scanner(System.in);

	private Ranking placar = new Ranking();
	private Baralho baralho;
	private List<Jogador> jogadores;
	private int cartaDoTopo;

	// Construtor que já inicia a lista de jogadores
	public Partida() {
		jogadores = new ArrayList<Jogador>();
	}

	// Inicia o baralho para realização de testes
	public void iniciaBaralho() {
		baralho = new Baralho();
	}

	// Adiciona um jogador a lisra de jogadores
	public void addJogador(Jogador j) {
		jogadores.add(j);
	}

	// Adiciona a carta do topo do baralho ao jogador
	public void pegaCarta(Jogador j) {
		j.pegaCarta(baralho.cartaDoTopo(cartaDoTopo));
		j.somaCarta();
		cartaDoTopo++;
	}

	// Inicia uma partida
	public void init() throws exceptionPorNumeroDeJogadoresInvalidos, exceptionPorNumeroDeEntradaInvalida {
		if (jogadores.size() >= 2) {
			iniciaBaralho();
			cartaDoTopo = 0;
			limpaMao();
			distribuiCarta();
			vez();
			vencedor();
			printPlacar();
		} else {
			throw new exceptionPorNumeroDeJogadoresInvalidos();
		}
	}

	// Instância um novo objeto de cartasEmMaos e nega que o jogador já terminou sua
	// vez
	public void limpaMao() {
		for (Jogador j : jogadores) {
			j.maosLimpas();
			j.setFimJogada(false);
		}
	}

	// Entrega duas cartas para cada jogador no inicio da partida
	public void distribuiCarta() {
		for (int i = 0; i < 2; i++) {
			for (Jogador j : jogadores) {
				pegaCarta(j);
			}
		}

	}

	// Menu para comprar ou passar a vez
	private int escolha(Jogador jogador) throws exceptionPorNumeroDeEntradaInvalida {
		int escolha = 1;

		System.out.println("\n" + jogador.getNome() + " [" + jogador.getSoma() + "] Pontos");
		jogador.mostraMao();
		System.out.println("\n[1]\t Comprar\n" + "[0]\t Passar\n");
		escolha = teclado.nextInt();
		if (escolha != 1 && escolha != 0)
			throw new exceptionPorNumeroDeEntradaInvalida();

		return escolha;

	}

	/*
	 * Percorre a lista de jogadores dando a opção de compra ou passar a vez, até
	 * que o jogador passe a vez ou sua pontuação ser igual ou maior que 21.
	 */
	public void vez() throws exceptionPorNumeroDeEntradaInvalida {

		for (Jogador jogador : jogadores) {

			while (!jogador.getFimJogada()) {

				try {
					int escolha = escolha(jogador);
					if (escolha == 1) {
						pegaCarta(jogador);
					}
					testeFimJogada(jogador, escolha);
				} catch (exceptionPorNumeroDeEntradaInvalida e) {
					System.err.println("Entrada invalida!");
				}

			}

			System.out.println("\n" + jogador.getNome() + " [" + jogador.getSoma() + "] Pontos");
			jogador.mostraMao();

		}
	}

	// Testa se todos enceram sua vez
	private boolean fimPartida() {
		int fimPartida = 0;

		for (Jogador j : jogadores) {

			if (j.getFimJogada()) {
				fimPartida++;
			}
		}
		if (fimPartida == jogadores.size()) {
			return true;
		}
		return false;

	}

	// Adiciona a vitoria
	private boolean vencedor() {

		if (fimPartida()) {
			placar.addVitoria(resultado());
			return true;
		}
		return false;
	}

	// Encerra a jogada caso jogador escolha ou sua pontuação sejá igual ou maior
	// que 21 pontos.
	public void testeFimJogada(Jogador j, int escolha) {
		if (j.getSoma() == 21) {
			for (Jogador j2 : jogadores) {
				j2.setFimJogada(true);
			}
		} else if (j.getSoma() < 21 && escolha == 0) {
			j.setFimJogada(true);
		} else if (j.getSoma() > 21) {
			j.setFimJogada(true);
		}

	}

	// Busca o Vencedor da partida
	public Jogador resultado() {
		int maiorPontuacao = 0;
		Jogador jogador = new Jogador();

		for (Jogador j : jogadores) {
			if (j.getSoma() > maiorPontuacao && j.getSoma() <= 21) {
				jogador = j;
				maiorPontuacao = j.getSoma();
			}
		}
		if (jogador.getNome() == null) {
			System.out.println("Empate \n");
		}

		return jogador;
	}
	

	public void printPlacar() {
		System.out.println(" ");
		for (Jogador j : jogadores) {
			System.out.println(j.getNome() + " Vitorias: " + placar.retornaNumeroDeVitorias(j));

		}
		if(jogadores.size() == 0)
			System.out.println("Lista de jogadores vazia!");
		System.out.println("Empate: " + placar.retornaNumeroDeEmpates());

	}
	
	public void printPlacarFimPartida() {
		System.out.println(" ");
		int cont = 0;
		for (Jogador j : jogadores) {
			int Nvitorias = placar.retornaNumeroDeVitorias(j);
			if(Nvitorias != 0)
				System.out.println(j.getNome() + " Vitorias: " + Nvitorias);
				cont++;

		}
		if(jogadores.size() == 0)
			System.out.println("Lista de jogadores vazia!");
		if(cont == 0 && jogadores.size() != 0)
			System.out.println("Nenhum jogador venceu!");
		System.out.println("Empate: " + placar.retornaNumeroDeEmpates());

	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

}
