import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Admin_BookUpdat_db {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private Connection conn;
	private java.sql.Statement stmt;

	public Admin_BookUpdat_db() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			return;
		}
		String url = "jdbc:mysql://127.0.0.1:3306/java";
		String id = "root";
		String pass = "1234";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
		} catch (SQLException ee) {
		}
	}

	//ISBN Ȯ��
	//CREATE TABLE Booklist (num int PRIMARY KEY auto_increment, title varchar(20), author varchar(10), publisher varchar(10), ISBN int, availability varchar(1), RentBy varchar(10)); 
	public void checkISBN(int isbn) throws NumberFormatException, IOException{
		String query = "select title, author, publisher, ISBN, availability, RentBy from Booklist where ISBN=" + isbn;

		try {

			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				String title=rs.getString("title");
				String author=rs.getString("author");
				String publisher=rs.getString("publisher");
				int ISBN=rs.getInt("ISBN");
				String availability=rs.getString("availability");
				String RentBy=rs.getString("RentBy");

				System.out.println("\n1. ISBN: " + ISBN);
				System.out.println("2. ����: " + title);
				System.out.println("3. ����: " + author);
				System.out.println("4. ���ǻ�: " + publisher);
				System.out.println("5. �뿩 ���� ����: " + availability + " / �뿩��: " + RentBy);
				System.out.println("6. �Ϸ�\n");
				//System.out.println(title + "   " + author + "   "+ publisher+ "   " + ISBN + "   "+ availability+ "   "+RentBy);
				stmt.close();

				System.out.print("������ �׸��� �����ϼ���: ");
				int selectNum = Integer.parseInt(in.readLine());
				if(selectNum==1){
					//�߰��� ����
				}
				else if(selectNum==2){
					//�߰��� ����
				}


			}else
				System.out.println("�ش� ������ ���� ������ �������� �ʽ��ϴ�. ���� �Ұ����մϴ�!");

		}catch (SQLException ee) {
			System.err.println("ã�� å�� �����ϴ�!! : " + ee.toString());
			//return false;
		}
		//return true;
	}


}