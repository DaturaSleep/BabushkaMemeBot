package babushkaMemeBot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import babushkaMemeBot.BabushkaMemeBotApplication;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public BabushkaMemeBotApplication babushkaMemeBotApplication() {
		return new BabushkaMemeBotApplication();
	}
}
