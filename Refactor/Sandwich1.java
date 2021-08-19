package com.moncept.test;

//The Builder Pattern allows you to build complex
//objects in a series of steps. 

public class Sandwich1 {
	
	private String bread = "";
	private String vegetables = "";
	private String meat = "";
	private String cheese = "";
	private String condiments = "";
	
	public String getBread() {
		return bread;
	}
	public void setBread(String bread) {
		this.bread = bread;
	}
	public String getVegetables() {
		return vegetables;
	}
	public void setVegetables(String vegetables) {
		this.vegetables = vegetables;
	}
	public String getMeat() {
		return meat;
	}
	public void setMeat(String meat) {
		this.meat = meat;
	}
	public String getCheese() {
		return cheese;
	}
	public void setCheese(String cheese) {
		this.cheese = cheese;
	}
	public String getCondiments() {
		return condiments;
	}
	public void setCondiments(String condiments) {
		this.condiments = condiments;
	}
	
	public String toString(){
		
		return getBread() + " " + getVegetables() + " " + getMeat() +
				" " + getCheese() + " " + getCondiments();
		
	}

}