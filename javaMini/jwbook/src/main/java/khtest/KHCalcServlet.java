package khtest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class KHCalcServlet
 */
@WebServlet("/calcKGH")
public class KHCalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KHCalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int n1 = Integer.parseInt(request.getParameter("n1"));
	    int n2 = Integer.parseInt(request.getParameter("n2"));
	    int n3 = Integer.parseInt(request.getParameter("n3"));
	    int n4 = Integer.parseInt(request.getParameter("n4"));
	    int n5 = Integer.parseInt(request.getParameter("n5"));
		
	    int result = 0;
	    result = n1+n2+n3+n4+n5;
		
		response.setContentType("text/html; charset=utf-8");
	    PrintWriter out = response.getWriter();
	    out.append("<html><body><h2> 계산기 서블릿 </h2><hr>")
	       .append("계산 결과: " +result +"</body></html>");
	  }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
