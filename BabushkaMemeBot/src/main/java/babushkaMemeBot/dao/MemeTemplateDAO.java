package babushkaMemeBot.dao;

import java.util.List;

import babushkaMemeBot.models.MemeTemplate;

public interface MemeTemplateDAO {

	public List<MemeTemplate> getMemeTemplates();

	public MemeTemplate getMemeTemplate(Long id);

	public void saveMemeTemplate(MemeTemplate memeTemplate);
	
	public void saveMemeTemplates(List<MemeTemplate> listOfMemeTemplates);

	public void deleteMemeTemplate(MemeTemplate memeTemplate);

	public void deleteMemeTemplate(Long id);

	public void deleteMemeTemplates();
}
