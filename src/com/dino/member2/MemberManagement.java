package com.dino.member2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberManagement {
	private static ArrayList<Member> memberList = new ArrayList<>(); // ArrayList로 변경
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		loadMembers(); // 파일에서 회원 정보를 불러옴

		boolean run = true;
		while (run) {

			System.out.println("-----------------------------------------------");
			System.out.println("1. 회원 등록 | 2. 회원 목록 | 3. 회원 수정 | 4. 회원 삭제 | 5. 종료");
			System.out.println("-----------------------------------------------");
			System.out.print("선택 > ");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
				registerMember();
			} else if (selectNo == 2) {
				showMemberList();
			} else if (selectNo == 3) {
				updateMember();
			} else if (selectNo == 4) {
				deleteMember();
			} else if (selectNo == 5) {
				saveMembers(); // 파일에 회원 정보를 저장
				run = false;
			}
		}

		System.out.println("프로그램 종료되었습니다.");
	}

	private static void registerMember() {

		System.out.println("--------------");
		System.out.println("  회원 등록   ");
		System.out.println("--------------");

		System.out.print("회원 ID: ");
		String memberId = scanner.next();

		// 중복 회원 ID 체크

		if (findMember(memberId) != null) {
			System.out.println("이미 등록된 회원 ID입니다. 다른 ID를 입력해주세요.");
			return;
		}

		System.out.print("이름: ");
		String name = scanner.next();

		System.out.print("나이: ");
		int age = scanner.nextInt();

		Member member = new Member(memberId, name, age);
		memberList.add(member); // ArrayList에 회원 추가

		System.out.println("회원이 성공적으로 등록되었습니다.");

	}

	private static void showMemberList() {
		System.out.println("--------------");
		System.out.println("  회원 목록  ");
		System.out.println("--------------");
		System.out.println("회원 ID \t 이름 \t 나이");

		for (Member member : memberList) {
			System.out.println(member.getMemberId() + "\t\t" + member.getName() + "\t\t" + member.getAge());
		}

	}

	private static void updateMember() {
		System.out.println("--------------");
		System.out.println("  회원 수정   ");
		System.out.println("--------------");

		System.out.print("수정할 회원 ID: ");
		String memberId = scanner.next();

		Member member = findMember(memberId);

		if (member == null) {
			System.out.println("해당 회원 ID의 회원이 존재하지 않습니다.");
			return;
		}

		System.out.print("새로운 이름: ");
		String newName = scanner.next();

		System.out.print("새로운 나이: ");
		int newAge = scanner.nextInt();

		member.setName(newName);
		member.setAge(newAge);

		System.out.println("회원 정보가 성공적으로 수정되었습니다.");
	}

	private static void deleteMember() {
		System.out.println("--------------");
		System.out.println("  회원 삭제   ");
		System.out.println("--------------");

		System.out.print("삭제할 회원 ID: ");
		String memberId = scanner.next();

		Member member = findMember(memberId);

		if (member == null) {
			System.out.println("해당 회원 ID의 회원이 존재하지 않습니다.");
			return;
		}

		// 회원 삭제
		memberList.remove(member);
		System.out.println(member.getName() + " 회원이 삭제되었습니다.");

	}

	private static Member findMember(String memberId) {
		for (Member member : memberList) {
			if (member.getMemberId().equals(memberId)) {
				return member;
			}
		}
		return null;
	}

	private static void loadMembers() {
		try (BufferedReader reader = new BufferedReader(new FileReader("members.txt"))) {
			String line;

			while ((line = reader.readLine()) != null) {

				String[] parts = line.split(",");

				if (parts.length == 3) {
					String memberId = parts[0].trim();
					String name = parts[1].trim();
					int age = Integer.parseInt(parts[2].trim());
					memberList.add(new Member(memberId, name, age));

				}

			}

		} catch (IOException e) {
			System.out.println("회원 정보를 불러오는 중에 오류가 발생했습니다.");
		}

	}

	private static void saveMembers() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.txt"))) {
			for (Member member : memberList) {
				writer.write(member.getMemberId() + "," + member.getName() + "," + member.getAge());
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("회원 정보를 저장하는 중에 오류가 발생했습니다.");
		}

	}

}
