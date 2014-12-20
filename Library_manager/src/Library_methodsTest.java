import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class Library_methodsTest {

	@Test
	public void testRegisterMember() {
		Library_methods lib_method = new Library_methods();
		assertTrue(lib_method.registerMember("1357973", "7777", "Odd", "Mathematics")==true);
	}

	@Test
	public void testLoginMember() {
		Library_methods lib_method = new Library_methods();
		assertTrue(lib_method.loginMember("1011234", "1234")==true);
	}
	
	

}
