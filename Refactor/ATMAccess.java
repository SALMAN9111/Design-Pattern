package com.moncept.test;

//Type safety is very important. 
//We want to eliminate all operations on values that 
//are not of the appropriate data type by protecting
//the program from bad input.

//We can do this by replacing primitive types with classes

public class ATMAccess {

	// Define a type safe field

	private ATMCardState cardState;

	private void setState(ATMCardState cardState) {

		this.cardState = cardState;

	}

	public ATMAccess() {

		// Create type safe assignment

		setState(ATMCardState.CARD_ENTERED);

	}

	public String getState() {

		// REPLACED return state;

		return cardState.toString();

	}

	// 1. Encapsulation is used

	public void verifyCard(int cardNumber) {

		if (getState().equals(ATMCardState.CARD_ENTERED.toString())) {

			if (cardNumber == ATMCardState.CARD_NUMBER) {

				// Create type safe assignment

				setState(ATMCardState.VALID_CARD);

			} else {
				setState(ATMCardState.DENIED);
			}
		}

	}

	public void verifyPIN(int pinNumber) {

		if (getState().equals(ATMCardState.VALID_CARD.toString())) {

			if (pinNumber == ATMCardState.PIN_NUMBER) {

				// Create type safe assignment

				setState(ATMCardState.VALID_PIN);

			} else {
				setState(ATMCardState.DENIED);
			}
		}

	}

	public void verifyWithdrawalAmount(double withdrawalRequest) {

		if (getState().equals(ATMCardState.VALID_PIN.toString())) {

			if (withdrawalRequest <= ATMCardState.CARD_BALANCE) {

				// Create type safe assignment

				setState(ATMCardState.VALID_CASH_REQUEST);

			} else {
				setState(ATMCardState.DENIED);
			}
		}

	}

	public static void main(String[] args) {

		ATMAccess user = new ATMAccess();

		System.out.println(user.getState());

		user.verifyCard(123456789);

		System.out.println(user.getState());

		user.verifyPIN(1234);

		System.out.println(user.getState());

		user.verifyWithdrawalAmount(1000);

		System.out.println(user.getState());

	}

}

//Represents the state of a ATMAccess object

class ATMCardState {

	private final String name;

	private ATMCardState(String name) {

		this.name = name;

	}

	public String toString() {

		return name;

	}

	// These type safe constants live in the class and can't be impersonated

	public final static ATMCardState CARD_ENTERED = new ATMCardState("CARD ENTERED");
	public final static ATMCardState VALID_CARD = new ATMCardState("VALID CARD");
	public final static ATMCardState VALID_PIN = new ATMCardState("VALID PIN");
	public final static ATMCardState VALID_CASH_REQUEST = new ATMCardState("VALID CASH REQUEST");
	public final static ATMCardState DENIED = new ATMCardState("DENIED");

	public final static int CARD_NUMBER = 123456789;
	public final static int PIN_NUMBER = 1234;
	public final static double CARD_BALANCE = 1000.00;

}