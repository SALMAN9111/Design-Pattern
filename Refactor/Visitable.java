package com.moncept.test;

//Allows the Visitor to pass in an object
//so the right calculations are done
//depending on the object type

//accept() is in each employee object. Those
//employee objects then pass an object of their 
//specific type to a concrete visitor. The concrete 
//visitors contain a method named visit that is
//overloaded to handle each of the employee types
//and can then perform different calculations based
//on the employee type.

interface Visitable {

	public double accept(Visitor visitor);
	
}