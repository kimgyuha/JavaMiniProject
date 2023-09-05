package ch10.controller;

import java.util.List;
import ch10.vo.NewsDO;

public interface NewsDO_Mapper {
	public List<NewsDO> getNews(); // Student List객체를가져와라 
	//매퍼와 똑같은 이름으루ㅗ 만들어줌
	public void addNews(NewsDO s);

}
