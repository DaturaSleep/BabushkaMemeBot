package babushkaMemeBot.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import babushkaMemeBot.services.TelegramBotService;

@Configuration
@PropertySource("classpath:telegram.properties")
public class TelegramBotConfiguration {
	
	@Value("${bot.token}")
	private String botToken;
	
	@Value("${bot.username}")
	private String botUsername;
	
	@Bean
	public TelegramBotService telegramBotService() {
		TelegramBotService telegramBotService = new TelegramBotService();
		telegramBotService.setBotToken(botToken);
		telegramBotService.setBotUsername(botUsername);
		return telegramBotService;
		
	}
}
