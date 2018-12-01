import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class insert_update_delete {
	
	public final String ip = "jdbc:oracle:thin:@192.168.100.121:1521:xe";
	public final String id="STU";
	public final String pw="STU";
	Connection conn;  
	Scanner sc = new Scanner(System.in);
	
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
	
	public void insert() {
		System.out.println(" 사원 등록 ");
		System.out.println(" 사원명 : ");
		String name = sc.nextLine();
		System.out.println(" 연봉 : ");
		int sal = sc.nextInt();
		System.out.println(" 나이 : ");
		int age = sc.nextInt();
		System.out.println(" 이메일 : ");
		String email = sc.next();		
		
		
		String sql=" insert into emp values(EMP_SEQ.NEXTVAL, ?,?,?,?,2000) "; // ? 에 자바 변수 넣음
		//자바 변수가 많을때 창
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name); // 1:  ? 순서
			pstmt.setInt(2, sal);
			pstmt.setInt(3, age);
			pstmt.setString(4, email);
			
			// 실행 성공 : 1, 실패 : 0
			int result = pstmt.executeUpdate(); 
			
			if (result > 0) {
				System.out.println("입력성공");
			}else {
				System.out.println("입력실패");
			}			
			
		} catch (Exception e) {
			System.out.println("error :"+ e.getMessage());
		}
	}
	
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete() {
		System.out.println("삭제할 사람: ");
		String name = sc.nextLine();
		
		String sql = "delete from emp where name = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
		} catch (Exception e) {
			System.out.println("error :" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void update() {
		System.out.println("수정할 사람 : ");
		String updatename = sc.nextLine();
		System.out.println("수정할 연봉 : ");
		String money = sc.nextLine();
		String sql = "update emp set sal = ? where name = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, money);
			pstmt.setString(2, updatename);
			
			int result = pstmt.executeUpdate();
			
			if() {
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		insert_update_delete i = new insert_update_delete();
		i.init();
		//i.insert();
		//i.delete();
		i.update();
		i.close();

	}

}
