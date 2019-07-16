package babushkaMemeBot.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import babushkaMemeBot.dao.MemeTemplateDAO;
import babushkaMemeBot.models.MemeTemplate;

@Service
@PropertySource("classpath:schedule.properties")
public class ScheduledService {

	@Autowired
	MemeTemplateDAO memeTemplateRepository;

	@Autowired
	ObjectMapper jsonMapper;
	
	@Scheduled(cron = "0 4 */2 * * *")
	@Transactional
	public void refreshMemeTemplates() throws MalformedURLException, IOException {
		JsonNode returnNode = jsonMapper.readTree(new URL("https://api.imgflip.com/get_memes"));
		returnNode = returnNode.at("/data/memes");

		ArrayList<MemeTemplate> refreshedMemeTemplateList = new ArrayList<MemeTemplate>();

		for (final JsonNode jsonObject : returnNode) {
			refreshedMemeTemplateList.add(jsonMapper.treeToValue(jsonObject, MemeTemplate.class));
		}

		if (refreshedMemeTemplateList.size() > 0) {
			memeTemplateRepository.deleteMemeTemplates();
			memeTemplateRepository.saveMemeTemplates(refreshedMemeTemplateList);
		}
	}

	public MemeTemplateDAO getMemeTemplateRepository() {
		return memeTemplateRepository;
	}

	public void setMemeTemplateRepository(MemeTemplateDAO memeTemplateRepository) {
		this.memeTemplateRepository = memeTemplateRepository;
	}

}
