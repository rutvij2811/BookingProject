package com.res;

import java.time.LocalDateTime;
import java.util.Scanner;

import exception.DateException;
import exception.TypeException;

public class Restaurant extends Reservation {
	public static final int TOTAL_TABLES = 2;
	public static final int COST = 100;
	LocalDateTime resDateTime;
	private int resHours;

	public Restaurant() throws DateException, TypeException {
		getDetails();
	}

	public void getDetails() throws DateException, TypeException {
		// TODO Auto-generated method stub
		super.getDetails();
		getCostDetail();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the date of the booking");
		int day = sc.nextInt();
		if (day < LocalDateTime.now().getDayOfMonth()) {
			throw new DateException("Invalid Date");
		}
		System.out.println("Enter time for booking:(HH mm)");
		String[] time = sc.nextLine().split(" ");
		resDateTime = LocalDateTime.of(2020, LocalDateTime.now().getMonthValue(), day, Integer.parseInt(time[0]),
				Integer.parseInt(time[1]));
		System.out.println("For how many hours would you like to book the table ?");
		resHours = sc.nextInt();
	}

	@Override
	public void printConfirmation() {
		// TODO Auto-generated method stub
		cost = COST * resHours;
		System.out.println("Customer Name: " + name + ".\n" + "Table  booked for " + resHours + " hours.\n"
				+ "Cost of booking is Rs." + cost);

	}

	void getCostDetail() {
		System.out.println("Cost of table booked per hour: " + COST);

	}

}
