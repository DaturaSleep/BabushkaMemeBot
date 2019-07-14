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
	
	@Column(name = "first_name",nullable = true)
	private String firstName;
	
	@Column(name = "second", nullable = true)
	private String lastName;
	
	public User() {
		
	}

	public User(Long id, String username,String firstName,String lastName) {
		this();
		this.setId(id);
		this.setUsername(username);
		this.setFirstName(firstName);
		this.setLastName(lastName);
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

	protected String getFirstName() {
		return firstName;
	}

	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	protected String getLastName() {
		return lastName;
	}

	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
