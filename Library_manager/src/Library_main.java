import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//회원가입 중복확인

public class Library_main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Main_methods dao = new Main_methods();
		while (true) {
			System.out.println("1. 학생 로그인\n2. 사서 로그인\n3. 회원가입\n4. 종료\n메뉴를 입력하세요 : ");
			int x = System.in.read() - 48;
			System.in.read();
			System.in.read();
			if (x == 1) {
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
						System.out.println("");
					}
				}
			} else if (x == 2) {
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
								System.out.println("administer로 로그인되었습니다.");
								System.out.println("1. 도서 정보 추가		2. 도서 정보 수정		3. 도서 정보 삭제 		4. 로그아웃 ");
								int st_menu = System.in.read() - 48;
								System.in.read();
								System.in.read();
								if (st_menu == 1) {
									System.out.println("도서 정보 추가 페이지입니다.");
									new Admin_BookAdd();
									System.out.println();
								} else if (st_menu == 2) {
									System.out.println("도서 정보 수정 페이지입니다.");
									new Admin_BookUpdat();
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
						System.out.println("");
					}
				}
			} else if (x == 3) {
				System.out.println("회원가입 페이지 입니다. -1 입력 시 메뉴로 돌아갑니다.");
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
								System.out.println("* 비밀번호가 일치하지 않습니다.");
							if(!passconfirm.equals("-1")&&confirm.equals("Yes")){
								System.out.println("* 비밀번호 일치");
								System.out.print("name : ");
								String name = in.readLine();
								if(!name.equals("-1")){ 
									System.out.print("department : ");
									String department = in.readLine();
									if(!department.equals("-1")){ 
										boolean bool = dao.registerMember(id, pass, name, department);
										if (bool)
											System.out.println("회원가입에 성공하였습니다~!");
										else
											System.out.println("회원가입에 실패하였습니다!!");
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
				System.err.println("잘못 입력!!");
			}
		}
	}
}