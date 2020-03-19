package es.codeurjc.test.ahorcado;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import es.codeurjc.test.ahorcado.PartidaAhorcado.Resultado;

public class PartidaAhorcadoSocialTest {

	private Consola mockConsola() {

		Consola consola = mock(Consola.class);

		doAnswer(invocation -> {
			System.out.println(invocation.getArguments()[0]);
			return null;
		}).when(consola).print(anyString());

		doAnswer(invocation -> {
			System.out.println(invocation.getArguments()[0]);
			return null;
		}).when(consola).println(anyString());

		return consola;
	}

	@Test
	public void testPartidaGanada() {

		// Given
		Consola consola = mock(Consola.class);
		when(consola.leerString()).thenReturn("T", "E", "S", "T");

		Jugador jugador = new Jugador(consola);

		PartidaAhorcado partida = new PartidaAhorcado("TEST");

		// When
		Resultado resultado = partida.jugarPartida(jugador);

		// Then
		assertThat(resultado).isEqualTo(Resultado.PALABRA_ACERTADA);
		
		verify(consola, times(3)).leerString();		
	}

	@Test
	public void testPartidaPerdida() {

		// Given
		Consola consola = mockConsola();
		
		when(consola.leerString()).thenReturn("N", "I", "U", "N", "A", "L", "T", "R", "A");

		Jugador jugador = new Jugador(consola);

		PartidaAhorcado partida = new PartidaAhorcado("TEST");

		// When
		Resultado resultado = partida.jugarPartida(jugador);

		// Then
		assertThat(resultado).isEqualTo(Resultado.AHORCADO);
		
		verify(consola, times(6)).leerString();		
	}

}
