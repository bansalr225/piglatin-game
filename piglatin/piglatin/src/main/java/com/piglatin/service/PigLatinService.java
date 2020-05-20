package com.piglatin.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class PigLatinService {

	public String translateInLatin(String sentence) {
		validate(sentence);
		return sentence;
	}

	private void validate(String sentence) {
		if (sentence == null || StringUtils.isEmpty(sentence))
			throw new NullPointerException("Sentence can't be null !!");
	}

}
