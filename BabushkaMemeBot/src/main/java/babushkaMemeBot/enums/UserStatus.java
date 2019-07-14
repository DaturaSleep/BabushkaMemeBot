package babushkaMemeBot.enums;

public enum UserStatus {
	ACTIVE("Active"), STOPPED("Stopped");

	public String value;

	UserStatus(String value) {
		this.value = value;
	}
}
