package com.globant.university;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UniversityAdmin {
	

	private static Scanner input;
	private static Scanner input2;
	private static Scanner strName;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Initializing 1 University
		University university = new University("UNI Automation");
		
		//Initializing 4 teachers
		Teacher teacher1 = new FullTimeTeacher("Nelson Pérez", 12);
		Teacher teacher2 = new PartTimeTeacher("Juan Alvarez", 12);
		Teacher teacher3 = new FullTimeTeacher("Pedro Ramirez", 3);
		Teacher teacher4 = new PartTimeTeacher("Jorge Lopez", 16.5);
		
		//Initializing 10 students
		Student student1 = new Student("Robert Rodriguez", 1, 18);
		Student student2 = new Student("George Ramos", 22, 18);
		Student student3 = new Student("Steve Wolf", 3, 18);
		Student student4 = new Student("Bill Gates", 5, 18);
		Student student5 = new Student("Robert Rodriguez", 6, 18);
		Student student6 = new Student("Alan Touring", 12, 18);
		Student student7 = new Student("Jimmy Page", 34, 18);
		Student student8 = new Student("Erick Claptton", 78, 18);
		Student student9 = new Student("Jimmy Hendriks", 31, 18);
		Student student10 = new Student("Little Richard", 51, 18);
		
		//Initializing 4 classes 
		Course class1 = new Course("TAE for QC", 10, teacher4);
		Course class2 = new Course("Java Programming", 210, teacher3);
		Course class3 = new Course("Countinuos Integration", 15, teacher2);
		Course class4 = new Course("Sala ", 5, teacher1);
		
		class1.addStudentToList(student4);
		class1.addStudentToList(student10);
		class1.addStudentToList(student8);
		class1.addStudentToList(student3);
		class1.addStudentToList(student7);
		

		//Adding initialized objects to the university.
		university.addTeacher(teacher1);
		university.addTeacher(teacher2);
		university.addTeacher(teacher3);
		university.addTeacher(teacher4);
		
		university.addStudent(student1);
		university.addStudent(student2);
		university.addStudent(student3);
		university.addStudent(student4);
		university.addStudent(student5);
		university.addStudent(student6);
		university.addStudent(student7);
		university.addStudent(student8);
		university.addStudent(student9);
		university.addStudent(student10);
		
		university.addCourse(class1);
		university.addCourse(class2);
		university.addCourse(class3);
		university.addCourse(class4);
		
		
		//menu
		System.out.println("University: "  + university.getName());
		
		List<Teacher> teacherList = new ArrayList<Teacher>();
		List<Course> courseList = new ArrayList<Course>();
		List<Student> studentList = new ArrayList<Student>();
		List<Course> courseListByStudent = new ArrayList<Course>();
		Student student=new Student();
		Course course=new Course();
		Teacher teacher;

		int option =100;
		int option1=0;
		while (option != 0) {
			
			option = menu();

			
			
			switch (option) {
			case 1:
				teacherList=university.getTeacherList();
				for (int i=0; i<teacherList.size(); i++) {
					System.out.println( teacherList.get(i).StringInfo() );
				}
				break;
			case 2:
				courseList=university.getCourseList();
				for (int i=0; i<courseList.size(); i++) {
					System.out.println( "#" + (i+1)+ " Class Name: " + courseList.get(i).getName() );
				}
				
				System.out.println("Print class info ");
				System.out.println("Intro the number of class :");

				option1=subMenu();
				if (option1>0 && option1 <= courseList.size()) {
					option1=option1-1;
					
					System.out.println("#" + (option1+1)+ " Class Name: " + courseList.get(option1).getName() );
					System.out.println("Classroom: " + courseList.get(option1).getClassroom() + " Teacher: " + courseList.get(option1).getTeacher().StringInfo() );
					System.out.println();
					for (int i=0; i<courseList.get(option1).getStudentList().size(); i++) {
						System.out.println(" Student Id: " + courseList.get(option1).getStudentList().get(i).getId() + " name:" + courseList.get(option1).getStudentList().get(i).getName() + " Age:" + courseList.get(option1).getStudentList().get(i).getAge());
					}
				} else {
					System.out.println("Class does not exist");
					
				}
				
				break;
			case 3:
				student=createStudent();
				university.addStudent(student);
				System.out.println("Available Class list ");

				courseList=university.getCourseList();
				for (int i=0; i<courseList.size(); i++) {
					System.out.println( "#" + (i+1)+ " Class Name: " + courseList.get(i).getName() );
				}
				
				System.out.println("Intro the number of class to add the student:");
				option1=subMenu();
				if (option1>0 && option1 <= courseList.size()) {
					option1=option1-1;
					
					courseList.get(option1).addStudentToList(student);
					
				} else {
					System.out.println("Class does not exist");
					
				}
				
				break;
			case 4:
				//Create a new class and add a teacher, students and its relevant data
				course=createCourse();
				//Assign students
				System.out.println("Student list: ");
				studentList=university.getStudentList();
				for (int i=0; i<studentList.size(); i++) {
					System.out.println(" Student Id: " + studentList.get(i).getId() + " name:" + studentList.get(i).getName());
				}
				System.out.println("Intro student ID to add (0 to finish) :");
				option1=subMenu();
				do  {
					student=university.getStudentById(option1);
					System.out.println(student.getName());
					course.addStudentToList(student);
					option1=subMenu();
				} while (option1!=0);
				//Assign teacher
				teacherList=university.getTeacherList();
				for (int i=0; i<teacherList.size(); i++) {
					System.out.println("Code: "+ (i+1) +" Teacher name: " + teacherList.get(i).getName() + " Salary: " + teacherList.get(i).calculateSalary());
				}
				System.out.println("Intro teacher's code to add :");
				option1=subMenu();
				if (option1>0 && option1 <= university.getTeacherList().size()) {
					option=option-1;
					teacher=university.getTeacherList().get(option);
					System.out.println(teacher.getName());
					course.setTeacher(teacher);
				}
				university.addCourse(course);
				break;
			case 5:
				studentList=university.getStudentList();
				for (int i=0; i<studentList.size(); i++) {
					System.out.println(" Student Id: " + studentList.get(i).getId() + " name:" + studentList.get(i).getName());
				}
				System.out.println("List Classes by student ");
				System.out.println("Intro student ID :");
				option1=subMenu();
				courseListByStudent=university.getCourseListByStudent(option1);
				for(int i=0; i<courseListByStudent.size(); i++ ) {
					System.out.println(" Class Name: " + courseListByStudent.get(i).getName() + " Classroom: " + courseListByStudent.get(i).getClassroom());

				}
				
				break;
			case 0:
				//Quit menu
			default:
				System.out.println("Invalid selection. Select 1, 2, 3, 4, 5, 6, 7, 8, 9, or 0");				
			}
		}
		
		

	}
	
	public static int menu() {
		
		int selection;
		
		
		input = new Scanner(System.in);
		System.out.println("Menu ");
		System.out.println("Select an option:");
		System.out.println("1. Print all the profesors with their data");
		System.out.println("2. Print all the classes and a submenu to select a class in order to print the class data\r\n" + 
				"including its teacher and students");
		System.out.println("3. Create a new student and add it to an existing class");
		System.out.println("4. Create a new class and add a teacher, students and its relevant data");
		System.out.println("5. List all the classes in which a given student is included");
		System.out.println("0. Exit");
		System.out.println("");
		try {
			selection = input.nextInt();
		}
		catch (InputMismatchException e) {
			selection=100;
			System.out.println("Invalid input. Not an integer");
		}
		return selection;
		
	}

	
	public static int subMenu() {
		
		int selection;
		
		
		input2 = new Scanner(System.in);
		System.out.println("");

		try {
		selection = input2.nextInt();
		}
		catch(InputMismatchException e) {
			selection= -1;
			System.out.println("Invalid input. Not an integer");

		}
		return selection;
	}
	
	public static Student createStudent() {
		Student student = new Student();
		String name="";
		int id=0;
		int age=0;
		
		
		System.out.println("Create student");

		strName = new Scanner(System.in);
		
		input2 = new Scanner(System.in);

		try {
			System.out.println("Name:");
			name = strName.next();
		} 
		catch(InputMismatchException e) {

			System.out.println("Invalid input. Not an string");

		}

		
		try {
			
			System.out.println("Id:");
			id = input2.nextInt();
			
			System.out.println("Age:");
			age = input2.nextInt();
		
		}
		catch(InputMismatchException e) {

			System.out.println("Invalid input. Not an integer");

		}

		
		
		student.setId(id);
		student.setAge(age);
		student.setName(name);
		
		
		return student;
	}

	public static Course createCourse() {
		Course course;
		String name="";
		int classroom=0;
		
		
		System.out.println("Create course");

		System.out.println("Name:");
		strName = new Scanner(System.in);
		name = strName.next();
		
		System.out.println("# Classroom:");
		input2 = new Scanner(System.in);
		classroom = input2.nextInt();
		
		
		course = new Course(name, classroom, null);
		
		return course;

	}
}
