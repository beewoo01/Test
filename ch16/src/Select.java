import java.sql.*;
import java.util.Scanner;

public class Select {
	
	public final String ip = "jdbc:oracle:thin:@192.168.100.121:1521:xe";
	public final String id="STU";
	public final String pw="STU";
	  
	Connection conn;
	
	public void init() {
		// 1. 프로젝트에서 오라클 드라이버 추가 됐는지 확인(자바, 오라클 연결 가능 여부)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. 서버에 연결 
			conn = DriverManager.getConnection(ip, id, pw);
			
		} catch (Exception e) {
			System.out.println("error : "+e.getMessage());
		}
	}
	
	public void selectAll() {
		// 3. 쿼리문 쓸수 있는 창 생성
		try {
			Statement stmt = conn.createStatement();
			
			//String sql = " select * from emp order by sal asc";
			//String sql = " select name, sal from emp order by sal asc";
			String sql = " select * from emp where sal>2000 order by sal asc";
			
			//4. 실행 버튼 
			// ** select 조회시 결과가 표형태 
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) { // 표형태에서 커서를 확인후 다음줄에 데이터가 있으면 실행 
				int id = rs.getInt("ID"); // 열 이름 
				String name = rs.getString("NAME");
				int sal = rs.getInt(3); // 순서로도
				int age = rs.getInt(4);
				String email = rs.getString("EMAIL");
				
				System.out.println(id+" " +name + " " +" "+sal + " " +  age + " "+email);
			}
			
			stmt.close(); // 창 닫기
			conn.close(); // 연결 해제
		} catch (Exception e) {
			System.out.println("error : "+e.getMessage());
		}
		
	}
	
	public void selectSearch() {
		// 3. 쿼리문 쓸수 있는 창 생성
		try {
			Statement stmt = conn.createStatement();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("검색할 사람 :");
		    String sc_name = sc.nextLine();
			
			//String sql = " select * from emp order by sal asc";
			//String sql = " select name, sal from emp order by sal asc";
			String sql = " select * from emp where name='"+sc_name+"' order by sal asc";
			
			//4. 실행 버튼 
			// ** select 조회시 결과가 표형태 
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) { // 표형태에서 커서를 확인후 다음줄에 데이터가 있으면 실행 
				int id = rs.getInt("ID"); // 열 이름 
				String name = rs.getString("NAME");
				int sal = rs.getInt(3); // 순서로도
				int age = rs.getInt(4);
				String email = rs.getString("EMAIL");
				
				System.out.println(id+" " +name + " " +" "+sal + " " +  age + " "+email);
			}
			
			stmt.close(); // 창 닫기
			conn.close(); // 연결 해제
		} catch (Exception e) {
			System.out.println("error : "+e.getMessage());
		}
		
	}
	
	

	public void selectSearch() {
		// 3. 쿼리문 쓸수 있는 창 생성
		try {
			Statement stmt = conn.createStatement();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("검색할 사람 :");
		    String sc_name = sc.nextLine();
			
			//String sql = " select * from emp order by sal asc";
			//String sql = " select name, sal from emp order by sal asc";
			String sql = " select * from emp where name='"+sc_name+"' order by sal asc";
			
			//4. 실행 버튼 
			// ** select 조회시 결과가 표형태 
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) { // 표형태에서 커서를 확인후 다음줄에 데이터가 있으면 실행 
				int id = rs.getInt("ID"); // 열 이름 
				String name = rs.getString("NAME");
				int sal = rs.getInt(3); // 순서로도
				int age = rs.getInt(4);
				String email = rs.getString("EMAIL");
				
				System.out.println(id+" " +name + " " +" "+sal + " " +  age + " "+email);
			}
			
			stmt.close(); // 창 닫기
			conn.close(); // 연결 해제
		} catch (Exception e) {
			System.out.println("error : "+e.getMessage());
		}
		
	}

	public static void main(String[] args) {
		Select s = new Select();
		s.init();
		s.selectAll();
		//s.selectSearch();
	}

}
