package used_by_all;


public class DataHolder {
	protected String message;
	protected boolean isDone;

	public void set(String message, boolean isDone) {
		this.message = message;
		this.isDone = isDone;
	}

	public String getMessage() {
		return message;
	}

	public boolean getIsDone() {
		return isDone;
	}
}
