import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Admin_BookUpdat {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	Admin_methods db = new Admin_methods();
	
	
	public Admin_BookUpdat() throws IOException{
		System.out.print("ISBN ют╥б: ");
		int isbn = Integer.parseInt(in.readLine());
		db.updateBook(isbn);
	
	}
}
