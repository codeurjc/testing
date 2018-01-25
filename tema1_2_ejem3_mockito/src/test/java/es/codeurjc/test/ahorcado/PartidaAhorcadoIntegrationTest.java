package es.codeurjc.test.ahorcado;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import es.codeurjc.test.ahorcado.PartidaAhorcado.Resultado;

public class PartidaAhorcadoIntegrationTest {
	
	@Test
	public void testPartidaGanada() {
		
		Consola consola = mock(Consola.class);
		
		when(consola.leerString()).thenReturn("Pepe", "T", "E", "S", "T");
		
		Jugador jugador = new Jugador(consola);
		jugador.leeNombre();
		
		PartidaAhorcado partida = new PartidaAhorcado("TEST");
		
		Resultado resultado = partida.jugarPartida(jugador);
		
		assertThat(resultado).isEqualTo(Resultado.PALABRA_ACERTADA);
	}
	
	@Test
	public void testPartidaPerdida() {
		
		Consola consola = mock(Consola.class);
		
		when(consola.leerString()).thenReturn("Pepe", "N", "I", "U", "N", "A", "L", "T", "R", "A");
		
		Jugador jugador = new Jugador(consola);
		jugador.leeNombre();
		
		PartidaAhorcado partida = new PartidaAhorcado("TEST");
		
		Resultado resultado = partida.jugarPartida(jugador);
		
		assertThat(resultado).isEqualTo(Resultado.AHORCADO);
	}

}
