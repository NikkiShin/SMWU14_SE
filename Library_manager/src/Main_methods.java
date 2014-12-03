import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// 회원가입을 위해서...
// login을 위해서...
public class Main_methods {
	private Connection dc;

	public Main_methods() {
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

	// 회원가입을 위해서...
	public boolean registerMember(String id, String pass, String name,
			String department) {
		String query = "insert into SE_member_st values (?, ?, ?, ?)";
		
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

	// login을 위해서...
	public boolean loginMember(String id, String pass) {
		String query = "select * from SE_member_st where id = ? and password = ?";
		
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
	
	// for Add Book_Info.., 

		public boolean addBook(int num, String title, String author, String publisher, int isbn, String avail, String rentBy) {
			String query = "insert into booklist values(?,?,?,?,?,?,?)";
			
			try {
				PreparedStatement pstmt = dc.prepareStatement(query);
				pstmt.setInt(1,num);// null 어떻게 넣는지
				pstmt.setString(2, title);
				pstmt.setString(3, author);
				pstmt.setString(4, publisher);
				pstmt.setInt(5, isbn);
				pstmt.setString(6,avail);
				pstmt.setString(7, rentBy);;
				pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException ee) {
				System.err.println("Fail Add the Book: " + ee.toString());
				return false;
			}
			return true;
		}

}

