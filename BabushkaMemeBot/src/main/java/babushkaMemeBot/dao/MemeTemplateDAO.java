package babushkaMemeBot.dao;

import java.util.List;

import babushkaMemeBot.models.MemeTemplate;

public interface MemeTemplateDAO {

	public List<MemeTemplate> getMemeTemplates();

	public MemeTemplate getMemeTemplate(Long id);

	public void saveMemeTemplate();

	public void deleteMemeTemplate(MemeTemplate memeTemplate);

	public void deleteMemeTemplate(Long id);

	public void deleteMemeTemplates();
}
