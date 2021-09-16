package models;

import java.util.Scanner;

import exceptions.exceptionPorNomeInvalido;

public class Ui {
	Scanner teclado = new Scanner(System.in);
	Partida p;

	public Ui(Partida p) {
		this.p = p;
	}

	// Apresenta o menu de inicio
	public void menuPartida() {
		System.out.println("\n========================");
		System.out.println("[1]\tIniciar Partida");
		System.out.println("[2]\tNovo Jogador");
		System.out.println("[0]\tSair");
		System.out.println("========================");
		System.out.print("Opção: ");
	}

	/** Apresenta o menu para adicionar jogador, testa se o nome do jogador já esta na lista. 
	    * Se estiver, lança uma exceptionPorNomeInvalido. 
	    * Se não, adiciona o jogador na partida. 
		*/
	public void menuAddJogador() throws exceptionPorNomeInvalido {
		int x = p.getJogadores().size();
		boolean nomeInvalido = false;
		System.out.println("\nJogador [" + p.getJogadores().size() + "]");
		System.out.print("Nome: ");
		String nome = teclado.nextLine();
		for (int i = 0; i < x; i++) {
			if (nome.equals(p.getJogadores().get(i).getNome())) {
				nomeInvalido = true;
			}
		}
		if (nomeInvalido) {
			throw new exceptionPorNomeInvalido();
		} else {
			p.addJogador(new Jogador(nome));
		}

	}

}
