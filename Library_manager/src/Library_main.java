import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Library_main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Main_methods dao = new Main_methods();
		while (true) {
			System.out.println("1. 학생 로그인		2. 사서 로그인		3.회원가입		4.종료 ");
			int x = System.in.read() - 48;
			System.in.read();
			System.in.read();
			if (x == 1) {
				System.out.println("로그인 페이지 입니다.");
				System.out.print("ID : ");
				String id = in.readLine();
				System.out.print("Password : ");
				String pass = in.readLine();
				boolean bool = dao.loginMember(id, pass);
				if (bool)
					System.out.println("로그인에 성공하였습니다~!");
				else
					System.out.println("로그인에 실패하였습니다");
				System.out.println();
			} else if (x == 2) {
				System.out.println("로그인 페이지 입니다.");
				System.out.print("ID : ");
				String id = in.readLine();
				System.out.print("Password : ");
				String pass = in.readLine();
				boolean bool = dao.loginMember(id, pass);
				if (bool)
					System.out.println("로그인에 성공하였습니다~!");
				else
					System.out.println("로그인에 실패하였습니다");
				System.out.println();
			} else if (x == 3) {
				System.out.println("회원가입 페이지 입니다.");
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
					System.out.println("회원가입에 성공하였습니다~!");
				else
					System.out.println("회원가입에 실패하였습니다!!");
				System.out.println();
			} else if (x == 4) {
				System.exit(0);
			} else {
				System.err.println("잘못 입력!!");
			}
		}
	}
}
