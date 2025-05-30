package com.dino.todolist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoListManager {
	private static ArrayList<String> todoList = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		loadTodoList(); // 파일에서 할일 목록을 불러옴
		boolean run = true;

		while (run) {

			System.out.println("----------------------------------------");
			System.out.println("1. 할일 추가 | 2. 할일 목록 | 3. 할일 수정 | 4. 할일 삭제 | 5. 종료");

			System.out.println("----------------------------------------");
			System.out.print("선택 > ");

			int selectNo = scanner.nextInt();
			if (selectNo == 1) {
				addTodo();
			} else if (selectNo == 2) {
				showTodoList();
			} else if (selectNo == 3) {
				updateTodo();
			} else if (selectNo == 4) {
				deleteTodo();
			} else if (selectNo == 5) {
				saveTodoList(); // 파일에 할일 목록을 저장
				run = false;
			}

		}

		System.out.println("프로그램 종료되었습니다.");
	}

	private static void addTodo() {
		System.out.println("할일을 입력하세요:");
		String todo = scanner.next();
		todoList.add(todo);
		System.out.println("할일이 추가되었습니다.");

	}

	private static void showTodoList() {
		System.out.println("--------------");
		System.out.println("  할일 목록  ");
		System.out.println("--------------");
		for (int i = 0; i < todoList.size(); i++) {
			System.out.println((i + 1) + ". " + todoList.get(i));
		}

	}

	private static void updateTodo() {
		showTodoList();
		System.out.println("수정할 할일 번호를 입력하세요:");
		int index = scanner.nextInt() - 1;

		if (index < 0 || index >= todoList.size()) {
			System.out.println("유효하지 않은 할일 번호입니다.");
			return;

		}

		System.out.println("새로운 할일을 입력하세요:");
		String newTodo = scanner.next();
		todoList.set(index, newTodo);
		System.out.println("할일이 수정되었습니다.");

	}

	private static void deleteTodo() {

		showTodoList();

		System.out.println("삭제할 할일 번호를 입력하세요:");

		int index = scanner.nextInt() - 1;

		if (index < 0 || index >= todoList.size()) {
			System.out.println("유효하지 않은 할일 번호입니다.");
			return;

		}

		todoList.remove(index);
		System.out.println("할일이 삭제되었습니다.");

	}

	private static void loadTodoList() {
		try (BufferedReader reader = new BufferedReader(new FileReader("todolist.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				todoList.add(line);
			}
		} catch (IOException e) {
			System.out.println("할일 목록을 불러오는 중에 오류가 발생했습니다.");
		}
	}

	private static void saveTodoList() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("todolist.txt"))) {
			for (String todo : todoList) {
				writer.write(todo);
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("할일 목록을 저장하는 중에 오류가 발생했습니다.");
		}

	}

}
