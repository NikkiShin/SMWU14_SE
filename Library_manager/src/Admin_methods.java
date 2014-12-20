import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin_methods {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private Connection conn;
	private java.sql.Statement stmt;


	public Admin_methods() {
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


	//Adding Book information into the system
	public boolean addBook(int num, String title, String author, String publisher, int isbn, String avail, String rentBy) {
		String query = "insert into Booklist values(?,?,?,?,?,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
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
			//System.err.println("Fail Add the Book: " + ee.toString());
			System.err.println("ISBN�� �ߺ��Ǿ� �߰��� �� �����ϴ�");
			return false;
		}
		return true;
	}


	//check ISBN for updating book information
	public boolean updateBook(int isbn) throws NumberFormatException, IOException{

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
				//stmt.close();

				//141203����(SRS����  3.1.9�� 6��) �׸� ��ȣ�� �����ϸ� ���� ���� ������ ��Ÿ���� ������ �׸��� �ؽ�Ʈ�� �Է��Ѵ�. 

				/*ISBN�� �������� ������ where������ ISBN�� �ξ� ���� ������ ������ �� �ִ�. 
				������ �̹� 1�� �޴��� ���� ISBN���� �����ϰ� ���� 3,4,5���޴��� �����ϸ� ISBN���� �ٲ� ������ ������...�����?
				�׷��� �ϴ� where���� �ӽ÷� title, author�� �ξ���.*/

				while(true){
					System.out.print("������ �׸��� �����ϼ���: ");
					int selectNum = Integer.parseInt(in.readLine());

					if(selectNum==1){

						System.out.println("\n1. ISBN: " + ISBN);
						System.out.println("1. New ISBN: ");
						int newISBN = Integer.parseInt(in.readLine());
						String sql1="update Booklist set ISBN=" + newISBN + " where ISBN=" + ISBN;
						stmt.executeUpdate(sql1);

					}else if(selectNum==2){

						System.out.println("\n2. ����: " + title);
						System.out.println("2. New title: ");
						String newTitle = in.readLine();
						String sql2="update Booklist set title='" + newTitle + "' where title='" + title + "'"; 
						stmt.executeUpdate(sql2);

					}else if(selectNum==3){
						System.out.println("\n3. ����: " + author);
						System.out.println("3. New author: ");
						String newAuthor = in.readLine();
						String sql3="update Booklist set author='" + newAuthor + "' where author='" + author + "'"; 
						stmt.executeUpdate(sql3);

					}else if(selectNum==4){
						System.out.println("\n4. ���ǻ�: " + publisher);
						System.out.println("4. New publisher: ");
						String newPublisher = in.readLine();
						String sql4="update Booklist set publisher='" + newPublisher + "' where publisher='" + publisher + "'"; 
						stmt.executeUpdate(sql4);

					}else if(selectNum==5){
						System.out.println("\n5. �뿩 ���� ����: " + availability + " / �뿩��: " + RentBy);
						System.out.println("5. New availability: ");
						String newAvail = in.readLine();
						System.out.println("5. New RentBy: ");
						String newRentBy = in.readLine();
						String sql5="update Booklist set availability='" + newAvail +"', ";
						sql5 = sql5 + " RentBy='" + newRentBy + "'";
						//sql5 = sql5 + " where availability='" + availability + "' and RentBy='" + RentBy + "'";

						sql5 = sql5 + " where ISBN=" + ISBN;
						stmt.executeUpdate(sql5);

					}else if(selectNum==6){
						System.out.println("�����Ϸ� �Ǿ����ϴ�. �缭 �޴��� ���ư��ϴ�");
						break;

					}else{
						System.out.println("1~6�� ������ ���ڸ� �Է����ּ���.");
					}


				}
			}else
				System.out.println("�ش� ������ ���� ������ �������� �ʽ��ϴ�. ���� �Ұ����մϴ�.");


		}catch (SQLException ee) {
			System.err.println("ã�� å�� �����ϴ�!! : " + ee.toString());

		}
		return true;
	}


	//check ISBN for deleting book information
	public boolean deleteBook(int isbn) throws NumberFormatException, IOException{

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

				System.out.println("\n ISBN: " + ISBN);
				System.out.println("����: " + title);
				System.out.println("����: " + author);
				System.out.println("���ǻ�: " + publisher);
				System.out.println("�뿩 ���� ����: " + availability + " / �뿩��: " + RentBy);


				System.out.println("<�����Ϸ��� 1, ����Ϸ��� 0�� �Է��ϼ���>");
				int selectNum=Integer.parseInt(in.readLine());

				if(selectNum==1 && availability.equals("O")){

					String sql_delete = "delete from Booklist where ISBN = ?";
					try {
						PreparedStatement pstmt = conn.prepareStatement(sql_delete);
						pstmt.setInt(1, isbn);
						pstmt.executeUpdate();
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					System.out.println("���� �Ǿ����ϴ�!");
				}
				else if(selectNum==1 && availability.equals("X")){
					System.out.println("�뿩�ڰ� ���� �ݳ� �� ���� �����մϴ�.");
				}

				else if(selectNum==0){
					System.out.println("��ҵǾ����ϴ�. �缭 �޴��� ���ư��ϴ�");
				}

			}
			else
				System.out.println("�ش� ������ ���� ������ �������� �ʽ��ϴ�. ���� �Ұ����մϴ�!");

		}catch (SQLException ee) {
			System.err.println("ã�� å�� �����ϴ�!! : " + ee.toString());

		}
		return true;
	}
}
