package com.kh.practice.point.controller;
import com.kh.practice.point.model.vo.Circle;

public class CircleController{

	Circle c = new Circle();
	public String calcArea(int x, int y, int radius) {
		c.setX(x); //Cirle이 Point를 상속받았기때문에 c에만 접근해도 p 변수 값 셋팅가능
		c.setY(y);
		c.setRadius(radius);
		return "넓이: " + c.toString() + c.getRadius() * 2 * 3.14;
	}
	public String calcCircum(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		return "둘레: " + c.toString() + c.getRadius() * 2 * 3.14;
	}

}