package test21;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import models.Baralho;

public class TestBaralho {
	Baralho baralho = new Baralho();

	@Test
	public void testIniciaBaralho() {
		// quando
		baralho.iniciaBaralho();
		// então
		assertTrue(baralho.getBaralho().size() == 0);
	}

	@Test
	public void testPreencheBaralho() {
		// quando
		baralho.iniciaBaralho();
		baralho.preencheBaralho();
		// então
		assertTrue(baralho.getBaralho().size() == 52);
	}
	
	@Test
	public void testEmbaralhaBaralho() {
		// quando
		baralho.iniciaBaralho();
		baralho.preencheBaralho();
		baralho.embaralhar();
		
		// então
		assertTrue(baralho.getBaralho().get(0) != baralho.cartaDoTopo(0));
	}
	
	@Test
	public void testCartaDo() {
		// quando
		baralho.iniciaBaralho();
		baralho.preencheBaralho();
		baralho.embaralhar();
		
		// então
		assertTrue(baralho.getBaralho().get(0) != baralho.cartaDoTopo(0));
	}


}
