package models;

import java.util.ArrayList;
import java.util.List;

public class Ranking {
	private List<Jogador> vitorias;

	public Ranking() {
		vitorias = new ArrayList<Jogador>();
	}

	// Adiciona um jogador a lista de vitorias.
	public void addVitoria(Jogador j) {
		vitorias.add(j);
	}

	// Retorna o numero de vitorias do jogador passado.
	public int retornaNumeroDeVitorias(Jogador j) {
		int cont = 0;
		for (Jogador aux : vitorias) {
			if (j.getNome().equals(aux.getNome())) {
				cont++;
			}
		}
		return cont;

	}

	// Retorna o numero de empates.
	public int retornaNumeroDeEmpates() {
		int cont = 0;
		for (Jogador aux : vitorias) {
			if (aux.getNome() == null) {
				cont++;
			}
		}
		return cont;
	}

}
