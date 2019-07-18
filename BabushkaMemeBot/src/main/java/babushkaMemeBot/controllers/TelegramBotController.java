package babushkaMemeBot.controllers;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import babushkaMemeBot.keyboard.Keyboard;
import babushkaMemeBot.services.ScheduledService;
import babushkaMemeBot.services.UserService;

public class TelegramBotController extends TelegramLongPollingBot {

	@Autowired
	UserService userService;

	@Autowired
	Keyboard keyboard;

	@Autowired
	ScheduledService scheduledService;

	private String botToken;

	private String botUsername;

	public void onUpdateReceived(Update update) {

		try {
			processUpdate(update);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

	}

	private void processUpdate(Update update) throws TelegramApiException {
		if (update.hasMessage() && update.getMessage().hasText() && !update.getMessage().hasAudio()) {

			String messageText = update.getMessage().getText();
			Long id = update.getMessage().getChat().getId();

			if (keyboard.hasName(messageText)) {

				execute(new SendPhoto().setChatId(id).setPhoto(keyboard.getUrlForName(messageText)));

			} else {
				switch (messageText) {
				case "/start":
					String name = update.getMessage().getChat().getUserName();
					String firstName = update.getMessage().getChat().getFirstName();
					String lastName = update.getMessage().getChat().getLastName();

					userService.loginUser(id, name, firstName, lastName);

					execute(new SendMessage().setChatId(id).setText("Welcome").setReplyMarkup(keyboard.getKeyboard()));
					break;
				}
			}
		}

	}

	@PostConstruct
	public void dbPopulate() {
		try {
			scheduledService.refreshMemeTemplates();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
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
