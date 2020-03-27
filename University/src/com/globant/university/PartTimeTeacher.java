package com.globant.university;

public class PartTimeTeacher extends Teacher{

	public PartTimeTeacher() {
		super();
	}

	
	public PartTimeTeacher(String name, double hoursPerWeek) {
		super(name, hoursPerWeek);
	}
	
	@Override
	public double calculateSalary() {
		return (double) (this.getBaseSalary() * this.getHoursPerWeek()); 
	}


	@Override
	public String StringInfo() {
		// TODO Auto-generated method stub
		return ("Teacher type Parttime name:"+ this.getName() + " Hours per week: " + this.getHoursPerWeek() + " Salary: " + this.calculateSalary() );
	}

}
