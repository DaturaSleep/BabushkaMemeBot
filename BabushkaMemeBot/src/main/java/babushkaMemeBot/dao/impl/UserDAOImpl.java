package babushkaMemeBot.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import babushkaMemeBot.dao.UserDAO;
import babushkaMemeBot.models.User;

public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	public List<User> getUsers() {
		@SuppressWarnings("unchecked")
		TypedQuery<User> typedQuery = sessionFactory.getCurrentSession().createQuery("From User");
		return typedQuery.getResultList();
	}

	public User getUserById(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<User> typedQuery = sessionFactory.getCurrentSession().createQuery("From User u where u.id =:id");
		typedQuery.setParameter("id", id);

		return typedQuery.getSingleResult();
	}

	public void saveUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);

	}

	public void deleteUserById(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<User> typedQuery = sessionFactory.getCurrentSession().createQuery("Delete From User u where u.id =:id");
		typedQuery.setParameter("id", id);
		typedQuery.executeUpdate();
	}

}
