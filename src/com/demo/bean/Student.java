package com.demo.bean;

public class Student {

	private String name;
	private int age;
	private School mySchool;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public School getMySchool() {
		return mySchool;
	}
	public void setMySchool(School mySchool) {
		this.mySchool = mySchool;
	}
	public Student(String name, int age, School mySchool) {
		super();
		this.name = name;
		this.age = age;
		this.mySchool = mySchool;
	}
	public Student() {
		super();
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", mySchool=" + mySchool.getName() + "]";
	}

}
