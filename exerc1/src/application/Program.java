package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BussinesException;

public class Program {

	public static void main(String[] args) {
		
	Locale.setDefault(Locale.US);	
	Scanner sc = new Scanner(System.in);	
		
	System.out.println("Enter the account data:");
	System.out.print("Number: ");
	int number = sc.nextInt();
	System.out.print("Holder: ");
	String holderString = sc.nextLine();
	sc.nextLine();
	System.out.print("Initial balance: ");
	double initialBalance = sc.nextDouble();
	System.out.print("Withdraw limit: ");
	double withDrawLimit = sc.nextDouble();
		
	Account account = new Account(number, holderString, initialBalance, withDrawLimit);
		
	System.out.println();
	System.out.print("Enter amount for withdraw: ");
	double withdraw = sc.nextDouble();
	
	
	try {
	account.withDraw(withdraw);
	System.out.print("New balance: " + String.format("%.2f",account.getBalance()));
	}
	
	catch(BussinesException e) {
		System.out.print("Withdraw error:" + e.getMessage());
	}
	
	sc.close();	
	}

}
