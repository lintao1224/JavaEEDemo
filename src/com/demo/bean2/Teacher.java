package com.demo.bean2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("myTeacher")
public class Teacher {
	@Value("Õı¿œ ¶")
	private String name;
	@Value("31")
	private int age;
	@Resource(name="mySchool")
	private School mySchool;
	
	
	
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + ", mySchool=" + mySchool.getName() + "]";
	}
}
