package model;

public class Account {
	private Integer accNum;
	private String name;
	private Integer balance;

	public Account() {
		super();
	}

	public Account(Integer accNum, String name, Integer balance) {
		super();
		this.accNum = accNum;
		this.name = name;
		this.balance = balance;
	}

	public Integer getAccNum() {
		return accNum;
	}

	public void setAccNum(Integer accNum) {
		this.accNum = accNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", name=" + name + ", balance=" + balance + "]";
	}

}
