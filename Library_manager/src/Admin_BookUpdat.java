import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Admin_BookUpdat {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	Admin_BookUpdat_db db = new Admin_BookUpdat_db();
	
	
	public Admin_BookUpdat() throws IOException{
		//System.out.println("===ISBN으로 수정할 도서 검색===");
		System.out.print("ISBN 입력: ");
		int isbn = Integer.parseInt(in.readLine());
		db.checkISBN(isbn);
		
		
		
	}
}