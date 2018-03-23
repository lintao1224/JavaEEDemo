package com.demo.bean2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myStudent")
public class Student {
	@Value("ÍõÎå")
	private String name;
	@Value("21")
	private int age;
	@Autowired
	private School mySchool;
	
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", mySchool=" + mySchool.getName() + "]";
	}

}
