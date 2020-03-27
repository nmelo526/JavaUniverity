/**
 * 
 */
package com.globant.university;

/**
 * @author nelson.melo
 *
 */
public class Student {

	/**
	 * 
	 */
	private String name;
	private int id;
	private int age;
	
	public Student(String name, int id, int age) {
		
		this.setName(name);
		this.setId(id);
		this.setAge(age);
	
	}

	
	public Student() {
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	
}
