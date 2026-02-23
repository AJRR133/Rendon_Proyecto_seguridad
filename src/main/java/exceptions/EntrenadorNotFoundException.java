package exceptions;

public class EntrenadorNotFoundException  extends RuntimeException  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5030665213865363481L;

    public EntrenadorNotFoundException() {
        super();
    }
      

    public EntrenadorNotFoundException(String message) {
        super(message);
    }
 
    public EntrenadorNotFoundException(long id) {
        super("Entrenador not found: " + id);
    }
}

