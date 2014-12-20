import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//ȸ������ ��� ����
public class Student_join {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	Library_methods dao = new Library_methods();
	
	public Student_join()throws IOException{
		String id;
		System.out.println("ȸ������ ������ �Դϴ�. -1 �Է� �� �޴��� ���ư��ϴ�.");
		
		do{
			System.out.print("ID: ");
			id = in.readLine();
			if (id.equals("-1"))
				break;
			if(dao.idValid(id)==false)
				System.out.println("�̹� ���Ե� id �Դϴ�.");
			if(idLength(id)==false || isNumber(id)==false)
				System.out.println("id�� 7�ڸ� ���ڿ��� �մϴ�.");
			if(dao.idValid(id)==true && idLength(id)==true && isNumber(id)==true)
				System.out.println("���� ������ id�Դϴ�.");
			
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
						System.out.println("* ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
					if(!passconfirm.equals("-1")&&confirm.equals("Yes")){
						System.out.println("* ��й�ȣ ��ġ");
						System.out.print("name : ");
						String name = in.readLine();
						if(!name.equals("-1")){ 
							System.out.print("department : ");
							String department = in.readLine();
							if(!department.equals("-1")){ 
								boolean bool = dao.registerMember(id, pass, name, department);
								if (bool)
									System.out.println("ȸ�����Կ� �����Ͽ����ϴ�.");
								else
									System.out.println("ȸ�����Կ� �����Ͽ����ϴ�.");
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
