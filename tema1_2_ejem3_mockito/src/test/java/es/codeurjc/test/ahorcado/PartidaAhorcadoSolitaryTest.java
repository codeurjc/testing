package es.codeurjc.test.ahorcado;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.*;

import org.junit.Test;

import es.codeurjc.test.ahorcado.PartidaAhorcado.Resultado;

public class PartidaAhorcadoSolitaryTest {

	@Test
	public void testPartidaGanada() {

		Consola consola = mock(Consola.class);

		when(consola.leerString()).thenReturn("A");

		Jugador jugador = new Jugador(consola);
		jugador.leeNombre();

		Horca horca = mock(Horca.class);
		Palabra palabra = mock(Palabra.class);

		when(horca.haPerdido()).thenReturn(false);
		when(palabra.letraOcultaEnPalabra(any())).thenReturn(true);
		when(palabra.palabraCompleta()).thenReturn(false, false, false, true);

		PartidaAhorcado partida = new PartidaAhorcado(palabra, horca);

		Resultado resultado = partida.jugarPartida(jugador);

		verify(consola, times(5)).leerString();
		verify(horca, never()).aniadirParteCuerpo();
		verify(horca, never()).haPerdido();
		verify(palabra, times(4)).palabraCompleta();

		assertThat(resultado).isEqualTo(Resultado.PALABRA_ACERTADA);
	}

	@Test
	public void testPartidaPerdida() {

		Consola consola = mock(Consola.class);

		when(consola.leerString()).thenReturn("A");

		Jugador jugador = new Jugador(consola);
		jugador.leeNombre();

		Horca horca = mock(Horca.class);
		Palabra palabra = mock(Palabra.class);

		when(horca.haPerdido()).thenReturn(false, false, false, true);
		when(palabra.letraOcultaEnPalabra(any())).thenReturn(false);
		when(palabra.palabraCompleta()).thenReturn(false);

		PartidaAhorcado partida = new PartidaAhorcado(palabra, horca);

		Resultado resultado = partida.jugarPartida(jugador);

		verify(consola, times(5)).leerString();
		verify(horca, times(4)).aniadirParteCuerpo();
		verify(horca, times(4)).haPerdido();
		verify(palabra, never()).palabraCompleta();

		assertThat(resultado).isEqualTo(Resultado.AHORCADO);
	}

}
