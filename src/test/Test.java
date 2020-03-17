package test;

import com.res.*;

import exception.DateException;
import exception.TypeException;

import java.util.LinkedList;
import java.util.Scanner;

import javax.naming.LimitExceededException;

public class Test {
	


	public static void main(String[] args) throws TypeException, DateException, LimitExceededException {
		// TODO Auto-generated method stub

		LinkedList<Reservation> res = new LinkedList<>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean userEntry = true;
		int currentRoomBooked = 0, currentTableBooked = 0;
		while (userEntry) {
			System.out.println("Type 1 to Book a Room in a Hotel.\n" + "Type 2 to Book a Table in a Restaurant.\n"
					+ "0 to exit");
			int type = sc.nextInt();
			switch (type) {
			case 1:
				if (!(currentRoomBooked < Hotel.TOTAL_ROOMS)) {
					throw new LimitExceededException("Cannot book more than " + Hotel.TOTAL_ROOMS + " rooms.");
				}
				res.add(new Hotel());
				currentRoomBooked++;
				break;
			case 2:
				if (!(currentTableBooked < Restaurant.TOTAL_TABLES)) {
					throw new LimitExceededException("Cannot book more than " + Restaurant.TOTAL_TABLES + " tables.");
				}
				res.add(new Restaurant());
				currentTableBooked++;
				break;
			case 0: userEntry = false;break;
			default: throw new TypeException("Invalid Selection");
			}
		}
		for(Reservation r: res) {
			r.getPayment();
		}

	}

}
