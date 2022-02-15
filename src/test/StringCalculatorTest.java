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
		assertEquals(1402, StringCalculator.add("554,848"));
		assertEquals(93, StringCalculator.add("1,92"));
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
	
	@Test
	void testAddWithMultipleInputAndMoreDigitNumbersString() {
		assertEquals(218, StringCalculator.add("52,8,94,3,55,6"));
		assertEquals(1012, StringCalculator.add("12,999,0,1"));
		assertEquals(42, StringCalculator.add("0,0,4,5,6,7,8,9,3"));
	}

}
