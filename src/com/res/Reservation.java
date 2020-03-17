package com.res;

import java.util.Scanner;

import exception.DateException;
import exception.TypeException;

public abstract class Reservation {
	
	String name;
	String email;
	int numOfPeople;
	double cost;
	
		
	public void getDetails() throws TypeException, DateException{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name:");
		name = sc.nextLine();
		System.out.println("Enter your email: ");
		email = sc.nextLine();
		System.out.println("Enter number of People: ");
		numOfPeople = sc.nextInt();
		
	}
	public void getPayment() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Proceed to payment ? (yes/no): ");
		String answer = sc.nextLine();
		if(answer.equalsIgnoreCase("yes")) {
			System.out.println("Payment success");
			printConfirmation();
		}else {
			System.out.println("Transaction Failed.");
		}
	}
	public abstract void printConfirmation();

}
