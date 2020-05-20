package com.piglatin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piglatin.service.PigLatinService;

@RestController()
public class PiglatinController {

	@Autowired
	private PigLatinService pigLatinService;

	@RequestMapping(value = "/piglatin", method = RequestMethod.GET)
	public String translateInLatin(@RequestParam String sentence) {
		return pigLatinService.translateInLatin(sentence);
	}

}
