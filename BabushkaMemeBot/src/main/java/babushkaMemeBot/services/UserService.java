package babushkaMemeBot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import babushkaMemeBot.dao.MemeTemplateDAO;
import babushkaMemeBot.dao.UserDAO;
import babushkaMemeBot.models.MemeTemplate;
import babushkaMemeBot.models.User;

@Service
public class UserService {

	@Autowired
	UserDAO userRepository;
	
	@Autowired
	MemeTemplateDAO memeTemplateRepository;
	
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
	
	@Transactional(readOnly = true)
	public List<MemeTemplate> getAllMemeTemplates(){
		return memeTemplateRepository.getMemeTemplates();
	}
	
}
