package ch10;

import java.io.IOException;
import java.lang.reflect.Method;
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
//h2데이터베이스와 상호작용하며 뉴스 데이터를 가져오거나(list) add, delete하는 메서드 제공
//NewsController 객체: NewsController 객체는 뷰(newsList.jsp, newsView.jsp)와 연결하고 
//클라이언트와 상호작용하여 화면에 뉴스 데이터를 표시하거나 사용자 입력을 처리함
//클라이언트의 요청을 받고, NewsDAO를 사용하여 데이터베이스에서 데이터를 가져오거나 조작한 후, 
//이를 뷰에 전달하여 웹 페이지에 뉴스 목록을 표시하거나 개별 뉴스를 보여줌

import ch10.vo.NewsDAO;
import ch10.vo.NewsDO;



@WebServlet("/news.nhn") // 서블릿을 웹에 매핑함
@MultipartConfig(maxFileSize = 1024 * 1024 * 2, location = "c:/Temp/img")
//maxFileSize = 업로드할 파일 최대 크기 제한, location = 업로드된 파일을 저장할 위치를 지정함
public class NewsController extends HttpServlet { // HttpServlet을 상속한 서블릿(=NewsController)을 만드는 클래스
	private static final long serialVersionUID = 1L;

	private NewsDAO dao;//DB와 연결된 NewsDAO객체와 연결할 변수 지정
	private ServletContext ctx; // ~객체의 변수 선언

	// 웹 리소스 기본 경로 지정
	private final String START_PAGE = "ch10/newsList.jsp"; // START_PAGE에 jsp파일(스타트페이지)을 담아둠

	public void init(ServletConfig config) throws ServletException {// ServletConfig(=인터페이스)
		// config = ServletConfig를 구현한 객체
		super.init(config);// 서블릿 초기화 작업, 부모클래스(HttpServlet)의 초기화도 함께 함
		// config을 통해 서블릿에 필요한 초기화 정보를 전달함
		dao = new NewsDAO(); // 데이터베이스와 상호작용할 수 있게 해주는 초기화 작업중 하나
		ctx = getServletContext();// 현재 서블릿의 ServletContext 객체에 대한 참조(주소)를 ctx에 저장
		//서블릿이 돌아가는 엔진
	}
	// ServletContext 객체 = 웹 환경 정보를 제공, 서블릿들 간 데이터 공유 지원

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// service = HttpServlet클래스의 메서드(오버라이딩), 서블릿이 호출될때마다 실행
		//클라이언트의 HTTP 요청을 처리하고 응답을 생성함
		// HttpServletRequest = HTTP요청에 대한 정보를 추상화한 인터페이스
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		// Http요청 파라미터 중 action파라미터를 받아와서 action에 저장
		//dao = new NewsDAO();

		Method m;
		String view = null;

		// action 파라미터 없이 접근한 경우
		if (action == null) {
			action = "listNews";//전체 뉴스리스트(뉴스목록)를 보여줌
		}
		try {
			// 현재 클래스에서 action 이름과 HttpServletRequest 를 파라미터로 하는 메서드 찾음
			m = this.getClass().getMethod(action, HttpServletRequest.class);
			//현재 클래스에서 action이 일치하고 HttpServletRequest를 파라미터로 받는 메서드를 찾음
			//아래 addNews, listNews... 중에서 호출된 함수 찾음
		
			view = (String) m.invoke(this, request); 
			//해당 메서드를 실행하고 결과를 view에 저장함
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			// 에러 로그를 남기고 view 를 로그인 화면으로 지정, 앞에서와 같이 redirection 사용도 가능.
			ctx.log("요청 action 없음!!");
			request.setAttribute("error", "action 파라미터가 잘못 되었습니다!!");
			view = START_PAGE;//찾는 액션이 없으면 스타트페이지를 뷰에 담음
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (view.startsWith("redirect:/")) {
			//view에 담긴 문자열이 redirect:/로 시작하면 리디렉션(웹페이지 이동)을 수행함
			String rview = view.substring("redirect:/".length());
			//substring함수를 써서 redirect:/ 이후 문자열을 가져옴
			response.sendRedirect(rview);
			//redirect:/ 이후 문자열 로 응답(~페이지로 연결함)
		} else {
			// 지정된 뷰로 포워딩, 포워딩시 컨텍스트경로는 필요없음.
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			//view에 담긴 문자열이 redirect:/로 시작하지 않으면 현재 페이지에 forwarding
			dispatcher.forward(request, response);		
		}
	}

	public String addNews(HttpServletRequest request) {
		NewsDO n = new NewsDO();
		try {
			// 이미지 파일 저장
			Part part = request.getPart("file");
			String fileName = getFilename(part);//getFilename 메서드를 호출하여 fileName에 이름 저장
			if (fileName != null && !fileName.isEmpty()) {
				//파일이 업로드 되었다면
				part.write(fileName);
				//업로드된 파일을 디스크에 저장함 (파일 이름은 fileName에 저장된 내용으로)
			}
			// 입력값을 News 객체로 매핑
			BeanUtils.populate(n, request.getParameterMap());
			//http요청에서 받은 데이터를 NewsDO 객체에 자동으로 설정
			n.setImg("/img/" + fileName);
			// 이미지 파일의 경로를 NewsDO객체에 설정
			dao.addNews(n);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("뉴스 추가 과정에서 문제 발생!!");
			request.setAttribute("error", "뉴스가 정상적으로 등록되지 않았습니다!!");
			return listNews(request); //뉴스 목록 페이지로 돌아감
		}
		return "redirect:/news.nhn?action=listNews";//"listNews" 액션으로 리다이렉션
		//새로 추가한 뉴스를 포함한 뉴스리스트를 newsList.jsp에 요청
	}

	public String listNews(HttpServletRequest request) {
		//모든 뉴스 기사 목록을 조회하고 해당 목록을 request객체에 저장함
		List<NewsDO> list;
		try {
			list = dao.getAll();
			request.setAttribute("newslist", list);
			//request.setAttribute(key, value);
			// HttpServletRequest 객체의 메서드로서 jsp페이지로 데이터를 전달함
		} catch (Exception e) { //예외발생시 화면에 보여줄 문구(처리)
			e.printStackTrace();
			ctx.log("뉴스 목록 생성 과정에서 문제 발생!!");
			request.setAttribute("error", "뉴스 목록이 정상적으로 처리되지 않았습니다!!");
		}
		return "ch10/newsList.jsp";
		//뉴스 목록을 보여줌
	}

	public String getNews(HttpServletRequest request) {
		int aid = Integer.parseInt(request.getParameter("aid"));
		try {
			NewsDO n = dao.getNews(aid);
			request.setAttribute("news", n);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("뉴스를 가져오는 과정에서 문제 발생!!");
			request.setAttribute("error", "뉴스를 정상적으로 가져오지 못했습니다!!");
		}

		return "ch10/newsView.jsp";
	}

	public String deleteNews(HttpServletRequest request) {
		int aid = Integer.parseInt(request.getParameter("aid"));
		try {
			dao.delNews(aid);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("뉴스 삭제 과정에서 문제 발생!!");
			request.setAttribute("error", "뉴스가 정상적으로 삭제되지 않았습니다!!");
			return listNews(request);
		}
		return "redirect:/news.nhn?action=listNews";
	}

	// multipart 헤더에서 파일이름 추출
	private String getFilename(Part part) {
		String fileName = null;
		// 파일이름이 들어있는 헤더 영역을 가지고 옴
		String header = part.getHeader("content-disposition");
		// part.getHeader -> form-data; name="img"; filename="사진5.jpg"
		System.out.println("Header => " + header);

		// 파일 이름이 들어있는 속성 부분의 시작위치를 가져와 쌍따옴표 사이의 값 부분만 가지고옴
		int start = header.indexOf("filename=");
		fileName = header.substring(start + 10, header.length() - 1);
		ctx.log("파일명:" + fileName);
		return fileName;
	}
}