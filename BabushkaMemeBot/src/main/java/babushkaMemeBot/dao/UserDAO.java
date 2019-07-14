package babushkaMemeBot.dao;

import java.util.List;

import babushkaMemeBot.models.User;

public interface UserDAO {

	public List<User> getUsers();

	public User getUserById(Long id);

	public void saveUser(User user);

	public void deleteUser(User user);

	public void deleteUserById(Long id);

}
