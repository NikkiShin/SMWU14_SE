import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.sql.Connection;

public class Admin_BookAdd{
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	Library_methods dao = new Library_methods();

	
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
		String avail = "O";
		String rentBy = null;
		boolean bool = dao.addBook(num,title,author, publisher,isbn,avail, rentBy); 

		if (bool)
			System.out.println("======������ �߰��Ͽ����ϴ�.=======");
		else
			System.out.println("======������ �߰����� ���߽��ϴ�.=======");



	}


}