import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//�缭 �α��ν� ���� ȭ�� ����
public class Admin_login {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public Admin_login()throws IOException{
		System.out.println("�α��� ������ �Դϴ�. -1 �Է� �� �޴��� ���ư��ϴ�.");
		System.out.print("ID : ");
		String id = in.readLine();
		if(!id.equals("-1")){
			System.out.print("Password : ");
			String pass = in.readLine();
			if(!id.equals("-1")){
				if (id.equals("admin") && pass.equals("1111")){
					System.out.println("�α��ο� �����Ͽ����ϴ�~!");
					while(true){
						System.out.println("\n<<administer�� �α��εǾ����ϴ�>>");
						System.out.println("1. ���� ���� �߰�\n2. ���� ���� ����\n3. ���� ���� ����\n4. �α׾ƿ� ");
						System.out.print("�޴� ����: ");
						int st_menu = System.in.read() - 48;
						System.in.read();
						System.in.read();
						if (st_menu == 1) {
							System.out.println("\n���� ���� �߰� �������Դϴ�.");
							new Admin_BookAdd();
							System.out.println();
						} else if (st_menu == 2) {
							System.out.println("\n���� ���� ���� �������Դϴ�.");
							new Admin_BookUpdat();
							System.out.println();
						} else if (st_menu == 3) {
							System.out.println("\n���� ���� ���� �������Դϴ�.");
							new Admin_BookDelete();
							System.out.println();
						} else if (st_menu == 4) {
							System.out.println("�α׾ƿ��Ǿ����ϴ�.");
							break;
						} else {
							System.out.println("1~4�� ������ ���ڸ� �Է����ּ���.");
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