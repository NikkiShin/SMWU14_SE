import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//학생 로그인시 메인 화면 구현
public class Student_login {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	Library_methods dao = new Library_methods();	
	
	public Student_login()throws IOException{
		System.out.println("로그인 페이지 입니다. -1 입력 시 메뉴로 돌아갑니다.");
		System.out.print("ID : ");
		String id = in.readLine();
		if(!id.equals("-1")){
			System.out.print("Password : ");
			String pass = in.readLine();
			if(!pass.equals("-1")){
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
							dao.checkRent(id);
							System.out.println();
						} else if (st_menu == 2) {
							System.out.println("도서검색 페이지 입니다.");
							String book_sub;
							do{
								System.out.print("도서 제목(3자 이상) : ");
								book_sub = in.readLine();
								if(book_sub.length()<3)
									System.out.println("3글자 이상으로 입력하세요.");
							}
							while(book_sub.length()<3);
							dao.searchBook(book_sub);
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
				System.out.println("");
			}
		}
		
		
	}
	
}

