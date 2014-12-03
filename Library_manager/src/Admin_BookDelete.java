import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Admin_BookDelete {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	Admin_BookUpdat_db db = new Admin_BookUpdat_db();
	private Connection conn;


	public Admin_BookDelete() throws IOException{

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
		} catch (SQLException ee) {
		}

		//System.out.println("===도서 정보 삭제===");
		System.out.print("ISBN 입력: ");
		int isbn = Integer.parseInt(in.readLine());
		boolean a=db.checkISBN(isbn, false);

		if(a){
			System.out.println("<삭제하려면 1, 취소하려면 0을 입력하세요>");
			int selectNum=Integer.parseInt(in.readLine());

			if(selectNum==1){
				String sql_delete = "delete from booklist where ISBN = ?";
				try {
					PreparedStatement pstmt = conn.prepareStatement(sql_delete);
					pstmt.setInt(1, isbn);
					pstmt.executeUpdate();
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("삭제 되었습니다!");
			}
			else if(selectNum==0){
				System.out.println("취소되었습니다. 사서 메뉴로 돌아갑니다");
			}
		}
	}
}
