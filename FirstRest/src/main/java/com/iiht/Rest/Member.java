package com.iiht.Rest;


//java -jar
public class Member {
	
	private String gender;
	private String name;
	
	public Member() {}

	public Member(String gender, String name) {
		super();
		this.gender = gender;
		this.name = name;
	}

	public String getgender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	};
}
