import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Library_methods {
	private Connection dc;

	public Library_methods() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			return;
		}
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pass = "1234";
		try {
			dc = DriverManager.getConnection(url, id, pass);
		} catch (SQLException ee) {
		}
	}

	// 회원가입_DB
	public boolean registerMember(String id, String pass, String name,
			String department) {
		String query = "insert into Library_Member values (?, ?, ?, ?)";

		try {
			PreparedStatement pstmt = dc.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			pstmt.setString(3, name);
			pstmt.setString(4, department);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ee) {
			System.err.println("회원 가입 실패!! : " + ee.toString());
			return false;
		}
		return true;
	}

	// 학생 로그인_DB
	public boolean loginMember(String id, String pass) {
		String query = "select * from Library_Member where id = ? and password = ?";

		try {
			PreparedStatement pstmt = dc.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) {
				rs.close();
				pstmt.close();
				return false;
			}
			rs.close();
			pstmt.close();
		} catch (SQLException ee) {
			System.err.println("login 처리 실패!!");
		}
		return true;
	}



	//대여 정보 조회 
	public String checkRent(String id){
		String query = "select * from Booklist where RentBy = ?";
		//	String query_2 = "select count(*) from Booklist where RentBy = ?";
		int ISBN = -1;

		try {
			PreparedStatement pstmt = dc.prepareStatement(query);	
			pstmt.setString(1, id);
			//	pstmt.executeQuery(query);
			ResultSet rs = pstmt.executeQuery();
			//System.out.println("ISBN \t  title \t\t author \t publisher \t " );

			rs.last();
			int nRecord = rs.getRow();
			rs.beforeFirst();

			if(nRecord==0)
				System.out.println("대여 중인 도서가 없습니다.");
			else
				System.out.println("\nISBN \t  title \t\t author \t publisher \t " );

			while(rs.next()){
				//int no = rs.getInt(1);
				String title = rs.getString(2);
				String author = rs.getString(3);
				String publisher = rs.getString(4);
				ISBN = rs.getInt(5);
				//String availability = rs.getString(6);
				//String Rentby = rs.getString(7);

				System.out.println(ISBN + " \t " + title+ " \t\t " + author + " \t " + publisher + " \t " );					
			}

			pstmt.close();
		} catch (SQLException ee ) {
			//System.err.println("대여 중인 도서가 없습니다." + ee.toString());		//이게 안나옴 ㅜㅜ***************
		}

		return null;
	}

	// 도서 검색
	public String searchBook(String substr_book) {
		String query = "select * from Booklist where title like ? ORDER BY ISBN ASC";

		try {
			PreparedStatement pstmt = dc.prepareStatement(query);	
			pstmt.setString(1, "%" + substr_book + "%");
			//	pstmt.executeQuery(query);
			ResultSet rs = pstmt.executeQuery();
			//System.out.println("ISBN \t  title \t\t author \t publisher \t " );

			rs.last();
			int nRecord = rs.getRow();
			rs.beforeFirst();

			if(nRecord==0)
				System.out.println("검색 결과가 없습니다.");
			else
				System.out.println("\nISBN \t  title \t\t author \t publisher \t availability " );

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
			//System.err.println("대여 중인 도서가 없습니다." + ee.toString());		//이게 안나옴 ㅜㅜ***************
		}

		return null;
	}


}
