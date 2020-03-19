package es.codeurjc.test.ahorcado;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import es.codeurjc.test.ahorcado.PartidaAhorcado.Resultado;

public class PartidaAhorcadoSolitaryTest {

	@Test
	public void testPartidaGanada() {
		
		//Given
		Consola consola = mock(Consola.class);
		when(consola.leerString()).thenReturn("A");

		Jugador jugador = mock(Jugador.class);
		when(jugador.getNombre()).thenReturn("X");
		when(jugador.getConsola()).thenReturn(consola);
		
		Horca horca = mock(Horca.class);
		when(horca.haPerdido()).thenReturn(false);
		
		Palabra palabra = mock(Palabra.class);
		when(palabra.letraOcultaEnPalabra(any())).thenReturn(true);
		when(palabra.palabraCompleta()).thenReturn(false, false, false, true);

		PartidaAhorcado partida = new PartidaAhorcado(palabra, horca);

		//When
		Resultado resultado = partida.jugarPartida(jugador);

		//Then
		assertThat(resultado).isEqualTo(Resultado.PALABRA_ACERTADA);
		
		verify(consola, times(4)).leerString();
		verify(horca, never()).aniadirParteCuerpo();
		verify(horca, never()).haPerdido();
		verify(palabra, times(4)).palabraCompleta();
	}

	@Test
	public void testPartidaPerdida() {

		//Given
		Consola consola = mock(Consola.class);
		when(consola.leerString()).thenReturn("A");

		Jugador jugador = mock(Jugador.class);
		when(jugador.getNombre()).thenReturn("X");
		when(jugador.getConsola()).thenReturn(consola);
		
		Horca horca = mock(Horca.class);
		when(horca.haPerdido()).thenReturn(false, false, false, true);

		Palabra palabra = mock(Palabra.class);
		when(palabra.letraOcultaEnPalabra(any())).thenReturn(false);
		when(palabra.palabraCompleta()).thenReturn(false);

		PartidaAhorcado partida = new PartidaAhorcado(palabra, horca);

		//When
		Resultado resultado = partida.jugarPartida(jugador);

		//Then
		assertThat(resultado).isEqualTo(Resultado.AHORCADO);
		
		verify(consola, times(4)).leerString();
		verify(horca, times(4)).aniadirParteCuerpo();
		verify(horca, times(4)).haPerdido();
		verify(palabra, never()).palabraCompleta();		
	}

}
