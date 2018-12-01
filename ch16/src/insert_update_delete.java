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
		// 1. ������Ʈ���� ����Ŭ ����̹� �߰� �ƴ��� Ȯ��(�ڹ�, ����Ŭ ���� ���� ����)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. ������ ���� 
			conn = DriverManager.getConnection(ip, id, pw);
			
		} catch (Exception e) {
			System.out.println("error : "+e.getMessage());
		}
	}
	
	public void insert() {
		System.out.println(" ��� ��� ");
		System.out.println(" ����� : ");
		String name = sc.nextLine();
		System.out.println(" ���� : ");
		int sal = sc.nextInt();
		System.out.println(" ���� : ");
		int age = sc.nextInt();
		System.out.println(" �̸��� : ");
		String email = sc.next();		
		
		
		String sql=" insert into emp values(EMP_SEQ.NEXTVAL, ?,?,?,?,2000) "; // ? �� �ڹ� ���� ����
		//�ڹ� ������ ������ â
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name); // 1:  ? ����
			pstmt.setInt(2, sal);
			pstmt.setInt(3, age);
			pstmt.setString(4, email);
			
			// ���� ���� : 1, ���� : 0
			int result = pstmt.executeUpdate(); 
			
			if (result > 0) {
				System.out.println("�Է¼���");
			}else {
				System.out.println("�Է½���");
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
		System.out.println("������ ���: ");
		String name = sc.nextLine();
		
		String sql = "delete from emp where name = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("����");
			}else {
				System.out.println("����");
			}
		} catch (Exception e) {
			System.out.println("error :" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void update() {
		System.out.println("������ ��� : ");
		String updatename = sc.nextLine();
		System.out.println("������ ���� : ");
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
