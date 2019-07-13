package babushkaMemeBot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import babushkaMemeBot.services.TelegramBotService;

@ComponentScan(basePackages = "babushkaMemeBot.configuration")
@Configuration
public class BabushkaMemeBotApplication {

	public static void main(String args[]) {
		ApiContextInitializer.init();
		registerBot();
	}

	private static void registerBot() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				BabushkaMemeBotApplication.class);

		TelegramBotsApi botsApi = new TelegramBotsApi();

		try {
			botsApi.registerBot(ctx.getBean(TelegramBotService.class));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

		ctx.close();
	}
}
