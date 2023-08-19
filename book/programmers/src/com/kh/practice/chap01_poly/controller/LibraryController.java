package src.com.kh.practice.chap01_poly.controller;
import src.com.kh.practice.chap01_poly.model.vo.*;
import java.util.Scanner;

public class LibraryController{
	Scanner sc = new Scanner(System.in);
    private Book[] bList = new Book[5];
	AniBook ani = new AniBook();
    private Member mem = new Member();
    CookBook cook = new CookBook();
	{  
		//book객체를 CookBook객체, AniBook객채로 만듦
		bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
		bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
		//객체 배열 (배열안에 값으로 객체가 들어있음)
	}
	
    public void insertMember(Member member) {
  
        this.mem = member;
    }

    public Member myInfo() {
        return mem;
    }

    public Book[] selectAll() {
    
        return bList;
    }

    public Book[] searchBook(String keyword) {
    	Book[] sList = new Book[5];
    	int count = 0;
    	for(int i=0; i<5; i++) {
    		if(bList[i].getTitle().contains(keyword)) {
    			sList[count++] = bList[i];
    		}	
    	}
    	return sList;
    }
    public int rentBook(int index) {
    	int flag = 0;
    	int result = 0;
    	int aniAge;
    	int MemAge;
    	
    	if(index == 1){
    		aniAge = ani.downCasting(bList[1]).getAccessAge();
    		MemAge = mem.getAge();
    	
    		if(aniAge > MemAge) {
    			flag = 1;
    		}
    	}
    	else if(index == 0 || index == 3 || index == 4 ) {
    		if(cook.downCasting(bList[index]).hasCoupon() == true) {
    			flag = 2;
    			}
    		}
    	else {		
    		flag = 0;
    	}
    	if(flag == 1)
    	{
    		return 1;
    	}
    	else if(flag == 2) {
    		return 2;	
    	}
    	else{
    		return 0;
    		
    	}
    }
    public Book[] turnBook(int idx) {
    	bList[idx] = null;
    	return bList;
    }
    
    public Member getMem() {
  		return mem;
  	}

  	public void setMem(Member mem) {
  		this.mem = mem;
  	}
}
    