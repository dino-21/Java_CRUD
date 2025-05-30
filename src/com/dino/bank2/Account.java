package com.dino.bank2;

public class Account {
	private int balance; // 계좌의 잔액
    private String owner; // 계좌 소유자
    private String accountNumber; // 계좌 번호


    // Account 클래스의 생성자
    public Account(String accountNumber, String owner, int balance) {
            this.accountNumber = accountNumber;
            this.owner = owner;
            this.balance = balance;
    }


    // 현재 계좌의 잔액을 반환하는 메서드
    public int getBalance() {
            return balance;
    }


    // 계좌의 잔액을 설정하는 메서드
    public void setBalance(int balance) {
            this.balance = balance;
    }


    // 계좌 소유자를 반환하는 메서드
    public String getOwner() {
            return owner;
    }


    // 계좌 번호를 반환하는 메서드
    public String getAccountNumber() {
            return accountNumber;
    }
}
