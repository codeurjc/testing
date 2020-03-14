package es.codeurjc.test.ejem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Calculadora1Test {

  @Test
  public void testSuma() {

    // Arrange / Given
    Calculadora calculadora = new Calculadora();

    // Act / When
    double res = calculadora.suma(1, 1);

    // Assert / Then
    assertEquals(2, res, 0);
  }
}