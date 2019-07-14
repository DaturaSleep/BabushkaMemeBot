package babushkaMemeBot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import babushkaMemeBot.BabushkaMemeBotApplication;
import babushkaMemeBot.dao.impl.UserDAOImpl;

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
}
