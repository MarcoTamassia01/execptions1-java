package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExcepetion;

public class Program {

	public static void main(String[] args) {
	
		Scanner sc  = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
		
		try {
			System.out.print("Room number:");
			int roomnumber= sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy) :");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy) :");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reserv = new Reservation(roomnumber, checkIn, checkOut);
			System.out.println("Reservation: " +reserv);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy) :");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy) :");
			checkOut = sdf.parse(sc.next());
			
			reserv.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reserv);
		}
			catch(ParseException e) {
				System.out.println("Invalid date format");
			}
			
			catch(DomainExcepetion e) {
				System.out.println("Error in reservation: " + e.getMessage());
			}
			catch(RuntimeException e) {
				System.out.println("Unexpected ERROR");
			}
		
		sc.close();

	}

}
