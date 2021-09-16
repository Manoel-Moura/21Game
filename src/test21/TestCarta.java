package test21;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.Carta;
import models.Naipe;
import models.Tipo;

public class TestCarta {
	
	@Test
	public void testaddCarta() {
		//dado
		Carta carta = new Carta(Naipe.Paus, Tipo.A,1); // A de paus
		// quando
		boolean naipe = carta.getNaipe() == Naipe.Paus;
		boolean tipo = carta.getTipo() == Tipo.A;
		boolean valor = carta.getValor() == 1;
		// então
		assertTrue(naipe && tipo && valor);
	}

}
