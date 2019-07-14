package babushkaMemeBot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import babushkaMemeBot.dao.UserDAO;
import babushkaMemeBot.models.User;

public class TelegramBotController extends TelegramLongPollingBot {
	
	@Autowired
	UserDAO userRepository;
	
	private String botToken;

	private String botUsername;

	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			SendMessage message = new SendMessage() 
					.setChatId(update.getMessage().getChatId()).setText(update.getMessage().getText());
			String name = update.getMessage().getChat().getUserName();
			Long id = update.getMessage().getChat().getId();
			userRepository.saveUser(new User(id,name));
			try {
				execute(message); 
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
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
