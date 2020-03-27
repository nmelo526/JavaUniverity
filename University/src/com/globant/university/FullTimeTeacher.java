package com.globant.university;

public class FullTimeTeacher extends Teacher {

	public FullTimeTeacher() {
		super();
	}

	
	public FullTimeTeacher(String name, int yearsOfExperience) {
		super(name, yearsOfExperience);
	}

	@Override
	public String StringInfo() {
		// TODO Auto-generated method stub
		return ("Teacher type Fulltime name:"+ this.getName() + " Years of experience: " + this.getYearsOfExperience() + " Salary:" + this.calculateSalary() );
	}

	@Override
	public double calculateSalary() {
		double cSalary;
		
		cSalary = (this.getYearsOfExperience() * this.getPorcentage());
		
		return cSalary;
	}

}
