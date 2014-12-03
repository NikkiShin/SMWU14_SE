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

	//ISBN 확인
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
				System.out.println("2. 제목: " + title);
				System.out.println("3. 저자: " + author);
				System.out.println("4. 출판사: " + publisher);
				System.out.println("5. 대여 가능 여부: " + availability + " / 대여자: " + RentBy);
				System.out.println("6. 완료\n");
				//System.out.println(title + "   " + author + "   "+ publisher+ "   " + ISBN + "   "+ availability+ "   "+RentBy);
				stmt.close();

				System.out.print("수정할 항목을 선택하세요: ");
				int selectNum = Integer.parseInt(in.readLine());
				if(selectNum==1){
					//추가할 예정
				}
				else if(selectNum==2){
					//추가할 예정
				}


			}else
				System.out.println("해당 도서에 대한 정보가 존재하지 않습니다. 수정 불가능합니다!");

		}catch (SQLException ee) {
			System.err.println("찾는 책이 없습니다!! : " + ee.toString());
			//return false;
		}
		//return true;
	}


}