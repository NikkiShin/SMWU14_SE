import java.io.IOException;



public class Library_main {
	public static void main(String[] args) throws IOException {
		while (true) {
			System.out.println("1. �л� �α���\n2. �缭 �α���\n3. ȸ������\n4. ����\n�޴��� �Է��ϼ��� : ");
			int x = System.in.read() - 48;
			System.in.read();
			System.in.read();
			if (x == 1) {
				new Student_login();
			} else if (x == 2) {
				new Admin_login();
			} else if (x == 3) {
				new Student_join();
			} else if (x == 4) {
				System.exit(0);
			} else {
				System.err.println("�߸��� �Է��Դϴ�.");
			}
		}
	}
}