package src.com.kh.practice.chap01_poly.model.vo;

public abstract class Book {
    private String title;     
    private String author;      
    private String publisher;
    
    public Book()  {}

    public Book(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }
    
	// 상위 클래스에서 다운캐스팅해주는 메서드를 추상메서드로 선언(보통 상위 클래스에서 이 추상 메서드를 활용해서 먼저 사용)
    public abstract Book downCasting(Book book);

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String toString() {
        return "[title=" + title + ", author=" + author + ", publisher=" + publisher ;
    }
	
}