package babushkaMemeBot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "username", nullable = true)
	private String username;

	public User() {

	}

	public User(Long id, String username) {
		this.setId(id);
		this.setUsername(username);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
