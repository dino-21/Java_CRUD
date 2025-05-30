package com.dino.book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManagement {
	private static ArrayList<Book> bookList = new ArrayList<>(); // ArrayList로 변경
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;

        while (run) {

            System.out.println("-----------------------------------------------");
            System.out.println("1. 도서 등록 | 2. 도서 목록 | 3. 도서 삭제 | 4. 종료");
            System.out.println("-----------------------------------------------");
            System.out.print("선택 > ");


            int selectNo = scanner.nextInt();


            if (selectNo == 1) {
                registerBook();
            } else if (selectNo == 2) {
                showBookList();
            } else if (selectNo == 3) {
                deleteBook();
            } else if (selectNo == 4) {
                run = false;
            }
        }

        System.out.println("프로그램 종료되었습니다.");
	}

	private static void registerBook() {
	        System.out.println("--------------");
	        System.out.println("  도서 등록   ");
	        System.out.println("--------------");


	        System.out.print("도서 번호: ");
	        String bookId = scanner.next();

	        
	        // 중복 도서 번호 체크
	        if (findBook(bookId) != null) {
	            System.out.println("이미 등록된 도서 번호입니다. 다른 번호를 입력해주세요.");
	            return;
	        }

	        System.out.print("제목: ");
	        String title = scanner.next();
	
	        System.out.print("저자: ");
	        String author = scanner.next();


	        System.out.print("가격: ");
	        int price = scanner.nextInt();

	        Book book = new Book(bookId, title, author, price);
	        bookList.add(book); // ArrayList에 도서 추가


	        System.out.println("도서가 성공적으로 등록되었습니다.");

	}
	private static void showBookList() {
	        System.out.println("--------------");
	        System.out.println("  도서 목록  ");
	        System.out.println("--------------");
	        System.out.println("도서 번호 \t 제목 \t\t 저자 \t\t 가격");
	        
	        for (Book book : bookList) {
	            System.out.println(book.getBookId() + "\t\t" + book.getTitle() + "\t\t" + book.getAuthor() + "\t\t" + book.getPrice());
	        }

	    }
	    
	    
	private static void deleteBook() {
	        System.out.println("--------------");
	        System.out.println("  도서 삭제   ");
	        System.out.println("--------------");
	        
	        System.out.print("삭제할 도서 번호: ");
	        String bookId = scanner.next();

	        Book book = findBook(bookId);
	        
	        if (book == null) {
	            System.out.println("해당 도서 번호의 도서가 존재하지 않습니다.");
	            return;
	        }
	        
	        // 도서 삭제
	        bookList.remove(book);
	        System.out.println(book.getTitle() + " 도서가 삭제되었습니다.");
	    }


	private static Book findBook(String bookId) {
		for (Book book : bookList) {
			if (book.getBookId().equals(bookId)) {
				return book;
			}
		}
		return null;
	}
}
