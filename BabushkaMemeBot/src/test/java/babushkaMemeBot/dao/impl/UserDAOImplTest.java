package babushkaMemeBot.dao.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import babushkaMemeBot.dao.UserDAO;
import babushkaMemeBot.models.User;

public class UserDAOImplTest {
	
	private UserDAO userRepository;
	
	@Before
	public void setUp() {
		userRepository = new UserDAOImpl();
	}
	
	@Test
	public void testSaveUser(){
		User user = new User(5l,"Lech");
		userRepository.saveUser(user);
		assertEquals("Lech", userRepository.getUserById(5l).getUsername());
	}
	
}
