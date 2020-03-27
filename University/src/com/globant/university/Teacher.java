package com.globant.university;

public abstract class Teacher {
	
	
	private static double baseSalary= 2000;
	private static int porcentage=110;
	private String name;
	private int yearsOfExperience;
	private double hoursPerWeek;
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public Teacher(String name, int yearsOfExperience) {
		this.setName(name);
		this.setYearsOfExperience(yearsOfExperience);
	}

	public Teacher(String name, double hoursPerWeek) {
		this.setName(name);
		this.setHoursPerWeek(hoursPerWeek);
	}
	
	abstract public double calculateSalary();

	public double getBaseSalary() {
		return baseSalary;
	}

	public int getPorcentage() {
		return porcentage;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(double hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}
	
	public abstract String StringInfo();
	

	
}
