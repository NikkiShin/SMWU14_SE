<<<<<<< HEAD
<<<<<<< HEAD

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
				System.out.println(" �л� �α��� ������ �Դϴ�. -1 �Է� �� �޴��� ���ư��ϴ�.");
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
								//������ �ڵ� ����. �л� �޴��κ��� class�� ���� ���ֱ�!
								//new Student_menu();
							}
						}
						else
							System.out.println("�α��ο� �����Ͽ����ϴ�");
						System.out.println();
					}
				}
			}
			else if (x == 2) {
				System.out.println("�α��� ������ �Դϴ�.");
				System.out.print("ID : ");
				String id = in.readLine();
				System.out.print("Password : ");
				String pass = in.readLine();
				boolean bool = dao.loginMember(id, pass);
				if (bool){
					System.out.println("�α��ο� �����Ͽ����ϴ�~!");
					new Admin_menu();
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
				System.err.println("�߸� �Է�!!");
			}
		}
	}
}

=======

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
				System.out.println(" �л� �α��� ������ �Դϴ�. -1 �Է� �� �޴��� ���ư��ϴ�.");
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
								//������ �ڵ� ����. �л� �޴��κ��� class�� ���� ���ֱ�!
								//new Student_menu();
							}
						}
						else
							System.out.println("�α��ο� �����Ͽ����ϴ�");
						System.out.println();
					}
				}
			}
			else if (x == 2) {
				System.out.println("�α��� ������ �Դϴ�.");
				System.out.print("ID : ");
				String id = in.readLine();
				System.out.print("Password : ");
				String pass = in.readLine();
				boolean bool = dao.loginMember(id, pass);
				if (bool){
					System.out.println("�α��ο� �����Ͽ����ϴ�~!");
					new Admin_menu();
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
				System.err.println("�߸� �Է�!!");
			}
		}
	}
}

>>>>>>> origin/master
=======

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
				System.out.println(" �л� �α��� ������ �Դϴ�. -1 �Է� �� �޴��� ���ư��ϴ�.");
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
								//������ �ڵ� ����. �л� �޴��κ��� class�� ���� ���ֱ�!
								//new Student_menu();
							}
						}
						else
							System.out.println("�α��ο� �����Ͽ����ϴ�");
						System.out.println();
					}
				}
			}
			else if (x == 2) {
				System.out.println("�α��� ������ �Դϴ�.");
				System.out.print("ID : ");
				String id = in.readLine();
				System.out.print("Password : ");
				String pass = in.readLine();
				boolean bool = dao.loginMember(id, pass);
				if (bool){
					System.out.println("�α��ο� �����Ͽ����ϴ�~!");
					new Admin_menu();
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
				System.err.println("�߸� �Է�!!");
			}
		}
	}
}

>>>>>>> origin/master
