package model.entities;

import model.exceptions.BussinesException;

public class Account {
	
	private Integer number;
	private String holder;
	private double balance;
	private double withDrawLimit;
	
	public Account() {
		super();
	}
		
	public Account(Integer number, String holder, double balance, double withDrawLimit) {
		super();
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public double getWithDrawLimit() {
		return withDrawLimit;
	}

	public void setWithDrawLimit(double withDrawLimit) {
		this.withDrawLimit = withDrawLimit;
	}
	
	public void deposit(double amount) {
		this.balance+=amount;
	}
	
	public void withDraw(double amount) {
		validateWithDraw(amount);
		this.balance-=amount;
	}

	private void validateWithDraw(double amount) {
		if(amount>getWithDrawLimit()) {
			throw new BussinesException(" The amount exceeds withdraw limit");
		}
		if(amount>getBalance()) {
			throw new BussinesException(" Not enough balance");
		}
	}
}
