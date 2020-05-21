package com.piglatin.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class PigLatinService {

	public String translateInLatin(String sentence) {
		validate(sentence);
		// Split the sentence/paragraph from space.
		String[] words = sentence.split(" ");
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (StringUtils.isEmpty(word) || "".equals(word.trim()))
				continue;
			String modifiedString = "";
			if (isWordContainsHyphen(word)) {
				String[] hyphenSpilletedWords = word.split("-");
				for (int j = 0; j < hyphenSpilletedWords.length; j++) {
					if (j == hyphenSpilletedWords.length - 1)
						modifiedString += modiFyTheWord(word);
					else
						modifiedString += modiFyTheWord(word) + "-";
				}
			} else
				modifiedString = modiFyTheWord(word);
			words[i] = modifiedString;
			return words.toString();
			// return getFinalStringFromWords(words);
		}
		return sentence;
	}

	private String getFinalStringFromWords(String[] words) {
		String finalString = "";
		for (int i = 0; i < words.length; i++) {
			if (i == words.length - 1)
				finalString += words[i];
			else
				finalString += words[i] + " ";
		}
		return null;
	}

	/**
	 * This method is used to modify the word after check all given conditions.
	 * 
	 * @param word
	 * @return it's return final modified pig latin.
	 */
	private String modiFyTheWord(String word) {
		switch (checkConditions(word)) {
		case 1: {
			if (containsPuctuation(word))
				return puctuationContainedModifiedWord(word, "ay", 1);
			else
				return addSpecialWord(word, "ay", 1);
		}
		case 2: {
			if (containsPuctuation(word))
				return puctuationContainedModifiedWord(word, "way", 2);
			else
				return addSpecialWord(word, "way", 2);
		}
		case 3: {
			return word;
		}

		default:
			return word;
		}
	}

	/**
	 * This method is using for to add special word based on condition like after
	 * checking that word start with vowel or consonant.
	 * 
	 * @param word
	 * @param specialWord
	 * @param rule
	 * @return returning with adding special word based on condition
	 */
	private String addSpecialWord(String word, String specialWord, int rule) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method is using for punctuation contained word to add special word based
	 * on condition like after checking that word start with vowel or consonant.
	 * 
	 * @param word
	 * @param specialWord
	 * @param rule
	 * @return returning with adding special word based on condition
	 */
	private String puctuationContainedModifiedWord(String word, String specialWord, int rule) {
		return null;
	}

	/**
	 * Will check that word may or may not contains punctuation char.
	 * 
	 * @param word
	 * @return
	 */
	private boolean containsPuctuation(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Checking word start with vowel or consonant.
	 * 
	 * @param word
	 * @return
	 */
	private int checkConditions(String word) {
		char c = word.charAt(0);
		if (word.length() >= 3 && "way".equalsIgnoreCase(word.substring(word.length() - 3)))
			return 3;
		else if ('a' == c || 'A' == c || 'e' == c || 'E' == c || 'i' == c || 'I' == c || 'o' == c || 'O' == c
				|| 'u' == c || 'U' == c)
			return 2;
		else
			return 1;
	}

	/**
	 * Checking that word contains hyphen or not.
	 * 
	 * @param word
	 * @return
	 */
	private boolean isWordContainsHyphen(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Validating the string
	 * 
	 * @param sentence
	 * @throws NullPointerException
	 */
	private void validate(String sentence) throws NullPointerException {
		if (StringUtils.isEmpty(sentence) || "".equals(sentence.trim()))
			throw new NullPointerException("Invalid string !!");
	}

}
