//package ch10;
//import java.io.IOException;
//import java.sql.SQLException;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.beanutils.BeanUtils;
//
///**
// * Servlet implementation class StudentController
// */
//@WebServlet("/studentControl1")
//public class StudentController extends HttpServlet { 
//	//HttpServlet을 StudentController가 상속받음
//	private static final long serialVersionUID = 1L;
//  
//    StudentDAO dao;
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config); 
//		dao = new StudentDAO();//서블릿이 초기화될때마다 StudentDAD클래스의 새로운 인스턴스가 생성되고
//		//이 인스턴스가 서블릿의 라이프사이클 동안 유지됨
//	}//StudentController에서 init함수를 사용하여 초기화하면서 상위클래스인 HttpServlet도 초기화함
//	//config를 인자로 받아 StudentController객체와 HttpServlet을 동시에 초기화
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		request.setCharacterEncoding("utf-8");
//		String action = request.getParameter("action");
//		String view = "";
//
//		if (action == null) {
//			getServletContext().getRequestDispatcher("/studentControl1?action=list").forward(request, response);
//		} else {
//			switch (action) {
//				case "list":
//					view = list(request, response);
//					break;
//				case "insert":
//					view = insert(request, response);
//					break;
//			}
//			getServletContext().getRequestDispatcher("/ch10/" + view).forward(request, response);
//		}
//	}
//
//	public String list(HttpServletRequest request, HttpServletResponse response) {
//		request.setAttribute("students", dao.getAll());
//		return "studentInfo.jsp";
//	}
//	public String insert(HttpServletRequest request, HttpServletResponse response) {
//		Student s = new Student();
//		try {
//			BeanUtils.populate(s, request.getParameterMap());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		dao.insert(s);
//		return list(request, response);
//	}
//
//	}
//
package test;


