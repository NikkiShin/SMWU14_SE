import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class Admin_methodsTest {

	@Test
	public void updateBookTeset() throws NumberFormatException, IOException {
		Admin_methods meo = new Admin_methods();
		assertTrue(meo.updateBook(11)==true);
	}
	
	@Test
	public void deleteBookTeset() throws NumberFormatException, IOException {
		Admin_methods meo = new Admin_methods();
		assertTrue(meo.deleteBook(33)==true);
	}
	

}
