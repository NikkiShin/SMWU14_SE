import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Admin_menu {

	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public Admin_menu() throws IOException
	{
		System.out.println("<<�缭�� �α��� ���Դϴ�...>>");
		System.out.println("=====�޴�=====");
		System.out.println("1. ���� ���� �߰�\n2. ���� ���� ����\n3. ���� ���� ����\n4.�α׾ƿ�");
		System.out.print("�޴� ����: ");
		
		int selectNum = Integer.parseInt(in.readLine());
		if(selectNum==1){
			new Admin_BookAdd();
		}
		if(selectNum==2){
			new Admin_BookUpdat();
		}
		if(selectNum==3){
			//����
		}
		if(selectNum==4){
			//����
		}
	}
}
