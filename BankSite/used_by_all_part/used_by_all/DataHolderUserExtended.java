package used_by_all;


public class DataHolderUserExtended extends DataHolder {
	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void set(String message, User user, boolean isDone) {
		this.message = message;
		this.isDone = isDone;
		this.user = user;
	}
}
