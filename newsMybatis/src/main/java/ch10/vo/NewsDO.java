package ch10.vo;

public class NewsDO {
    private int aid;
    private String title;
    private String img;
    private String newsdate;
    private String content;

	public int getAid() {
		return aid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getNewsdate() {
		return newsdate;
	}

	public void setNewsdate(String newsdate) {
		this.newsdate = newsdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}
}
