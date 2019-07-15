package babushkaMemeBot.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import babushkaMemeBot.dao.MemeTemplateDAO;
import babushkaMemeBot.models.MemeTemplate;

@Service
public class ScheduledService {

	@Autowired
	MemeTemplateDAO memeTemplateRepository;

	@Autowired
	ObjectMapper jsonMapper;

	@Transactional
	public void refreshMemeTemplates() throws MalformedURLException, IOException {
		JsonNode returnNode = jsonMapper.readTree(new URL("https://api.imgflip.com/get_memes"));
		returnNode = returnNode.at("/data/memes");

		ArrayList<MemeTemplate> refreshedMemeTemplateList = new ArrayList<MemeTemplate>();

		for (final JsonNode jsonObject : returnNode) {
			refreshedMemeTemplateList.add(jsonMapper.treeToValue(jsonObject, MemeTemplate.class));
		}
		System.out.println(refreshedMemeTemplateList.size());
	}

	@PostConstruct
	public void test() {
		try {
			refreshMemeTemplates();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
