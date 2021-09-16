package models;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

	private String nome;
	private List<Carta> cartasEmMaos;
	private boolean fimJogada = false;
	private int soma = 0;

	public boolean getFimJogada() {
		return fimJogada;
	}

	protected void setFimJogada(boolean fimJogada) {
		this.fimJogada = fimJogada;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Carta> getCartas() {
		return cartasEmMaos;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartasEmMaos = cartas;
	}

	public int getSoma() {
		return soma;
	}

	public void setSoma(int soma) {
		this.soma = soma;
	}

	// Instância um novo objeto de cartasEmMaos
	public void maosLimpas() {
		cartasEmMaos = new ArrayList<Carta>();
	}

	// Mostra as cartas na mão do jogador
	public void mostraMao() {
		for (Carta c : cartasEmMaos) {
			System.out.print(c.toString());
		}
	}

	// Adiciona uma carta do topo ao jogador
	public void pegaCarta(Carta c) {
		cartasEmMaos.add(c);
	}

	// Soma o valor dos pontos do jogador
	public int somaCarta() {
		soma = 0;
		for (Carta carta : cartasEmMaos) {
			this.soma += carta.getValor();
		}
		return this.soma;
	}

	public Jogador(String nome) {
		setNome(nome);
		maosLimpas();
	}

	public Jogador() {
	}

	@Override
	public String toString() {
		return "Nome: " + getNome() + "\n" + "Soma: " + getSoma() + "\n";
	}

}
