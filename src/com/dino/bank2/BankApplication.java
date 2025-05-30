package com.dino.bank2;

import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {
	private static ArrayList<Account> accountList = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while (run) {

			System.out.println("-----------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 입금 | 4. 출금 | 5. 종료");
			System.out.println("-----------------------------------------------");
			System.out.print("선택 > ");

			int selectNo = scanner.nextInt();

			switch (selectNo) {
			case 1:
				createAccount();
				break;
			case 2:
				accountList();
				break;
			case 3:
				deposit();
				break;
			case 4:
				withdraw();
				break;
			case 5:
				run = false;
				break;
			default:
				System.out.println("잘못된 선택입니다. 다시 선택해주세요.");

			}

		}

		System.out.println("프로그램 종료되었습니다.");
	}

	private static void createAccount() {
		System.out.println("--------------");
		System.out.println("  계좌 생성   ");
		System.out.println("--------------");

		System.out.print("계좌 번호: ");
		String accountNumber = scanner.next();

		if (findAccount(accountNumber) != null) {
			System.out.println("이미 존재하는 계좌번호입니다. 다른 계좌번호를 입력해주세요.");
			return;
		}

		System.out.print("계좌 소유자: ");
		String owner = scanner.next();

		System.out.print("초기 입금액: ");
		int balance = scanner.nextInt();

		Account account = new Account(accountNumber, owner, balance);
		accountList.add(account);

		System.out.println("계좌가 성공적으로 생성되었습니다.");

	}

	private static void accountList() {

		System.out.println("--------------");
		System.out.println("  계좌 목록  ");
		System.out.println("--------------");
		System.out.println("계좌번호 \t 계좌 소유자   \t  잔고");

		for (Account account : accountList) {
			System.out.println(account.getAccountNumber() + "\t" + account.getOwner() + "\t" + account.getBalance());
		}
	}

	private static void deposit() {
		System.out.println("--------------");
		System.out.println("  예금   ");
		System.out.println("--------------");

		System.out.print("계좌번호: ");
		String accountNumber = scanner.next();

		System.out.print("입금 금액: ");
		int amount = scanner.nextInt();

		Account account = findAccount(accountNumber);

		if (account == null) {
			System.out.println("결과: 계좌가 존재하지 않습니다.");
			return;
		}

		account.setBalance(account.getBalance() + amount);
		System.out.println("결과 " + amount + " 입금이 성공적으로 처리되었습니다.");

	}

	private static void withdraw() {
		System.out.println("--------------");
		System.out.println("  인출 ");
		System.out.println("--------------");

		System.out.print("계좌번호 : ");
		String accountNumber = scanner.next();

		System.out.print("인출금액: ");
		int amount = scanner.nextInt();

		Account account = findAccount(accountNumber);

		if (account == null) {
			System.out.println("결과: 계좌가 존재하지 않습니다.");
			return;

		}

		if (account.getBalance() < amount) {
			System.out.println("출금할 잔액이 부족합니다.");
			return;
		}

		account.setBalance(account.getBalance() - amount);
		System.out.println("결과: 출금이 " + amount + " 성공적으로 처리되었습니다.");

	}

	private static Account findAccount(String accountNumber) {
		for (Account account : accountList) {
			if (account.getAccountNumber().equals(accountNumber)) {
				return account;
			}

		}
		return null;
	}
}
