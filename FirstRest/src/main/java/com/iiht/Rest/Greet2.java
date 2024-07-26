package com.iiht.Rest;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/api/v2")
public class Greet2 {
	
	@GetMapping("message")
	public ResponseEntity<?> message() {
		return new ResponseEntity<>("Vanakkam Makkale",HttpStatus.OK);
	}
	
	@GetMapping("time")
	public ResponseEntity<?> getTime() {
//		return new ResponseEntity<>(Calendar.getInstance().getTime()+": Time", HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(Calendar.getInstance().getTime()+"");
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
	
	@PostMapping
	@RequestMapping("/nameGender")
	public ResponseEntity<String> genderMessage(@RequestBody Member member){
//		member.setGender("Male");
		return ResponseEntity.status(HttpStatus.CREATED).body(
				"Member name: "+member.getName()+"\nMember Gender: "+member.getgender());
	}
	
	@PostMapping
	@RequestMapping("/nameGender2")
	public ResponseEntity<String> genderMessage2(Member member){
		member.setName("Kyle");
		member.setGender("Male");
		return ResponseEntity.status(HttpStatus.CREATED).body(
				"Member name: "+member.getName()+"\nMember Gender: "+member.getgender());
	}
	
	@GetMapping
	@RequestMapping("/namegender/{name}/{gender}")
	public ResponseEntity<String> genderMessage2(@RequestHeader HttpHeaders headers,@PathVariable String name,@PathVariable String gender) {
		headers.setContentType(MediaType.TEXT_HTML);
		Set<String> set = headers.keySet();
		Iterator<String> keys = set.iterator();
		
		String keyStr = null;
		while(keys.hasNext()) {

			keyStr += keys.next()+"\n";
		}
		
		String keyValueStr = null;
		Set<Entry<String,List<String>>> entries = headers.entrySet();
		
		Iterator iter2 = entries.iterator();
		
		while(iter2.hasNext()) {
			keyValueStr += iter2.next()+"<br/>";
		}
		
		headers.set("Ust","Gamma Training");
		
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(keyValueStr);
	}
}
