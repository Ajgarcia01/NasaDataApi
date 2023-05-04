package garcia.luqu.atmira.prueba.Exceptions;

public class ResourceNullPointException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNullPointException(String msg) {
        super(msg);
    }
}