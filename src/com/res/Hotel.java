package com.res;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import exception.DateException;
import exception.TypeException;

public class Hotel extends Reservation {
	public static final int TOTAL_ROOMS = 2;
	public static final int SUIT = 6500;
	public static final int SEA_VIEW = 8500;
	public static final int NORMAL_ROOM = 3500;
	final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	private int numOfDays;
	private int typeOfRoom;
	private LocalDate checkInDate;
	public Hotel() throws TypeException, DateException {
		getDetails();;
	}

	private LocalDate checkOutDate;

	public void getDetails() throws TypeException, DateException {
		// TODO Auto-generated method stub
		super.getDetails();
		getRoomDetails();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter checkIn Date and Month (dd-MM)");
		String checkIn = sc.nextLine();
		System.out.println("Enter checkOut Date and Month (dd-MM)");
		String checkOut = sc.nextLine();
		System.out.println("Enter the room type: ");
		typeOfRoom = sc.nextInt();
		if (typeOfRoom < 1 || typeOfRoom > 3) {
			throw new TypeException("Invalid room type");
		}
		checkInDate = LocalDate.of(2020, Integer.parseInt(checkIn.split("-")[1]),
				Integer.parseInt(checkIn.split("-")[0]));
		checkOutDate = LocalDate.of(2020, Integer.parseInt(checkOut.split("-")[1]),
				Integer.parseInt(checkOut.split("-")[0]));
		Period period = Period.between(checkInDate, checkOutDate);
		numOfDays = period.getDays();
	}

	@Override
	public void printConfirmation() {
		// TODO Auto-generated method stub
		String room = "";
		switch (typeOfRoom) {
		case 1:
			room = "SUIT";
			cost = SUIT* numOfDays;
			break;
		case 2:
			room = "SEA_VIEW";
			cost = SEA_VIEW * numOfDays;
			break;
		case 3:
			room = "NORMAL_ROOM";
			cost = NORMAL_ROOM * numOfDays;
			break;
		}
		System.out.println("Customer Name: " + name + ".\n" + "Room booked for " + numOfPeople + " people.\n"
				+ "Type of room booked: " + room + " with cost of Rs." + cost);
	}

	void getRoomDetails() {
		System.out.println("The cost/day for a Suit:(Type 1) " + SUIT);
		System.out.println("The cost/day for a Sea View Room:(Type 2) " + SEA_VIEW);
		System.out.println("The cost/day for a Normal Room:(Type 3) " + NORMAL_ROOM);
	}

}
