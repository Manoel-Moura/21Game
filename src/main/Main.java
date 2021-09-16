package main;

import java.util.Scanner;

import exceptions.exceptionPorNomeInvalido;
import exceptions.exceptionPorNumeroDeEntradaInvalida;
import exceptions.exceptionPorNumeroDeJogadoresInvalidos;
import models.Partida;
import models.Ui;

public class Main {

	public static void main(String[] args) throws exceptionPorNumeroDeJogadoresInvalidos, exceptionPorNumeroDeEntradaInvalida {
		Scanner teclado = new Scanner(System.in);
		int escolha;

		Partida partida = new Partida();
		Ui ui = new Ui(partida);

		do {
			ui.menuPartida();
			escolha = teclado.nextInt();

			switch (escolha) {
			case 0: {
				partida.printPlacar();
				break;
			}
			case 1: {
				iniciaPartida(ui, partida);
				break;
			}
			case 2: {
				addJogador(ui);
				break;
			}
			default:
				System.err.println("[ERRO] Entrada invalida!");
			}

		} while (escolha != 0);
		teclado.close();

	}

	private static void addJogador(Ui ui) {
		try {
			ui.menuAddJogador();
		} catch (exceptionPorNomeInvalido e) {
			System.err.println("\n[ERRO] Esse nome já está sendo usado!");
		}

	}

	private static void iniciaPartida(Ui ui, Partida partida) throws exceptionPorNumeroDeEntradaInvalida {
		try {
			partida.init();
		} catch (exceptionPorNumeroDeJogadoresInvalidos e) {
			System.err.println("[ERRO] É necesario ao menos 2 jogadores para iniciar a partida!");
		}

	}

}
