import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Library_main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Main_methods dao = new Main_methods();
	//	Student_methods dao2 = new Student_methods();
		while (true) {
			System.out.println("1. 학생 로그인		2. 사서 로그인		3.회원가입		4.종료 ");
			int x = System.in.read() - 48;
			System.in.read();
			System.in.read();
			if (x == 1) {
				System.out.println(" 학생 로그인 페이지 입니다.");
				System.out.print("ID : ");
				String id = in.readLine();
				System.out.print("Password : ");
				String pass = in.readLine();
				boolean bool = dao.loginMember(id, pass);
				if (bool){
					while(true){
						System.out.println(id + "로 로그인되었습니다.");
						System.out.println("1. 대여 정보 조회		2. 도서 검색		3. 로그아웃 ");
						int st_menu = System.in.read() - 48;
						System.in.read();
						System.in.read();
						if (st_menu == 1) {
							System.out.println(id + "님의 도서 대여 정보입니다.");
					//		String rent_info = dao2.checkRent(id);
					/*		System.out.print("ID : ");
							String id = in.readLine();
							System.out.print("Password : ");
							String pass = in.readLine();
							boolean bool = dao.loginMember(id, pass);
							if (bool)
								System.out.println("로그인에 성공하였습니다~!");
							else
								System.out.println("로그인에 실패하였습니다");*/
							System.out.println();
						} else if (st_menu == 2) {
							System.out.println("도서검색 페이지 입니다.");
							System.out.print("도서 제목(3자 이상) : ");
							String book_sub = in.readLine();
					/*		boolean bool = dao.loginMember(id, pass);
							if (bool)
								System.out.println("로그인에 성공하였습니다~!");
							else
								System.out.println("로그인에 실패하였습니다");*/
							System.out.println();
						} else if (st_menu == 3) {
							System.out.println("로그아웃되었습니다.");
							break;
						} else {
							System.err.println("잘못된 입력입니다.");
						}
					}
				}
				else
					System.out.println("로그인에 실패하였습니다");
				System.out.println();
			} else if (x == 2) {
				System.out.println(" 사서 로그인 페이지 입니다.");
				System.out.print("ID : ");
				String id = in.readLine();
				System.out.print("Password : ");
				String pass = in.readLine();
				boolean bool = dao.loginMember(id, pass);
				if (bool){
					System.out.println("로그인에 성공하였습니다~!");
					while(true){
						System.out.println("administer로 로그인되었습니다.");
						System.out.println("1. 도서 정보 추가		2. 도서 정보 수정		3. 도서 정보 삭제 		4. 로그아웃 ");
						int st_menu = System.in.read() - 48;
						System.in.read();
						System.in.read();
						if (st_menu == 1) {
							System.out.println("도서 정보 추가 페이지입니다.");
							//구현
							System.out.println();
						} else if (st_menu == 2) {
							System.out.println("도서 정보 수정 페이지입니다.");
							//구현
							System.out.println();
						} else if (st_menu == 3) {
							System.out.println("도서 정보 삭제 페이지입니다.");
							//구현
						} else if (st_menu == 4) {
							System.out.println("로그아웃되었습니다.");
							break;
						} else {
							System.err.println("잘못된 입력입니다.");
						}
					}
				}
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
				System.err.println("잘못된 입력입니다.");
			}
		}
	}
}
