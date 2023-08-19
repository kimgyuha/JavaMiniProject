package src.com.kh.practice.chap01_poly.model.vo;
//그저 설계도
public class Member {
    private String name = null;       
    private int age;         
    private char gender;       
    private int couponCount;   

    public Member() {}

    public Member(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public String toString() {
        return "[name=" + name + ", age=" + age + ", gender=" + gender + ", couponCount=" + couponCount +"]";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public int getCouponCount() {
        return couponCount;
    }

 
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setCouponCount(int couponCount) {
        this.couponCount = couponCount;
    }
}