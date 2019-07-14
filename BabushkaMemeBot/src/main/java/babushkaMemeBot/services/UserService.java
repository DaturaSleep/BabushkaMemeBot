package babushkaMemeBot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import babushkaMemeBot.dao.UserDAO;
import babushkaMemeBot.models.User;

@Service
public class UserService {

	@Autowired
	UserDAO userRepository;
	
	@Transactional
	public User loginUser(Long id, String username, String firstName, String lastName) {

		User loggedUser;

		if ((loggedUser = userRepository.getUserById(id)) == null) {
			loggedUser = new User(id, username, firstName, lastName);
			userRepository.saveUser(loggedUser);
			return loggedUser;
			
		}
		return loggedUser;
		
	}
}
