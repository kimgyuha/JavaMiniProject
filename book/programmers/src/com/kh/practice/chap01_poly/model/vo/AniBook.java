package src.com.kh.practice.chap01_poly.model.vo;

public class AniBook extends Book{
	    private int accessAge;   

	    public AniBook() {}

	    public AniBook(String title, String author, String publisher, int accessAge) {
	 
	        super.setTitle(title);
	        super.setAuthor(author);
	        super.setPublisher(publisher);
	        this.accessAge = accessAge;
	    }

	    public int getAccessAge() {
			return accessAge;
		}

		public void setAccessAge(int accessAge) {
			this.accessAge = accessAge;
		}

	    public String toString() {
	        return "AniBook " + super.toString() + "accessAge=" + accessAge + "]";
	    }

	    @Override
	    public AniBook downCasting(Book book) {
	    	if (book instanceof AniBook) {
    		AniBook ani = (AniBook)book; //하->상 이므로 강제형변환
    		return ani; //book ins~가 참이면 ani 반환
    	}
	    return null; //book ins~가 거짓이면 null반환
    }
}