package exceptions;

public class EquipoNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5030665213865363481L;

    public EquipoNotFoundException() {
        super();
    }

    public EquipoNotFoundException(String message) {
        super(message);
    }

    public EquipoNotFoundException(long id) {
        super("Equipo not found: " + id);
    }
}
