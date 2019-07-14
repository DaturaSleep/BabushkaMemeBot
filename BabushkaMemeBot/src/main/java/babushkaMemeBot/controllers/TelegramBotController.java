package babushkaMemeBot.controllers;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBotController extends TelegramLongPollingBot {
	private String botToken;

	private String botUsername;

	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
					.setChatId(update.getMessage().getChatId()).setText(update.getMessage().getText());
			System.out.println(update.getMessage().getChat().getUserName());

			try {
				execute(message); // Call method to send the message
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
