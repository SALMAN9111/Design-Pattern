package com.moncept.test;


//This class defines attributes and capabilities 
//for each monster

public abstract class Monster {

	private String name;

	MonsterAttackPower attackPower;
	MonsterAttackRange attackRange;

	abstract void makeMonster();

	public void checkIfVictimIsInRange() {

		System.out.println(getName() + " checks if victim is " + attackRange);

	}

	public void attackTheVictim() {

		System.out.println(getName() + " attacks the victim for " + attackPower);

	}

	public String toString() {

		String infoOnMonster = getName() + " attacks anything " + attackRange + " for " + attackPower;

		return infoOnMonster;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

//Now since I defined these interfaces, anything
//that implements this interface can replace toString

interface MonsterAttackPower {

	public String toString();

}

//These replace toString for MonsterAttackPower

class BasicAttack implements MonsterAttackPower {

	public String toString() {

		return "10 in damage";

	}

}

class MediumAttack implements MonsterAttackPower {

	public String toString() {

		return "20 in damage";

	}

}

//Now I do the same for MonsterAttackRange

interface MonsterAttackRange {

	public String toString();

}

class BasicRange implements MonsterAttackRange {

	public String toString() {

		return "5 away";

	}

}

class MediumRange implements MonsterAttackRange {

	public String toString() {

		return "10 away";

	}

}

//Here I define the attributes for each monster
//and the methods that will define them

interface MonsterFactory {

	public MonsterAttackPower assignAttackPower();

	public MonsterAttackRange assignAttackRange();

}

//This defines the attack and range to assign to
//each Zombie created

class ZombieFactory implements MonsterFactory {

	public MonsterAttackPower assignAttackPower() {

		return new BasicAttack();

	}

	public MonsterAttackRange assignAttackRange() {

		return new BasicRange();

	}

}

//This defines the attack and range to assign to
//each Vampire created

class VampireFactory implements MonsterFactory {

	public MonsterAttackPower assignAttackPower() {

		return new MediumAttack();

	}

	public MonsterAttackRange assignAttackRange() {

		return new MediumRange();

	}

}

//A factory is sent into this class that will assign
//the right objects for attack and range to the Zombie

class Zombie extends Monster {

	// The type of attack & range to assign are past
	// into the constructor

	MonsterFactory monsterFactory;

	public Zombie(MonsterFactory monsterFactory) {
		this.monsterFactory = monsterFactory;
	}

	void makeMonster() {

		System.out.println("Making a Zombie");

		// These are stored in the Monster class

		attackPower = monsterFactory.assignAttackPower();
		attackRange = monsterFactory.assignAttackRange();

	}

}

//The same is done for the vampire

class Vampire extends Monster {

	// The type of attack & range to assign are past
	// into the constructor

	MonsterFactory monsterFactory;

	public Vampire(MonsterFactory monsterFactory) {
		this.monsterFactory = monsterFactory;
	}

	void makeMonster() {

		System.out.println("Making a Vampire");

		// These are stored in the Monster class

		attackPower = monsterFactory.assignAttackPower();
		attackRange = monsterFactory.assignAttackRange();

	}

}

//Now that I have Monsters defined, their individual attacks
//& ranges and I have a factory for making them I have to
//create a way to order them.

abstract class MonsterBuilder {

	protected abstract Monster makeMonster(String typeOfMonster);

	public Monster orderAMonster(String typeOfMonster) {

		Monster theMonster = makeMonster(typeOfMonster);

		// Test out the methods for the Monster

		theMonster.makeMonster();
		theMonster.checkIfVictimIsInRange();
		theMonster.attackTheVictim();

		return theMonster;

	}

}

class OrderAMonster extends MonsterBuilder {

	protected Monster makeMonster(String typeOfMonster) {

		Monster theMonster = null;

		if (typeOfMonster.equals("Zombie")) {

			// Create the factory that assigns the right attributes
			// to each Zombie

			MonsterFactory monsterFactory = new ZombieFactory();

			// Create a Zombie Monster that stores the Objects
			// specific for each zombie so they can be assigned
			// to this monster

			theMonster = new Zombie(monsterFactory);

			theMonster.setName("Zombie Bob");

		} else

		if (typeOfMonster.equals("Vampire")) {

			// Create the factory that assigns the right attributes
			// to each Vampire

			MonsterFactory monsterFactory = new VampireFactory();

			// Create a Vampire Monster that stores the Objects
			// specific for each Vampire so they can be assigned
			// to this monster

			theMonster = new Vampire(monsterFactory);

			theMonster.setName("Vampire Paul");

		}

		return theMonster;

	}

}

class MonsterMakerTest {

	public static void main(String[] args) {

		// Create a way to order new monsters

		MonsterBuilder monsterBuilder = new OrderAMonster();

		Monster zombie = monsterBuilder.orderAMonster("Zombie");

		// Makes a call to the toString method

		System.out.println(zombie + "\n");

		Monster vampire = monsterBuilder.orderAMonster("Vampire");

		System.out.println(vampire + "\n");

	}

}
