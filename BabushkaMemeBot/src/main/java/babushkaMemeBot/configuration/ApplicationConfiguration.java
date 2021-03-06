package babushkaMemeBot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import babushkaMemeBot.BabushkaMemeBotApplication;
import babushkaMemeBot.dao.impl.MemeTemplateDAOImpl;
import babushkaMemeBot.dao.impl.UserDAOImpl;
import babushkaMemeBot.keyboard.Keyboard;
import babushkaMemeBot.services.UserService;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public BabushkaMemeBotApplication babushkaMemeBotApplication() {
		return new BabushkaMemeBotApplication();
	}

	@Bean
	public UserDAOImpl userDAOImpl() {
		return new UserDAOImpl();
	}

	@Bean
	public UserService userService() {
		return new UserService();
	}

	@Bean
	public MemeTemplateDAOImpl memeTemplateDAOImpl() {
		return new MemeTemplateDAOImpl();
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public Keyboard keyboard() {
		return new Keyboard();
	}

}
