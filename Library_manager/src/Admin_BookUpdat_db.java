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
	public boolean checkISBN(int isbn, boolean check) throws NumberFormatException, IOException{
		
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
				//stmt.close();
				
				//141203수정(SRS참고  3.1.9의 6번) 항목 번호를 선택하면 기존 도서 정보가 나타나고 수정할 항목을 텍스트로 입력한다. 

				/*ISBN을 수정하지 않으면 where값으로 ISBN을 두어 도서 정보를 수정할 수 있다. 
				하지만 이미 1번 메뉴를 눌러 ISBN값을 수정하고 나서 3,4,5번메뉴를 선택하면 ISBN값이 바뀌어서 수정할 수없다...어떡하지?
				그래서 일단 where값을 임시로 title, author로 두었음.*/

				while(check==true){
					System.out.print("수정할 항목을 선택하세요: ");
					int selectNum = Integer.parseInt(in.readLine());

					if(selectNum==1){

						System.out.println("\n1. ISBN: " + ISBN);
						System.out.println("1. New ISBN: ");
						int newISBN = Integer.parseInt(in.readLine());
						String sql1="update Booklist set ISBN=" + newISBN + " where ISBN=" + ISBN;
						stmt.executeUpdate(sql1);

					}else if(selectNum==2){

						System.out.println("\n2. 제목: " + title);
						System.out.println("2. New title: ");
						String newTitle = in.readLine();
						String sql2="update Booklist set title='" + newTitle + "' where title='" + title + "'"; 
						stmt.executeUpdate(sql2);

					}else if(selectNum==3){
						System.out.println("\n3. 저자: " + author);
						System.out.println("3. New author: ");
						String newAuthor = in.readLine();
						String sql3="update Booklist set author='" + newAuthor + "' where author='" + author + "'"; 
						stmt.executeUpdate(sql3);

					}else if(selectNum==4){
						System.out.println("\n4. 출판사: " + publisher);
						System.out.println("4. New publisher: ");
						String newPublisher = in.readLine();
						String sql4="update Booklist set publisher='" + newPublisher + "' where publisher='" + publisher + "'"; 
						stmt.executeUpdate(sql4);

					}else if(selectNum==5){
						System.out.println("\n5. 대여 가능 여부: " + availability + " / 대여자: " + RentBy);
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
						System.out.println("수정완료 되었습니다. 사서 메뉴로 돌아갑니다");
						break;

					}else{
						System.out.println("1~6번 사이의 숫자만 입력해주세요!");
					}

				}
				//원래 else였음 수정부분만!
			}else if(!rs.next() && check==true)
				System.out.println("해당 도서에 대한 정보가 존재하지 않습니다. 수정 불가능합니다!");
			
			else if(!rs.next() && check==false){
				System.out.println("해당 도서에 대한 정보가 존재하지 않습니다. 삭제 불가능합니다!");
				return false;
			}
			}catch (SQLException ee) {
			System.err.println("찾는 책이 없습니다!! : " + ee.toString());
			
		}
		return true;
	}


}
