package test21;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import exceptions.exceptionPorNumeroDeEntradaInvalida;
import exceptions.exceptionPorNumeroDeJogadoresInvalidos;
import models.Baralho;
import models.Jogador;
import models.Partida;

public class TestPartida {
	Partida partida = new Partida();
	Jogador j1 = new Jogador("Jogador1");
	Jogador j2 = new Jogador("Jogador2");

	@Test
	public void testAddJogador() {
		// quando
		partida.addJogador(j1);
		// então
		assertTrue(partida.getJogadores() != null);

	}

	@Test
	public void testIniciaPartida() throws exceptionPorNumeroDeJogadoresInvalidos, exceptionPorNumeroDeEntradaInvalida {
		// quando
		partida.addJogador(j1);
		partida.addJogador(j2);
		partida.init();
		// então
		assertTrue(j1.somaCarta() > 0);
	}

	@Test
	public void testPegaCarta() {
		// quando
		partida.iniciaBaralho();
		partida.addJogador(j1);
		partida.addJogador(j2);

		partida.pegaCarta(j1);
		partida.pegaCarta(j2);
		// então
		assertTrue(j1.getCartas().size() == 1 && j2.getCartas().size() == 1);
	}

	@Test
	public void testDistribuiCarta() {
		// quando
		partida.iniciaBaralho();
		partida.addJogador(j1);
		partida.addJogador(j2);
		partida.distribuiCarta();
		// então
		assertTrue(j1.getCartas().size() == 2 && j2.getCartas().size() == 2);
	}

	@Test
	public void testLimpaMao() {
		// quando
		partida.iniciaBaralho();
		partida.addJogador(j1);
		partida.addJogador(j2);
		partida.distribuiCarta();
		partida.limpaMao();
		// então
		assertTrue(j1.getCartas().size() == 0 && j2.getCartas().size() == 0);
	}

	@Test
	public void testTesteFimJogada() {
		// quando
		partida.iniciaBaralho();
		partida.addJogador(j1);
		partida.addJogador(j2);
		partida.distribuiCarta();
		partida.testeFimJogada(j1, 0);
		partida.testeFimJogada(j2, 0);
		// então
		assertTrue(j1.getFimJogada() && j2.getFimJogada());
	}

	@Test
	public void testVez() throws exceptionPorNumeroDeEntradaInvalida {
		// quando
		partida.iniciaBaralho();
		partida.addJogador(j1);
		partida.addJogador(j2);
		partida.distribuiCarta();
		partida.vez();
		// então
		assertTrue(j1.getFimJogada() && j2.getFimJogada());
	}

}
