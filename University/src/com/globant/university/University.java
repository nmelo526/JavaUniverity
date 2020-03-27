package com.globant.university;

import java.util.ArrayList;
import java.util.List;

public class University {

	private String name;
	private List<Student> studentList;
	private List<Course> courseList;
	private List<Teacher> teacherList;
	
	public University(String name) {
		this.name=name;
		this.studentList=new ArrayList<Student>();
		this.teacherList=new ArrayList<Teacher>();
		this.courseList=new ArrayList<Course>();
	}

	public void addTeacher(Teacher teacher) {
		teacherList.add(teacher);
	}

	
	public void addStudent(Student student) {
		studentList.add(student);
		
	}

	public void addCourse(Course course) {
		courseList.add(course);
		
	}

	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<Student> getStudentList() {
		return this.studentList;
	}
	

	public List<Teacher> getTeacherList() {
		return this.teacherList;
	}
	
	public List<Course> getCourseList() {
		return this.courseList;
	}
	

	public List<Course> getCourseListByStudent(int studentId) {
		
		List<Course> courseListByStudent = new ArrayList<Course>();
		List<Student> studentInList = new ArrayList<Student>();
		Course course;
		
		for (int i = 0 ; i < this.courseList.size(); i++) {
			course = this.courseList.get(i);
			studentInList = course.getStudentList();
			
			for(int j = 0; j < studentInList.size(); j++) {
				if(studentInList.get(j).getId()==studentId) {
					courseListByStudent.add(course);
					j = studentInList.size();
				}
			}
		}
		
		return courseListByStudent;
	}

	
	public List<Student> getStudentListByCourse(int courseId){
		
		return courseList.get(courseId).getStudentList();
	}

	public Student getStudentById(int id) {
		
		for (int i=0 ; i<this.studentList.size(); i++) {
			if (this.studentList.get(i).getId()==id) {
				return this.studentList.get(i);
			}
		}
		return null;
		
	}

}
