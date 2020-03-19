package es.codeurjc.test.ejem;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.mockito.ArgumentMatchers.anyLong;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import es.codeurjc.test.alumno.DBAlumno;
import es.codeurjc.test.gestor.GestorNotas;

public class MockTest {

	@Test
	public void testNotaMedia() {
		DBAlumno db = mock(DBAlumno.class);
		when(db.getNotasAlumno(anyLong())).thenReturn(Arrays.asList(5.0f, 6.0f, 8.0f, 9.0f));
		
		GestorNotas gestor = new GestorNotas(db);
		
		assertThat(gestor.calculaNotaMedia(0)).isCloseTo(7.0f, within(0.5f));
	}

}
