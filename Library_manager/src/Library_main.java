import java.io.IOException;



public class Library_main {
	public static void main(String[] args) throws IOException {
		while (true) {
			System.out.println("1. 학생 로그인\n2. 사서 로그인\n3. 회원가입\n4. 종료\n메뉴를 입력하세요 : ");
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
				System.err.println("잘못된 입력입니다.");
			}
		}
	}
}