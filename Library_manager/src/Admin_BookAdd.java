import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.sql.Connection;

public class Admin_BookAdd{
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	Main_methods dad = new Main_methods();

	
	public Admin_BookAdd()throws IOException{
		System.out.println("ISBN : ");
		int isbn = Integer.parseInt(in.readLine());	
		//ISBN 중복 체크하고 사용 가능 여부 판단

		System.out.println("제목 : ");
		String title = in.readLine();
		System.out.println("저자 : ");
		String author = in.readLine();

		System.out.println("출판사 : ");
		String publisher = in.readLine();

		int num= 0;
		String avail = "O";
		String rentBy = null;
		boolean bool = dad.addBook(num,title,author, publisher,isbn,avail, rentBy); 

		if (bool)
			System.out.println("======도서를 추가하였습니다.=======");
		else
			System.out.println("======도서를 추가하지 못했습니다.=======");



	}


}