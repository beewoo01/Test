import java.sql.*;
import java.util.Scanner;

public class Select {
	
	public final String ip = "jdbc:oracle:thin:@192.168.100.121:1521:xe";
	public final String id="STU";
	public final String pw="STU";
	  
	Connection conn;
	
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
	
	public void selectAll() {
		// 3. ������ ���� �ִ� â ����
		try {
			Statement stmt = conn.createStatement();
			
			//String sql = " select * from emp order by sal asc";
			//String sql = " select name, sal from emp order by sal asc";
			String sql = " select * from emp where sal>2000 order by sal asc";
			
			//4. ���� ��ư 
			// ** select ��ȸ�� ����� ǥ���� 
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) { // ǥ���¿��� Ŀ���� Ȯ���� �����ٿ� �����Ͱ� ������ ���� 
				int id = rs.getInt("ID"); // �� �̸� 
				String name = rs.getString("NAME");
				int sal = rs.getInt(3); // �����ε�
				int age = rs.getInt(4);
				String email = rs.getString("EMAIL");
				
				System.out.println(id+" " +name + " " +" "+sal + " " +  age + " "+email);
			}
			
			stmt.close(); // â �ݱ�
			conn.close(); // ���� ����
		} catch (Exception e) {
			System.out.println("error : "+e.getMessage());
		}
		
	}
	
	public void selectSearch() {
		// 3. ������ ���� �ִ� â ����
		try {
			Statement stmt = conn.createStatement();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("�˻��� ��� :");
		    String sc_name = sc.nextLine();
			
			//String sql = " select * from emp order by sal asc";
			//String sql = " select name, sal from emp order by sal asc";
			String sql = " select * from emp where name='"+sc_name+"' order by sal asc";
			
			//4. ���� ��ư 
			// ** select ��ȸ�� ����� ǥ���� 
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) { // ǥ���¿��� Ŀ���� Ȯ���� �����ٿ� �����Ͱ� ������ ���� 
				int id = rs.getInt("ID"); // �� �̸� 
				String name = rs.getString("NAME");
				int sal = rs.getInt(3); // �����ε�
				int age = rs.getInt(4);
				String email = rs.getString("EMAIL");
				
				System.out.println(id+" " +name + " " +" "+sal + " " +  age + " "+email);
			}
			
			stmt.close(); // â �ݱ�
			conn.close(); // ���� ����
		} catch (Exception e) {
			System.out.println("error : "+e.getMessage());
		}
		
	}
	
	

	public void selectSearch() {
		// 3. ������ ���� �ִ� â ����
		try {
			Statement stmt = conn.createStatement();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("�˻��� ��� :");
		    String sc_name = sc.nextLine();
			
			//String sql = " select * from emp order by sal asc";
			//String sql = " select name, sal from emp order by sal asc";
			String sql = " select * from emp where name='"+sc_name+"' order by sal asc";
			
			//4. ���� ��ư 
			// ** select ��ȸ�� ����� ǥ���� 
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) { // ǥ���¿��� Ŀ���� Ȯ���� �����ٿ� �����Ͱ� ������ ���� 
				int id = rs.getInt("ID"); // �� �̸� 
				String name = rs.getString("NAME");
				int sal = rs.getInt(3); // �����ε�
				int age = rs.getInt(4);
				String email = rs.getString("EMAIL");
				
				System.out.println(id+" " +name + " " +" "+sal + " " +  age + " "+email);
			}
			
			stmt.close(); // â �ݱ�
			conn.close(); // ���� ����
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
