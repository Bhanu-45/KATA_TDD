package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculator.StringCalculator;

class StringCalculatorTest {

	@Test
	void testAddWithEmptyString() {
		assertEquals(0, StringCalculator.add(""));
	}
	
	@Test
	void testAddWithOneInputString() {
		assertEquals(6, StringCalculator.add("6"));
	}
	
	@Test
	void testAddWithTwoInputsString() {
		assertEquals(13, StringCalculator.add("5,8"));
		assertEquals(10, StringCalculator.add("1,9"));
		assertEquals(0, StringCalculator.add("0,0"));
	}
	
	@Test
	void testAddWithOneInputInvalidString() {
		assertEquals(-1, StringCalculator.add("."));
	}
	
	@Test
	void testAddWithTwoInputInvalidString() {
		assertEquals(-1, StringCalculator.add(".,8"));
		assertEquals(-1, StringCalculator.add("1,."));
		assertEquals(-1, StringCalculator.add("',k"));
	}

}
