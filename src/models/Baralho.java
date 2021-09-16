package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baralho {
	private List<Carta> baralho;
	private List<Integer> valores = new ArrayList<Integer>();
	private Random gerador = new Random();

	public Baralho() {
		iniciaBaralho();
		preencheBaralho();
		embaralhar();
	}

	public void iniciaBaralho() {
		baralho = new ArrayList<Carta>();
	}

	// Testa se o valor passado já está no vetor valores
	private int testa(int val) {

		for (int ant : valores) {
			if (val == ant) {
				val = gerador.nextInt(52);
				return testa(val);
			}
		}
		return val;
	}

	// Preenche a lista valores ramdomicamente
	public List<Integer> embaralhar() {
		int val;
		valores = new ArrayList<Integer>();
		for (int i = 0; i < 52; i++) {
			val = gerador.nextInt(52);
			valores.add(testa(val));
		}
		return valores;
	}

	// Imprime baralho
	public void imprimeBaralho() {
		if (valores.isEmpty()) {
			for (Carta valor : baralho) {
				System.out.println(valor.toString());
			}
		} else {
			for (int valor : valores) {
				System.out.println(baralho.get(valor).toString());
			}
		}

	}

	
	public void preencheBaralho() {
		Naipe[] naipes = Naipe.values();
		Tipo[] tipos = Tipo.values();
		for (int j = 0; j < 4; j++) {
			Naipe n = naipes[j];
			for (int valorDaCarta = 0; valorDaCarta < 13; valorDaCarta++) {
				Tipo k = tipos[valorDaCarta];
				
				if (valorDaCarta > 9) {
					Carta carta = new Carta(n, k, 10);
					baralho.add(carta);
				} else {
					Carta carta = new Carta(n, k, valorDaCarta + 1);
					baralho.add(carta);
				}

			}
		}
	}

	// Retorna carta do topo
	public Carta cartaDoTopo(int val) {
		int aux = getValores().get(val);
		return baralho.get(aux);
	}

	public List<Integer> getValores() {
		return valores;
	}

	protected void setValores(List<Integer> valores) {
		this.valores = valores;
	}

	public List<Carta> getBaralho() {
		return baralho;
	}

	public void setBaralho(List<Carta> baralho) {
		this.baralho = baralho;
	}
}
