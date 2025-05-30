package com.dino.student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
	private static ArrayList<Student> studentList = new ArrayList<>();

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while (run) {

			System.out.println("-----------------------------------------------");
			System.out.println("1. 학생 등록 | 2. 학생 목록 | 3. 학생 수정 | 4. 학생 삭제 | 5. 종료");
			System.out.println("-----------------------------------------------");
			System.out.print("선택 > ");

			int selectNo = scanner.nextInt();

			switch (selectNo) {
			case 1:
				registerStudent();
				break;
			case 2:
				showStudentList();
				break;
			case 3:
				updateStudent();
				break;
			case 4:
				deleteStudent();
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

	private static void registerStudent() {
		System.out.println("--------------");
		System.out.println("  학생 등록   ");
		System.out.println("--------------");

		System.out.print("학번: ");
		String studentId = scanner.next();

		if (findStudent(studentId) != null) {
			System.out.println("이미 등록된 학번입니다. 다른 학번을 입력해주세요.");
			return;
		}

		System.out.print("이름: ");
		String name = scanner.next();

		System.out.print("나이: ");
		int age = scanner.nextInt();

		Student student = new Student(studentId, name, age);
		studentList.add(student);

		System.out.println("학생이 성공적으로 등록되었습니다.");
	}

	private static void showStudentList() {

		System.out.println("--------------");
		System.out.println("  학생 목록  ");
		System.out.println("--------------");
		System.out.println("학번 \t 이름 \t 나이");

		for (Student student : studentList) {
			System.out.println(student.getStudentId() + "\t" + student.getName() + "\t" + student.getAge());
		}
	}

	private static void updateStudent() {
		System.out.println("--------------");
		System.out.println("  학생 수정   ");
		System.out.println("--------------");

		System.out.print("수정할 학번: ");
		String studentId = scanner.next();

		Student student = findStudent(studentId);

		if (student == null) {
			System.out.println("해당 학번의 학생이 존재하지 않습니다.");
			return;
		}

		System.out.print("새로운 이름: ");
		String newName = scanner.next();

		System.out.print("새로운 나이: ");
		int newAge = scanner.nextInt();

		student.setName(newName);
		student.setAge(newAge);

		System.out.println("학생 정보가 성공적으로 수정되었습니다.");

	}

	private static void deleteStudent() {

		System.out.println("--------------");

		System.out.println("  학생 삭제   ");
		System.out.println("--------------");

		System.out.print("삭제할 학번: ");
		String studentId = scanner.next();

		Student student = findStudent(studentId);

		if (student == null) {
			System.out.println("해당 학번의 학생이 존재하지 않습니다.");
			return;

		}

		studentList.remove(student);
		System.out.println(student.getName() + " 학생이 삭제되었습니다.");

	}

	private static Student findStudent(String studentId) {
		for (Student student : studentList) {
			if (student.getStudentId().equals(studentId)) {
				return student;
			}
		}
		return null;

	}
}
