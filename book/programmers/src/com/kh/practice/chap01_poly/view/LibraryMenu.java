package src.com.kh.practice.chap01_poly.view;
import src.com.kh.practice.chap01_poly.model.vo.*;

import java.util.Scanner;
import src.com.kh.practice.chap01_poly.controller.LibraryController;
import src.com.kh.practice.chap01_poly.model.vo.Book;
import src.com.kh.practice.chap01_poly.model.vo.Member;

public class LibraryMenu{
	Book[] bList = new Book[5];
	Book[] searchList = new Book[5];
	AniBook ani = new AniBook();
	
	int flag = 0;
	int num;
	int rent;
	String keyword;
	Member currMem = new Member();
	LibraryController lc = new LibraryController();
	Scanner sc = new Scanner(System.in);
	
	public String inputer(String inputList) { //inputer함수를 호출하면 " ~ 입력: "이라는 글자와 함께 입력받는 창(sc.nextLine()이 반환됨)
		System.out.print(inputList + " 입력 : ");
		return sc.nextLine();
	}
	public void mainMenu() {
		if(currMem.getName() == null) {
//			System.out.print("이름 입력: ");
//			String name = sc.nextLine();
//			System.out.print("나이 입력: ");
//			int age = sc.nextInt();
//			System.out.print("성별 입력: ");
//			char gender = sc.next().charAt(0);
			
			String name = inputer("이름");
			int age = Integer.parseInt(inputer("나이"));
			char gender = inputer("성별(F/M)").charAt(0);
			
			Member member = new Member(name, age, gender);
			
			lc.insertMember(member);
			this.currMem = member;
			this.bList = lc.selectAll();
			}
		
		while(true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 대여하기");
			System.out.println("5. 도서 반납하기");
			System.out.println("9. 프로그램 종료하기");
			
	
			num = Integer.parseInt(inputer("메뉴 번호"));
//			System.out.print("메뉴 번호: ");
//			num = sc.nextInt();
	
			if(num==1) {
				System.out.println(lc.myInfo());
				continue;
			}
			else if(num==2) {
				selectAll();
			}
			else if(num==3) {
				searchBook();				
			}
			else if(num==4) {
				rentBook();
			}
			else if(num==5) {
				turnBook();
			}
			else if(num==9) {
				System.out.println("프로그램 종료");
				break;
			}
			else {
				System.out.println("다시 입력하세요");
			}
		}
	}
	
	public void selectAll() {
		for(int i=0; i<5; i++) {
		bList[i] = lc.selectAll()[i];
		}
		for(int i =0; i<5; i++) {
			System.out.println(i+"번도서 : " + bList[i]);
		}
	}
	public void searchBook() {
		System.out.print("검색할 키워드 : ");
		keyword = sc.nextLine();
		Book[] searchList = lc.searchBook(keyword);
		for(int i=0; i<searchList.length; i++) {
			if(searchList[i] != null) {
				System.out.println(searchList[i]);
			}
		}
		mainMenu();
	}
	public void rentBook() {
		System.out.print("대여할 도서 번호 선택 : ");
		rent = sc.nextInt();
		int result = lc.rentBook(rent);
		if (result == 1) {
			System.out.println("***** 나이제한! 대여불가! *****");
		}
		else if(result == 2) {
			System.out.println("***** 대여성공! 마이페이지에서 쿠폰을 확인하세요 *****");
		}
		else if(result == 0) {
			System.out.println("***** 대여성공! *****");
		}
		sc.nextLine();
		mainMenu();
		}
	
	public void turnBook() {
		System.out.println("반납할 도서 번호를 입력하세요: ");
		int num = sc.nextInt();
		lc.turnBook(num);
		for(int i=0; i<bList.length; i++) {
			System.out.println(bList[i]);
			sc.nextLine();
			mainMenu();
		}
	
	}
	
}