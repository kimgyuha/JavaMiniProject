package ch10.controller;

import java.util.List;

import ch10.vo.NewsDO;

public interface NewsDO_Mapper {

	public List<NewsDO> getAll();
	public NewsDO getNews (int aid);
	public void delNews(int aid);
	public void addNews(NewsDO n);
	
	
	
}
