package babushkaMemeBot.keyboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import babushkaMemeBot.models.MemeTemplate;

@Component
public class Keyboard {

	private ReplyKeyboardMarkup keyboard;

	private List<KeyboardRow> listOfKeyboardRows;

	private Map<String, String> nameUrlMap;

	public Keyboard() {
		this.keyboard = new ReplyKeyboardMarkup();
		this.nameUrlMap = new HashMap<>();
		this.listOfKeyboardRows = new ArrayList<>();
	}

	public void refreshKeyboard(List<MemeTemplate> listOfTemplates) {
		if (listOfTemplates.size() > 0) {
			this.keyboard = new ReplyKeyboardMarkup();
			this.nameUrlMap = new HashMap<>();
		}

		for (MemeTemplate memeTemplate : listOfTemplates) {
			String name = memeTemplate.getName();
			String url = memeTemplate.getUrl();
			KeyboardRow row = new KeyboardRow();

			this.nameUrlMap.put(name, url);
			row.add(name);

			listOfKeyboardRows.add(row);
		}

		keyboard.setKeyboard(listOfKeyboardRows);

	}

	public String getUrlForName(String name) {
		return nameUrlMap.get(name);
	}

	public ReplyKeyboardMarkup getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(ReplyKeyboardMarkup keyboard) {
		this.keyboard = keyboard;
	}

	public boolean hasName(String name) {
		return this.nameUrlMap.containsKey(name);
	}

}
