package grade.evaluation;

public class Basic implements GradeEvaluation{
	private String grade; 
	@Override
	public String GradeOfSubject(int score) {
		if(score >= 90 && score <= 100)
			grade = "A";
		else if(score >= 80)
			grade = "B";
		else if(score >= 70)
			grade = "C";
		else if(score >= 55)
			grade = "D";
		else
			grade = "F";
		return grade;
	}
}

