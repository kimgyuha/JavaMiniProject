
package ch09;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/studentControl")
public class StudentController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
    StudentDAO dao;
    public void init(ServletConfig config) throws ServletException {
    // TODO Auto-generated method stub
    super.init(config);
    dao = new StudentDAO();
 }


  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    request.setCharacterEncoding("utf-8");
    String action = request.getParameter("action");
    String view = "";
    
    if(action == null) {
      getServletContext().getRequestDispatcher("/studentControl?action=list")
      .forward(request,response);
//      return;
    }else {
      switch(action){
      case "list": view = list(request, response); break;
      case "insert": view = insert(request, response); break;
      case "delete0": view = deleteLastStudent(request, response); break;
      case "delete1": view = deleteSelectedStudent(request, response); break;
      case "delete2": view = deleteVersion2(request, response); break;
      //여기서 delete 두개 때문에 꼬임
      }
      getServletContext().getRequestDispatcher("/ch09/"+view)
      .forward(request, response);
      } 
    }

  public String list(HttpServletRequest request, HttpServletResponse response)
  {
    request.setAttribute("students", dao.getStudents());
    return "studentInfo.jsp";
    
    
  }
  public String insert(HttpServletRequest request, HttpServletResponse response) {
    Student s = new Student();
    try {
      BeanUtils.populate(s, request.getParameterMap());
    } catch (Exception e) {e.printStackTrace();}
    dao.insertStudent(s);
    return list(request, response);
    }
  
  public String deleteLastStudent(HttpServletRequest request, HttpServletResponse response) {
	    Student s = new Student();
	    try {
	      BeanUtils.populate(s, request.getParameterMap());
	    } catch (Exception e) {e.printStackTrace();}
	    dao.deleteLastStudent(s);
	    return list(request, response);
	    }
  public String deleteSelectedStudent(HttpServletRequest request, HttpServletResponse response) {
	    Student s = new Student();
	    try {
	      BeanUtils.populate(s, request.getParameterMap());
	    } catch (Exception e) {e.printStackTrace();}
	    dao.deleteSelectedStudent(s);
	    return list(request, response);
	    }
  
  public String deleteVersion2(HttpServletRequest request, HttpServletResponse response) {
	  String id = request.getParameter("id");
	  dao.deleteVersion2(id);
	  return list(request, response);
  }
	}