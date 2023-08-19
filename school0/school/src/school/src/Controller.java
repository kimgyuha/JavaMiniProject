package school.src;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Controller {
	Scanner sc = new Scanner(System.in);
	                           //객체 수
	List<Subject> subjectList = new ArrayList<Subject>(); //하나만 있으면 됨
	Map<String, Integer> stuscoMap; //과목&학생 짝이므로 과목*학생 만큼 만들어야됨
	List<Map<String, Integer>> stuscoList; // 과목수만큼 만들어야됨
	//맵을 하나씩 가져오려면 List에 다시 넣어줘야함, BUT totalList에는 Map이 들어가야함
	Map<Subject, Map<String, Integer>> totalMap = new HashMap<>(); //하나 필요
//	List<Score> scoreList = new ArrayList<Score>(); 없어도됨
	
	int subIdx;
	String subjectName;
	String studentName;
	
	public void mainList() {
		
		System.out.println("=== 학생 관리 페이지 ===");
		System.out.print("과목을 추가하시겠습니까?[Y/N]: ");
		char yesorno = sc.next().charAt(0);
		sc.nextLine();//이걸 넣어줘야 제대로 작동함
		if(yesorno == 'Y'|| yesorno == 'y') {
			addSubject();
			stuscoList.add(stuscoMap);
			System.out.print("과목별 학생의 성적 정보를 조회하시겠습니까?[Y/N]: ");
			yesorno = sc.next().charAt(0);
			if(yesorno == 'Y'||yesorno == 'y') {
				System.out.println(totalMap);
			}
		
			mainList();
		}
		System.out.println("프로그램종료");
	}	
		public void addSubject() {
			subIdx=1;
			while(true) {
			System.out.print(subIdx+"번째로 추가할 과목명을 입력하세요(없을 경우 'x'입력): ");
			subjectName = sc.nextLine();
			if(subjectName.equals("x") || subjectName.equals("X") ) {
				break;
			}
			Subject subject = new Subject(subjectName);//과목별 객체를 만들어서
			subjectList.add(subject); //과목리스트에 넣어야함
			stuscoList = new ArrayList<>();
			stuscoMap = new HashMap<>();
			addStudent();
			
			totalMap.put(subjectList.get(subIdx-1), stuscoList.get(subIdx-1));//인덱스!!! 인덱스는 x-1
			//Map을 List에 넣어야 맵을 하나씩 가져오는 게 가능함
			//stuscoList를 맵을 담은 리스트로 만들되 totalMap은 Subject와 Map<String, Integer>을 인수로 가져아함
			//List<Map<String, Integer>>을 인수로 가지면 안됨!
			subIdx++;
			}
			
		}
		public void addStudent() { // 0~
			int stuIdx=1;
			while(true) {
			System.out.print(stuIdx+"번째로 추가할 학생의 이름을 입력하세요(없을 경우 'x' 입력): ");
			studentName = sc.nextLine();
			if(studentName.equals("x") || studentName.equals("X") ) {
				break;
			}
			Student student = new Student(studentName); //학생 객체 만듦
			//studentList.add(student); //학생리스트에 학생넣음
			int studentScore = addScore(studentName); //학생별 점수 추가 함수 호출하고 점수 받아옴
			stuscoMap.put(studentName, studentScore);
			stuscoList.add(stuscoMap);
			stuIdx++;
			}
		}
		public int addScore(String studentName) { 
//			int subNum = subjects.length-1;
			System.out.print(studentName + "의 " + subjectList.get(subIdx-1)+ "점수를 입력하세요: "); 		
			int stuScore = sc.nextInt();
			sc.nextLine();
			//scoreList.add(score);
			return stuScore;
			}
		
		}




		