package babushkaMemeBot.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import babushkaMemeBot.dao.MemeTemplateDAO;
import babushkaMemeBot.models.MemeTemplate;

public class MemeTemplateDAOImpl implements MemeTemplateDAO {

	@Autowired
	SessionFactory sessionFactory;

	public List<MemeTemplate> getMemeTemplates() {

		@SuppressWarnings("unchecked")
		TypedQuery<MemeTemplate> typedQuery = sessionFactory.getCurrentSession().createQuery("From MemeTemplate");
		return typedQuery.getResultList();
	}

	public MemeTemplate getMemeTemplate(Long id) {

		@SuppressWarnings("unchecked")
		TypedQuery<MemeTemplate> typedQuery = sessionFactory.getCurrentSession()
				.createQuery("From MemeTemplate m where m.id =:id");
		typedQuery.setParameter("id", id);

		List<MemeTemplate> resultList = typedQuery.getResultList();

		if (!resultList.isEmpty()) {
			return resultList.get(0);
		}

		return null;
	}

	public void saveMemeTemplate(MemeTemplate memeTemplate) {
		sessionFactory.getCurrentSession().save(memeTemplate);

	}

	public void deleteMemeTemplate(MemeTemplate memeTemplate) {
		sessionFactory.getCurrentSession().delete(memeTemplate);

	}

	public void deleteMemeTemplate(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<MemeTemplate> typedQuery = sessionFactory.getCurrentSession()
				.createQuery("Delete From MemeTemplate m where m.id =:id");
		typedQuery.setParameter("id", id);
		typedQuery.executeUpdate();

	}

	public void deleteMemeTemplates() {
		@SuppressWarnings("unchecked")
		TypedQuery<MemeTemplate> typedQuery = sessionFactory.getCurrentSession()
				.createQuery("Delete From MemeTemplate");
		typedQuery.executeUpdate();
	}

	public void saveMemeTemplates(List<MemeTemplate> listOfMemeTemplates) {
		for (MemeTemplate memeTemplate : listOfMemeTemplates) {
			saveMemeTemplate(memeTemplate);
		}

	}

}
