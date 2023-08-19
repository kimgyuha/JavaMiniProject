package src.com.kh.practice.chap01_poly.model.vo;

public class CookBook extends Book{
    private boolean hascoupon;  


    public CookBook() { }

    public CookBook(String title, String author, String publisher, boolean coupon) {

        super.setTitle(title);
        super.setAuthor(author);
        super.setPublisher(publisher);
        this.hascoupon = coupon;
    }

    public String toString() {
        return "CookBook " + super.toString() + "coupon=" + hascoupon +"]";
    }

	public boolean hasCoupon() {
		return hascoupon;
	}

	public void setCoupon(boolean coupon) {
		this.hascoupon = coupon;
	}
	@Override
	public CookBook downCasting(Book book) {
		if(book instanceof CookBook) {
		CookBook cook = (CookBook)book; 
		return cook;
	}
	return null;
	}
}