import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//ȸ������ ��� ����
public class Student_join {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	Library_methods dao = new Library_methods();
	
	public Student_join()throws IOException{
		System.out.println("ȸ������ ������ �Դϴ�. -1 �Է� �� �޴��� ���ư��ϴ�.");
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

}
