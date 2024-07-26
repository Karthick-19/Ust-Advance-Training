package com.iiht.RestTest;


import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test/")
public class Test {
	
	@GetMapping
	public ResponseEntity<String> genderMessage2(@RequestHeader HttpHeaders headers) {
		headers.setContentType(MediaType.TEXT_HTML);
		headers.set("Ust","Gamma Training");
		headers.set("Accepted-language","ta");

		//Getting the value of Accepted language
		String acceptedLanguage = headers.getFirst("Accepted-Language");
		//Passing the acceptedLanguages variable in getMessages method which uses getResourceBundle
		ResourceBundle messages = getMessagesBundle(acceptedLanguage);
		
		//After getting the specific properties file based on the mentioned language which mapped to the locale
		//we are accessing the greeting.message in the properties
		String greetingMessage = messages.getString("greeting.message");
		
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body("Language change: "+greetingMessage);
	}

	private ResourceBundle getMessagesBundle(String acceptedLanguage) {
		//Default Locale if provided locale is not a valid one
		Locale locale = Locale.ENGLISH;
		
		//If acceptedLanguage is not null we set the locale with respect to the mentioned language
		if(acceptedLanguage != null) {
			locale = Locale.forLanguageTag(acceptedLanguage);
		}
		
//		getBundle(baseName, locale, callerModule), 
//		Parameters:•baseName the base name of the resource bundle, a fully qualified class name
//		•locale the locale for which a resource bundle is desired
		return ResourceBundle.getBundle("message",locale);
	}
}
