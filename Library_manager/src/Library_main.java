import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Library_main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Main_methods dao = new Main_methods();
	//	Student_methods dao2 = new Student_methods();
		while (true) {
			System.out.println("1. �л� �α���		2. �缭 �α���		3.ȸ������		4.���� ");
			int x = System.in.read() - 48;
			System.in.read();
			System.in.read();
			if (x == 1) {
				System.out.println(" �л� �α��� ������ �Դϴ�.");
				System.out.print("ID : ");
				String id = in.readLine();
				System.out.print("Password : ");
				String pass = in.readLine();
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
					//		String rent_info = dao2.checkRent(id);
					/*		System.out.print("ID : ");
							String id = in.readLine();
							System.out.print("Password : ");
							String pass = in.readLine();
							boolean bool = dao.loginMember(id, pass);
							if (bool)
								System.out.println("�α��ο� �����Ͽ����ϴ�~!");
							else
								System.out.println("�α��ο� �����Ͽ����ϴ�");*/
							System.out.println();
						} else if (st_menu == 2) {
							System.out.println("�����˻� ������ �Դϴ�.");
							System.out.print("���� ����(3�� �̻�) : ");
							String book_sub = in.readLine();
					/*		boolean bool = dao.loginMember(id, pass);
							if (bool)
								System.out.println("�α��ο� �����Ͽ����ϴ�~!");
							else
								System.out.println("�α��ο� �����Ͽ����ϴ�");*/
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
				System.out.println();
			} else if (x == 2) {
				System.out.println(" �缭 �α��� ������ �Դϴ�.");
				System.out.print("ID : ");
				String id = in.readLine();
				System.out.print("Password : ");
				String pass = in.readLine();
				boolean bool = dao.loginMember(id, pass);
				if (bool){
					System.out.println("�α��ο� �����Ͽ����ϴ�~!");
					while(true){
						System.out.println("administer�� �α��εǾ����ϴ�.");
						System.out.println("1. ���� ���� �߰�		2. ���� ���� ����		3. ���� ���� ���� 		4. �α׾ƿ� ");
						int st_menu = System.in.read() - 48;
						System.in.read();
						System.in.read();
						if (st_menu == 1) {
							System.out.println("���� ���� �߰� �������Դϴ�.");
							//����
							System.out.println();
						} else if (st_menu == 2) {
							System.out.println("���� ���� ���� �������Դϴ�.");
							//����
							System.out.println();
						} else if (st_menu == 3) {
							System.out.println("���� ���� ���� �������Դϴ�.");
							//����
						} else if (st_menu == 4) {
							System.out.println("�α׾ƿ��Ǿ����ϴ�.");
							break;
						} else {
							System.err.println("�߸��� �Է��Դϴ�.");
						}
					}
				}
				else
					System.out.println("�α��ο� �����Ͽ����ϴ�");
				System.out.println();
			} else if (x == 3) {
				System.out.println("ȸ������ ������ �Դϴ�.");
				System.out.print("ID: ");
				String id = in.readLine();
				System.out.print("Password : ");
				String pass = in.readLine();
				System.out.print("name : ");
				String name = in.readLine();
				System.out.print("department : ");
				String department = in.readLine();
				boolean bool = dao.registerMember(id, pass, name, department);
				if (bool)
					System.out.println("ȸ�����Կ� �����Ͽ����ϴ�~!");
				else
					System.out.println("ȸ�����Կ� �����Ͽ����ϴ�!!");
				System.out.println();
			} else if (x == 4) {
				System.exit(0);
			} else {
				System.err.println("�߸��� �Է��Դϴ�.");
			}
		}
	}
}
