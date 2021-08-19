package com.moncept.test;

public class ATMAccessBad {

	private String state;

	public final static String CARD_ENTERED = "CARD ENTERED";
	public final static String VALID_CARD = "VALID CARD";
	public final static String VALID_PIN = "VALID PIN";
	public final static String VALID_CASH_REQUEST = "VALID CASH REQUEST";
	public final static String DENIED = "DENIED";

	public final static int CARD_NUMBER = 123456789;
	public final static int PIN_NUMBER = 1234;
	public final static double CARD_BALANCE = 1000.00;

	public ATMAccessBad() {
		state = CARD_ENTERED;
	}

	public void verifyCard(int cardNumber) {

		if (CARD_NUMBER == cardNumber) {
			state = VALID_CARD;
		} else
			state = DENIED;

	}

	public void verifyPIN(int pinNumber) {

		if (PIN_NUMBER == pinNumber) {
			state = VALID_PIN;
		} else
			state = DENIED;

	}

	public void verifyWithdrawalAmount(double withdrawalRequest) {

		if (CARD_BALANCE > withdrawalRequest) {
			state = VALID_CASH_REQUEST;
		} else
			state = DENIED;

	}

	public static void main(String[] args) {

		ATMAccessBad user = new ATMAccessBad();

		System.out.println(user.state);

		user.verifyCard(123456789);

		System.out.println(user.state);

		user.verifyPIN(1234);

		System.out.println(user.state);

		user.verifyWithdrawalAmount(99);

		System.out.println(user.state);

	}

}