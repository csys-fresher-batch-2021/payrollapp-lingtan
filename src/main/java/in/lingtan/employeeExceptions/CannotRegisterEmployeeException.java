package in.lingtan.employeeExceptions;

public class CannotRegisterEmployeeException extends Exception {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CannotRegisterEmployeeException(String message) {
        super(message);
    }
}
	
