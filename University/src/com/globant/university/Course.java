package com.globant.university;

import java.util.ArrayList;
import java.util.List;

public class Course {

	private String name;
	private int classroom;
	private List<Student> studentList;
	private Teacher teacher;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	
	public Course(String name, int classroom, Teacher teacher) {
		this.setName(name);
		this.setClassroom(classroom);
		this.setTeacher(teacher);
		this.setStudentList(new ArrayList<Student>());
	
	}

	
	public Course(String name, int classroom, Teacher teacher, List<Student> studentList) {
		this.setName(name);
		this.setClassroom(classroom);
		this.setTeacher(teacher);
		this.setStudentList(new ArrayList<Student>());
		this.setStudentList(studentList);
	
	}
	
	public void addStudentToList(Student student) {
		for (int i=0; i<this.studentList.size(); i++) {
			if (student.getId()==this.studentList.get(i).getId() ) {
				return;
			}
		
		}
		this.studentList.add(student);
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getClassroom() {
		return classroom;
	}


	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}


	public List<Student> getStudentList() {
		return studentList;
	}


	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}


	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	

}
