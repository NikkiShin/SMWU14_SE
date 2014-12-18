import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//사서 로그인시 메인 화면 구현
public class Admin_login {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	Library_methods dao = new Library_methods();	
	
	public Admin_login()throws IOException{
		System.out.println("로그인 페이지 입니다. -1 입력 시 메뉴로 돌아갑니다.");
		System.out.print("ID : ");
		String id = in.readLine();
		if(!id.equals("-1")){
			System.out.print("Password : ");
			String pass = in.readLine();
			if(!id.equals("-1")){
				boolean bool = dao.loginMember(id, pass);
				if (bool){
					System.out.println("로그인에 성공하였습니다~!");
					while(true){
						System.out.println("\n<<administer로 로그인되었습니다>>");
						System.out.println("1. 도서 정보 추가\n2. 도서 정보 수정\n3. 도서 정보 삭제\n4. 로그아웃 ");
						System.out.print("메뉴 선택: ");
						int st_menu = System.in.read() - 48;
						System.in.read();
						System.in.read();
						if (st_menu == 1) {
							System.out.println("\n도서 정보 추가 페이지입니다.");
							new Admin_BookAdd();
							System.out.println();
						} else if (st_menu == 2) {
							System.out.println("\n도서 정보 수정 페이지입니다.");
							new Admin_BookUpdat();
							System.out.println();
						} else if (st_menu == 3) {
							System.out.println("\n도서 정보 삭제 페이지입니다.");
							new Admin_BookDelete();
							System.out.println();
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
				System.out.println("");
			}
		}
		
		
	}
	
}

