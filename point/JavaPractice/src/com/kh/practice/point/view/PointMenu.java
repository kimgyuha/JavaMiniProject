package com.kh.practice.point.view;
import java.util.Scanner;
import com.kh.practice.point.controller.CircleController;
import com.kh.practice.point.controller.RectangleController;

public class PointMenu {
	Scanner sc = new Scanner(System.in);
	CircleController cc = new CircleController();
	RectangleController rc = new RectangleController();
	
	int menu =0;
	int num=0;
	int x=0;
	int y=0;
	int radius=0;
	int height=0;
	int width=0;
	
	public void mainMenu() {
		System.out.println("===== 메뉴 =====");	
		System.out.println("1.원");
		System.out.println("2.사각형");
		System.out.println("9.끝내기");
		System.out.println("메뉴 번호: ");	
		
		
		menu = sc.nextInt();
		if(menu == 1) {
			circleMenu();
		}
		else if(menu==2) {
			rectangleMenu();
			}
		else if(menu==9) {
			System.out.println("끝내기");
		}
		else
			mainMenu();
		}
		
	
	public void circleMenu() {
		System.out.println("===== 원메뉴 =====");
		System.out.println("1.원 둘레");
		System.out.println("2.원 넓이");
		System.out.println("9.메인으로");
		System.out.println("메뉴 번호: ");	
		num = sc.nextInt();
	
		if(num == 1) {
			calcCircum();
		}
		else if(num==2) {
			calcCircleArea();
			}
		else if(num==9) {
			mainMenu();	
		}
		else
			mainMenu();	
	}
	public void rectangleMenu() {
		System.out.println("===== 사각형 메뉴 =====");
		System.out.println("1.사각형 둘레");
		System.out.println("2.사각형 넓이");
		System.out.println("9.메인으로");
		System.out.println("메뉴 번호: ");	
		
		num = sc.nextInt();
		if(num == 1) {
			calcPerimeter();
		}
		else if(num==2) {
			calcRecArea();
			}
		else if(num==9) {
			mainMenu();
		}
		else
			mainMenu();
		}
	
	
	public void calcCircum() {
		System.out.println("x 좌표 :");
		x=sc.nextInt();
		System.out.println("y 좌표 :");
		y=sc.nextInt();
		System.out.println("반지름 :");
		radius=sc.nextInt();
		System.out.println(cc.calcCircum(x, y, radius));
		mainMenu();
	}
	public void calcCircleArea() {
		System.out.println("x 좌표 :");
		x=sc.nextInt();
		System.out.println("y 좌표 :");
		y=sc.nextInt();
		System.out.println("반지름 :");
		radius=sc.nextInt();
		System.out.println(cc.calcArea(x, y, radius));	
		mainMenu();	
	}
	public void calcPerimeter() {
		System.out.println("x 좌표 :");
		x=sc.nextInt();
		System.out.println("y 좌표 :");
		y=sc.nextInt();
		System.out.println("높이 :");
		height=sc.nextInt();
		System.out.println("너비 :");
		width=sc.nextInt();
		System.out.println(rc.calcPerimeter(x, y, height, width));
		mainMenu();
	}
	public void calcRecArea() {
		System.out.println("x 좌표 :");
		x=sc.nextInt();
		System.out.println("y 좌표 :");
		y=sc.nextInt();
		System.out.println("높이 :");
		height=sc.nextInt();
		System.out.println("너비 :");
		width=sc.nextInt();
		System.out.println(rc.calcArea(x, y, height, width));
		mainMenu();
	}
}
