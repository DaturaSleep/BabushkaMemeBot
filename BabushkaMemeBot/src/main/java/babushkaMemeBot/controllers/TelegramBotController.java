package babushkaMemeBot.controllers;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import babushkaMemeBot.services.ScheduledService;
import babushkaMemeBot.services.UserService;

public class TelegramBotController extends TelegramLongPollingBot {

	@Autowired
	UserService userService;

	@Autowired
	ScheduledService scheduledService;

	private String botToken;

	private String botUsername;

	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
					.setText(update.getMessage().getText());
			Long id = update.getMessage().getChat().getId();
			String name = update.getMessage().getChat().getUserName();
			String firstName = update.getMessage().getChat().getFirstName();
			String lastName = update.getMessage().getChat().getLastName();

			userService.loginUser(id, name, firstName, lastName);
			try {
				execute(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}

	}

	@PostConstruct
	public void dbPopulate() {
		try {
			scheduledService.refreshMemeTemplates();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public String getBotUsername() {

		return botUsername;
	}

	@Override
	public String getBotToken() {

		return botToken;
	}

	public void setBotToken(String botToken) {
		this.botToken = botToken;
	}

	public void setBotUsername(String botUsername) {
		this.botUsername = botUsername;
	}

}
