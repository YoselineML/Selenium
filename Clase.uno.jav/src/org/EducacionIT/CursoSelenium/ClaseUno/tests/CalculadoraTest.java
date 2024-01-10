package org.EducacionIT.CursoSelenium.ClaseUno.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	void testSumar() {
		int a = 10;
		int b = 15;
		int res = a + b;
		assertEquals(25, res);
	}

	@Test
	void testRestar() {
		int a = 10;
		int b = 5;
		int res = a - b;
		assertEquals(5, res);
	}
}
