package grade.evaluation;

public class Major implements GradeEvaluation{
	private String grade;
	@Override
	public String GradeOfSubject(int score) {
		if (score >= 95 && score <= 100)
			grade = "S";
		else if (score >= 90)
			grade = "A";
		else if (score >= 80)
			grade = "B";
		else if (score >= 70)
			grade = "C";
		else if (score >= 60)
			grade = "D";
		else
			grade = "F";
		return grade;
	}
}
