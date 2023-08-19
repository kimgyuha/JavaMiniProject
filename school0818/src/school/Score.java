package school;


public class Score {
	int score;
	Subject subject;
	
	
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Score() {}
	public Score(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	public String toString() {
		return subject.getSubjectName() + ":" + score;
	}
}
