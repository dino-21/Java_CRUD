package com.dino.bank;

public class Account {
	  private int balance = 0; // 계좌의 잔액
      private String owner; // 계좌 소유자
      private String accountNumber; // 계좌번호


      final static int MIN_BALANCE = 0; // 최소잔액 상수

      final static int MAX_BALANCE = 1000000; // 최대잔액 상수

      // Account 클래스의 생성자 계좌번호, 계좌소유자, 초기잔액

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
              if (balance >= MIN_BALANCE && balance <= MAX_BALANCE) {
                      this.balance = balance;
              }
      }


      // 계좌 소유자반환
      public String getOwner() {
              return owner;
      }



      // 계좌 번호 반환
      public String getAccountNumber() {
              return accountNumber;

      }
}
