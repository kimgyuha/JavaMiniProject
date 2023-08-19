package grade.student;

public class Student {
	private String name;
	private int stuId;
	private String majorSub;
	
	public Student() {}
	public Student(String name, int stuId, String majorSub) {
		this.name = name;
		this.stuId = stuId;
		this.majorSub = majorSub;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	
	public String getMajorSub() {
		return majorSub;
	}
	public void setMajorSub(String majorSub) {
		this.majorSub = majorSub;
	}

	public String toString() {
		return name + "|" + stuId + "|" + majorSub + "|";
	}
}


//public String getMajor() {
//return major;
//}
//public void setMajor(String major) {
//this.major = major;
//}


//
//public void getMajor(String majorSub) {
//	if(majorSub.equals("국어")) {
//		this.major = "KoreanS";
//	}else if(majorSub.equals("수학")) {
//		this.major = "Maths";
//	}
//}
