package com.iiht.Rest;
import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/api/")
public class Greet {
	
	@GetMapping("message")
	public String message() {
		return "Vanakkam";
	}
	
	@GetMapping("time")
	public String getTime() {
		return Calendar.getInstance().getTime()+"";
	}
	
	@GetMapping
	@RequestMapping("gender/{gender}")
	public String genderReveal(@PathVariable String gender) {
		return gender.equals("Male") ? "It is a boy" : gender.equals("Female") ? "It is a girl" : "Only god can save you";
	}
	
	@GetMapping
	@RequestMapping("greetGender/{name}/{gender}")
	public String greetGender(@PathVariable String name,@PathVariable String gender) {
		return gender.equals("Male") ? "Welcome Mr."+name : gender.equals("Female") ? "Welcome Ms."+name : "Welcome"+name;
	}
	
}
