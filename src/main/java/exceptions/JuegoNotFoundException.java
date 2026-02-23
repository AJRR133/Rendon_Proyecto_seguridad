package exceptions;

public class JuegoNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5030665213865363481L;

    public JuegoNotFoundException() {
        super();
    }

    public JuegoNotFoundException(String message) {
        super(message);
    }

    public JuegoNotFoundException(long id) {
        super("Juego not found: " + id);
    }
}
