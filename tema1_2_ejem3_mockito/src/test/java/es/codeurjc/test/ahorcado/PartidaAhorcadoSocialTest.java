package es.codeurjc.test.ahorcado;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.swing.plaf.synth.SynthStyleFactory;

import org.junit.Test;

import es.codeurjc.test.ahorcado.PartidaAhorcado.Resultado;

public class PartidaAhorcadoSocialTest {
	
	private Consola mockConsola() {
		
		Consola consola = mock(Consola.class);
		
		doAnswer(invocation -> {
			System.out.println(invocation.getArguments()[0]);
			return null;
	    }).when(consola).print(org.mockito.ArgumentMatchers.anyString());
		
		doAnswer(invocation -> {
			System.out.println(invocation.getArguments()[0]);
			return null;
	    }).when(consola).println(org.mockito.ArgumentMatchers.anyString());
		
		return consola;
	}
	
	@Test
	public void testPartidaGanada() {
		
		Consola consola = mockConsola();
		
		when(consola.leerString()).thenReturn("Pepe", "T", "E", "S", "T");
		
		Jugador jugador = new Jugador(consola);
		jugador.leeNombre();
		
		PartidaAhorcado partida = new PartidaAhorcado("TEST");
		
		Resultado resultado = partida.jugarPartida(jugador);
		
		assertThat(resultado).isEqualTo(Resultado.PALABRA_ACERTADA);
	}
	
	@Test
	public void testPartidaPerdida() {
		
		Consola consola = mockConsola();
		
		when(consola.leerString()).thenReturn("Pepe", "N", "I", "U", "N", "A", "L", "T", "R", "A");
		
		Jugador jugador = new Jugador(consola);
		jugador.leeNombre();
		
		PartidaAhorcado partida = new PartidaAhorcado("TEST");
		
		Resultado resultado = partida.jugarPartida(jugador);
		
		assertThat(resultado).isEqualTo(Resultado.AHORCADO);
		
		verify(consola, times(7)).leerString();
	}

}
