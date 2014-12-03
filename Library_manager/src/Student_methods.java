import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student_methods {
	private Connection dc;

	public Student_methods() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			return;
		}
		String url = "jdbc:mysql://127.0.0.1:3306/java";
		String id = "root";
		String pass = "1234";
		try {
			dc = DriverManager.getConnection(url, id, pass);
		} catch (SQLException ee) {
		}
	}

	//대여 정보 조회 
	public String checkRent(String id){
		String query = "select * from Booklist where RentBy = ?";
	//	String query_2 = "select count(*) from Booklist where RentBy = ?";
		System.out.println("ISBN \t  title \t\t author \t publisher \t " );
		
		try {
			PreparedStatement pstmt = dc.prepareStatement(query);	
			pstmt.setString(1, id);
		//	pstmt.executeQuery(query);
			ResultSet rs = pstmt.executeQuery();
			//System.out.println("ISBN \t  title \t\t author \t publisher \t " );
			
			while(rs.next()){
				//int no = rs.getInt(1);
				String title = rs.getString(2);
				String author = rs.getString(3);
				String publisher = rs.getString(4);
				int ISBN = rs.getInt(5);
				//String availability = rs.getString(6);
				//String Rentby = rs.getString(7);
				System.out.println(ISBN + " \t " + title+ " \t\t " + author + " \t " + publisher + " \t " );					
			}
			
			pstmt.close();
		} catch (SQLException ee ) {
			System.err.println("대여 중인 도서가 없습니다." + ee.toString());		//이게 안나옴 ㅜㅜ***************
		}
		
		return null;
	}

	// 도서 검색
	public String searchBook(String substr_book) {
		String query = "select * from Booklist where title like ?";
		System.out.println("ISBN \t  title \t\t author \t publisher \t availability " );
		
		try {
			PreparedStatement pstmt = dc.prepareStatement(query);	
			pstmt.setString(1, "%" + substr_book + "%");
		//	pstmt.executeQuery(query);
			ResultSet rs = pstmt.executeQuery();
			//System.out.println("ISBN \t  title \t\t author \t publisher \t " );
			
			while(rs.next()){
				//int no = rs.getInt(1);
				String title = rs.getString(2);
				String author = rs.getString(3);
				String publisher = rs.getString(4);
				int ISBN = rs.getInt(5);
				String availability = rs.getString(6);
				//String Rentby = rs.getString(7);
				System.out.println(ISBN + " \t " + title+ " \t\t " + author + " \t " + publisher + " \t " + availability);					
			}
			
			pstmt.close();
		} catch (SQLException ee ) {
			System.err.println("대여 중인 도서가 없습니다." + ee.toString());		//이게 안나옴 ㅜㅜ***************
		}
		
		return null;
	}

}