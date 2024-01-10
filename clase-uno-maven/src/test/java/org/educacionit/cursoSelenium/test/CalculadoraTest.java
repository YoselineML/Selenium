package org.educacionit.cursoSelenium.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	void testSumar() {
		int a = - 2;
		int b = - 5;
		int res = a+b;
		assertEquals(- 7, res) ;
	}

}
