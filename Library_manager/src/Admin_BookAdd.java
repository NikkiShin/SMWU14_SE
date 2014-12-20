import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Admin_BookAdd{
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	Admin_methods dao = new Admin_methods();
	boolean bool;

	public Admin_BookAdd()throws IOException{
		System.out.println("ISBN : ");
		//int isbn = Integer.parseInt(in.readLine());	
		String isbn=in.readLine();
		//ISBN �ߺ� üũ�ϰ� ��� ���� ���� �Ǵ�

		System.out.println("���� : ");
		String title = in.readLine();
		System.out.println("���� : ");
		String author = in.readLine();

		System.out.println("���ǻ� : ");
		String publisher = in.readLine();

		int num= 0;
		String avail = "O";
		String rentBy = "X";

		if("".equals(isbn) || "".equals(title) || "".equals(author) || "".equals(publisher))
			System.out.println("������ ������ �ʽ��ϴ�. ����� �Է����ּ���");
		else
			bool = dao.addBook(num, title, author, publisher, Integer.parseInt(isbn), avail, rentBy); 

		if (bool)
			System.out.println("======������ �߰��Ͽ����ϴ�.=======");
		else
			System.out.println("======������ �߰����� ���߽��ϴ�.=======");


	}


}