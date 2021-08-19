package com.moncept.test;

//In this example code as new enemy ships were needed
//conditionals were added and then subclasses when
//the original code didn't work.

//With the adapter pattern we can create a new class
//without disturbing any other code. On top of that
//adapters make it easier to swap in code at runtime.
//They also allow you to communicate with code using
//method names that make sense to you.

public class EnemyShip {

	protected String name;
	private int attackPower;
	protected int spacesMovedPerTurn;

	public EnemyShip(int currentLevel) {

		if (currentLevel <= 5) {

			name = "Galax";
			this.attackPower = 5;
			this.spacesMovedPerTurn = 2;

		} else if (currentLevel > 5 || currentLevel < 10) {

			name = "Galaxian";
			this.attackPower = 10;
			this.spacesMovedPerTurn = 3;

		} else if (currentLevel > 10) {

			name = "Galaxian Prime";
			this.attackPower = 15;
			this.spacesMovedPerTurn = 4;

		}

	}

	public void moveShip() {

		System.out.println(name + " moves " + spacesMovedPerTurn + " spaces");

	}

	public void makeShipAttack() {

		System.out.println(name + " does " + attackPower + " damage");

	}

	public static void main(String[] args) {

		EnemyShip level1Ship = new EnemyShip(6);

		level1Ship.moveShip();
		level1Ship.makeShipAttack();

		GalaxianPrime primeTime = new GalaxianPrime(15);

		primeTime.moveShip();
		primeTime.makeShipAttack();

	}

}

class GalaxianPrime extends EnemyShip {

	public GalaxianPrime(int currentLevel) {
		super(currentLevel);
	}

	public void moveShip() {

		System.out.println(name + " turns on forcefield and moves " + spacesMovedPerTurn + " spaces");

	}

}

//This is the interface the client works with
//The adapter makes sure new classes are
//compatible with it

interface Enemy {

	public void moveShip();

	public void makeShipAttack();

}

class Galax implements Enemy {

	private int attackPower = 5;
	private int spacesMovedPerTurn = 2;

	public void moveShip() {

		System.out.println("Galax moves " + spacesMovedPerTurn + " spaces");

	}

	public void makeShipAttack() {

		System.out.println("Galax does " + attackPower + " damage");

	}

}

//This is the adaptee. The Adapter will call the right 
//methods here when they are called on the Enemy interface

class GalaxPrime {

	protected String name = "Galaxian Prime";
	private int attackPower = 15;
	protected int spacesMovedPerTurn = 4;

	public void turnOnForceField() {

		System.out.println(name + " turns on force field");

	}

	public void warpToSpace() {

		System.out.println(name + " warps " + spacesMovedPerTurn + " spaces");

	}

	public void chargePhasers() {

		System.out.println(name + " charges phasers");

	}

	public void firePhasers() {

		System.out.println(name + " fires phasers for " + attackPower + " damage");

	}

}

//The adapter can provide completely different 
//actions for the methods implemented

//The adapter contains an object of the same 
//type as adaptee, so all calls sent to 
//the Enemy are sent to methods of the adaptee

class EnemyAdapter implements Enemy {

	GalaxPrime galaxPrime;

	public EnemyAdapter(GalaxPrime galaxPrime) {
		super();
		this.galaxPrime = galaxPrime;
	}

	public void moveShip() {

		galaxPrime.turnOnForceField();
		galaxPrime.warpToSpace();

	}

	public void makeShipAttack() {

		galaxPrime.chargePhasers();
		galaxPrime.firePhasers();

	}

}

class TestEnemyAdapter {

	public static void main(String[] args) {

		Enemy galax = new Galax();

		GalaxPrime galaxPrimeAdaptee = new GalaxPrime();

		Enemy galaxPrime = new EnemyAdapter(galaxPrimeAdaptee);

		// Test a regular Enemy

		galax.moveShip();
		galax.makeShipAttack();

		System.out.println();

		// Test an adapted Enemy

		galaxPrime.moveShip();
		galaxPrime.makeShipAttack();

	}

}