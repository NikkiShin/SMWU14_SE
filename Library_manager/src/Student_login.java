import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//�л� �α��ν� ���� ȭ�� ����
public class Student_login {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	Library_methods dao = new Library_methods();	
	
	public Student_login()throws IOException{
		System.out.println("�α��� ������ �Դϴ�. -1 �Է� �� �޴��� ���ư��ϴ�.");
		System.out.print("ID : ");
		String id = in.readLine();
		if(!id.equals("-1")){
			System.out.print("Password : ");
			String pass = in.readLine();
			if(!pass.equals("-1")){
				boolean bool = dao.loginMember(id, pass);
				if (bool){
					while(true){
						System.out.println(id + "�� �α��εǾ����ϴ�.");
						System.out.println("1. �뿩 ���� ��ȸ		2. ���� �˻�		3. �α׾ƿ� ");
						int st_menu = System.in.read() - 48;
						System.in.read();
						System.in.read();
						if (st_menu == 1) {
							System.out.println(id + "���� ���� �뿩 �����Դϴ�.");
							dao.checkRent(id);
							System.out.println();
						} else if (st_menu == 2) {
							System.out.println("�����˻� ������ �Դϴ�.");
							String book_sub;
							do{
								System.out.print("���� ����(3�� �̻�) : ");
								book_sub = in.readLine();
								if(book_sub.length()<3)
									System.out.println("3���� �̻����� �Է��ϼ���.");
							}
							while(book_sub.length()<3);
							dao.searchBook(book_sub);
							System.out.println();
						} else if (st_menu == 3) {
							System.out.println("�α׾ƿ��Ǿ����ϴ�.");
							break;
						} else {
							System.err.println("�߸��� �Է��Դϴ�.");
						}
					}
				}
				else
					System.out.println("�α��ο� �����Ͽ����ϴ�");
				System.out.println("");
			}
		}
		
		
	}
	
}

