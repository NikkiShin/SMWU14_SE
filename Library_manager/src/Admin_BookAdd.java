import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.sql.Connection;

public class Admin_BookAdd{
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	//private Connection add;
	Main_methods dad = new Main_methods();
	//Admin_BookAdd ab = new Admin_BookAdd();



	/*// for Add Book_Info.., 

	public boolean addBook(int num, String title, String author, String publisher, int isbn, String avail, String rentBy) {
		String query = "insert into booklist (?,?,?,?,?,?,?)";

		try {
			PreparedStatement pstmt = add.prepareStatement(query);
			pstmt.setInt(1,num);// null ��� �ִ���
			pstmt.setString(2, title);
			pstmt.setString(3, author);
			pstmt.setString(4, publisher);
			pstmt.setInt(5, isbn);
			pstmt.setString(6,avail);
			pstmt.setString(7, rentBy);;
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ee) {
			System.err.println("Faill Add the Book: " + ee.toString());
			return false;
		}
		return true;
	}
	 */

	public Admin_BookAdd()throws IOException{
		System.out.println("ISBN : ");
		int isbn = Integer.parseInt(in.readLine());	
		//ISBN �ߺ� üũ�ϰ� ��� ���� ���� �Ǵ�

		System.out.println("���� : ");
		String title = in.readLine();
		System.out.println("���� : ");
		String author = in.readLine();

		System.out.println("���ǻ� : ");
		String publisher = in.readLine();

		int num= 0;
		String avail = "X";
		String rentBy = null;
		boolean bool = dad.addBook(num,title,author, publisher,isbn,avail, rentBy); 

		if (bool)
			System.out.println("======������ �߰��Ͽ����ϴ�.=======");
		else
			System.out.println("======������ �߰����� ���߽��ϴ�.=======");



	}


}