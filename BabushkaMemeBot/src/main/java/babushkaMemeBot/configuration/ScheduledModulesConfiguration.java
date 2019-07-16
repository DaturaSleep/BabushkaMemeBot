package babushkaMemeBot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import babushkaMemeBot.services.ScheduledService;

@Configuration
@EnableScheduling
public class ScheduledModulesConfiguration {
	
	@Bean
	public ScheduledService scheduledService() {
		return new ScheduledService();
	}
}
