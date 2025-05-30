package com.dino.student;

public class Student {
	private String studentId;
	private String name;
	private int age;

	public Student(String studentId, String name, int age) {
		this.studentId = studentId;
		this.name = name;
		this.age = age;
	}

	public String getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public void setAge(int newAge) {
		this.age = newAge;
	}
}
