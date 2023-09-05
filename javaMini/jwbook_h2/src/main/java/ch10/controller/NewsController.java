package ch10.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import ch10.vo.NewsDAO;
import ch10.vo.NewsDO;

/**
 * Servlet implementation class NewsController
 */
@WebServlet("/news.nhn") //이게 아노테이션
@MultipartConfig(maxFileSize=1024*1024*2, location="c:/Temp/img")
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private NewsDAO dao;
	private ServletContext ctx;
	
	private final String START_PAGE = "ch10/newsList.jsp";

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dao = new NewsDAO();
		ctx = getServletContext();//서블릿이 컨테이너에 올라올때 초기화가 됨	
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//중요. 요청을 처리할 메서드
		//request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		
		dao = new NewsDAO();
		
		Method m;
		String view = null;
		
		if(action == null) {
			action = "listNews";
		}
		try {
			m = this.getClass().getMethod(action, HttpServletRequest.class);
			view = (String)m.invoke(this, request);
			//action파라미터가 갖고 들어온 데이터에 있는 정보를 이용해서 이동할 뷰페이지를 지정해줌
			}catch(NoSuchMethodException e) {
				e.printStackTrace();
				ctx.log("요청한 action이 없음");
				request.setAttribute("error", "action 파라메터가 잘못되었습니다");
				view = START_PAGE;
			}catch(Exception e) {
				e.printStackTrace();
			}
		
	if(view.startsWith("redirect:/")) {
		String rview = view.substring("redirect:/".length());
		response.sendRedirect(rview);
	}else {
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
	}
	public String addNews(HttpServletRequest request) {
		NewsDO n = new NewsDO();
		try {
			Part part = request.getPart("file");
			String fileName = getFilename(part);
			if(fileName != null && !fileName.isEmpty()) {
				part.write(fileName);
				
			}
			BeanUtils.populate(n, request.getParameterMap());
			
			n.setImg("/img/"+fileName);
			
			dao.addNews(n);
		} catch(Exception e) {
			e.printStackTrace();
			ctx.log("뉴스를 가져오는 과정에서 문제 발생!!");
			request.setAttribute("error", "뉴스가 정상적으로 등록되지 않았습니다!!");
			return listNews(request);
		}
		return "redirect:/news.nhn?action=listNews";
	}
	public String deleteNews(HttpServletRequest request) {
		int aid = Integer.parseInt(request.getParameter("aid"));
		try  {
			dao.delNews(aid);
		}catch(SQLException e) {
			e.printStackTrace();
			ctx.log("뉴스 삭제 과정에서 문제 발생!!");
			request.setAttribute("error", "뉴스가 정상적으로 삭제되지 않았습니다!!");
			return listNews(request);	
		}
		return "redirect:/news.nhn?action=listNews";
	}
	private String getFilename(Part part) {
		String fileName = null;
		String header = part.getHeader("content-disposition");
		System.out.println("Header => " +header);
		
		int start = header.indexOf("filename=");
		fileName = header.substring(start+10,header.length()-1);
		ctx.log("파일명:"+fileName);
		return fileName;
	}
	public String listNews(HttpServletRequest request) {
		List<NewsDO> list;
		try {
			list = dao.getAll();
			request.setAttribute("newslist", list);
		} catch(Exception e) {
			e.printStackTrace();
			ctx.log("뉴스 삭제 과정에서 문제 발생!!");
			request.setAttribute("error", "뉴스가 정상적으로 삭제되지 않았습니다!!");
		}
		return "ch10/newsList.jsp";
		}
	public String getNews(HttpServletRequest request) {
		int aid = Integer.parseInt(request.getParameter("aid"));
		try {
			NewsDO n = dao.getNews(aid);
			request.setAttribute("news", n);
		}catch (SQLException e) {
			e.printStackTrace();
			ctx.log("뉴스를 가져오는 과정에서 문제 발생!!");
			request.setAttribute("error", "뉴스를 정상적으로 가져오지 못했습니다!!");
		}
	return "ch10/newsView.jsp";
	}

}
