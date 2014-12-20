import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//회원가입 기능 구현
public class Student_join {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	Library_methods dao = new Library_methods();
	
	public Student_join()throws IOException{
		String id;
		System.out.println("회원가입 페이지 입니다. -1 입력 시 메뉴로 돌아갑니다.");
		
		do{
			System.out.print("ID: ");
			id = in.readLine();
			if (id.equals("-1"))
				break;
			if(dao.idValid(id)==false)
				System.out.println("이미 가입된 id 입니다.");
			if(idLength(id)==false || isNumber(id)==false)
				System.out.println("id는 7자리 숫자여야 합니다.");
			if(dao.idValid(id)==true && idLength(id)==true && isNumber(id)==true)
				System.out.println("가입 가능한 id입니다.");
			
		}while(dao.idValid(id)==false || idLength(id)==false || isNumber(id)==false);
		
	//	int id_validity = Integer.parseInt(id);
		
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
									System.out.println("회원가입에 성공하였습니다.");
								else
									System.out.println("회원가입에 실패하였습니다.");
								System.out.println("");
							}
						}
					}
				}
			}while(confirm.equals("No"));
		}
	}

	public boolean idLength(String s) {
		if (s.length()!=7){
			return false;
//				id_validity = Integer.parseInt(id);
		}
		else 
			return true;
	}
	
	public boolean isNumber(String s){
		try{
			Integer.parseInt(s);
		}catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}
	

}
