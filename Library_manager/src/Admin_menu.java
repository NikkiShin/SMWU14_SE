import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Admin_menu {

	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public Admin_menu() throws IOException
	{
		System.out.println("<<사서로 로그인 중입니다...>>");
		System.out.println("=====메뉴=====");
		System.out.println("1. 도서 정보 추가\n2. 도서 정보 수정\n3. 도서 정보 삭제\n4.로그아웃");
		System.out.print("메뉴 선택: ");
		
		int selectNum = Integer.parseInt(in.readLine());
		if(selectNum==1){
			new Admin_BookAdd();
		}
		if(selectNum==2){
			new Admin_BookUpdat();
		}
		if(selectNum==3){
			//구현
		}
		if(selectNum==4){
			//구현
		}
	}
}
