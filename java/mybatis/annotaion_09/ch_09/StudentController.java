//package ch09MyBatisAnnotation;
//
//import java.io.IOException;
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
//@WebServlet("/studentControlMyBatisAnnotation")
//public class StudentController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	StudentDAO dao;
//       
//    public StudentController() {
//        super();
//    }
//
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//		dao = new StudentDAO();
//	}
//
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		String action = request.getParameter("action");
//		String view = "";
//		
//		if (action == null) {
//			getServletContext().getRequestDispatcher("/studentControlMyBatisAnnotation?action=list").forward(request, response);
//			return;
//		} else {
//			switch(action) {
//				case "list": view = list(request, response); break;
//				case "insert": view = insert(request, response); break;
//				case "delete": view = delete(request, response); break;
//			}
//		}
//		getServletContext().getRequestDispatcher("/ch09MyBatisAnnotation/" + view).forward(request, response);
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
//	public String delete(HttpServletRequest request, HttpServletResponse response) {
//		String id = request.getParameter("id");
//		dao.delete(id);
//		return list(request, response);
//	}
//}
