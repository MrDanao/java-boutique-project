package donnees;


public class ExceptionSave extends Exception {

	private String message;
	
	public ExceptionSave (String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
