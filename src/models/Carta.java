package models;

public class Carta {
	
	private Naipe naipe;
	private int valor;
	private Tipo tipo;
	
	public Carta(Naipe naipe, Tipo tipo, int valor) {
		setNaipe(naipe);
		setTipo(tipo);
		setValor(valor);
	}
	
	public Naipe getNaipe() {
		return naipe;
	}
	public void setNaipe(Naipe naipe) {
		this.naipe = naipe;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\t[] " + getTipo() + " de " + getNaipe() + "\n";
	}
	
}
