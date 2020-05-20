package com.piglatin.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PigLatinServiceTest {

	PigLatinService pigLatinService = new PigLatinService();

	@Test()
	void testTranslateInLatin() {
		String input = "Rahul";
		String expected = "Rahul";
		assertEquals(expected, pigLatinService.translateInLatin(input));
	}

}
