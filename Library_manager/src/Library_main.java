import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//ȸ������ �ߺ�Ȯ��

public class Library_main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Main_methods dao = new Main_methods();
		while (true) {
			System.out.println("1. �л� �α���\n2. �缭 �α���\n3. ȸ������\n4. ����\n�޴��� �Է��ϼ��� : ");
			int x = System.in.read() - 48;
			System.in.read();
			System.in.read();
			if (x == 1) {
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
						System.out.println("");
					}
				}
			} else if (x == 2) {
				System.out.println("�α��� ������ �Դϴ�. -1 �Է� �� �޴��� ���ư��ϴ�.");
				System.out.print("ID : ");
				String id = in.readLine();
				if(!id.equals("-1")){
					System.out.print("Password : ");
					String pass = in.readLine();
					if(!id.equals("-1")){
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
									new Admin_BookAdd();
									System.out.println();
								} else if (st_menu == 2) {
									System.out.println("���� ���� ���� �������Դϴ�.");
									new Admin_BookUpdat();
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
						System.out.println("");
					}
				}
			} else if (x == 3) {
				System.out.println("ȸ������ ������ �Դϴ�. -1 �Է� �� �޴��� ���ư��ϴ�.");
				System.out.print("ID: ");
				String id = in.readLine();
				if(!id.equals("-1")){
					String confirm = "No";
					do{
						System.out.print("Password : ");
						String pass = in.readLine();
						if(!pass.equals("-1")){ 
							System.out.print("Password Confirm : ");
							String passconfirm = in.readLine();
							if(pass.equals(passconfirm))
								confirm = "Yes";
							else
								System.out.println("* ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
							if(!passconfirm.equals("-1")&&confirm.equals("Yes")){
								System.out.println("* ��й�ȣ ��ġ");
								System.out.print("name : ");
								String name = in.readLine();
								if(!name.equals("-1")){ 
									System.out.print("department : ");
									String department = in.readLine();
									if(!department.equals("-1")){ 
										boolean bool = dao.registerMember(id, pass, name, department);
										if (bool)
											System.out.println("ȸ�����Կ� �����Ͽ����ϴ�~!");
										else
											System.out.println("ȸ�����Կ� �����Ͽ����ϴ�!!");
										System.out.println("");
									}
								}
							}
						}
					}while(confirm.equals("No"));
				}
			} else if (x == 4) {
				System.exit(0);
			} else {
				System.err.println("�߸� �Է�!!");
			}
		}
	}
}