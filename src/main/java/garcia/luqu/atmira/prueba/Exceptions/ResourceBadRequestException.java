package garcia.luqu.atmira.prueba.Exceptions;

public class ResourceBadRequestException extends RuntimeException{


    private static final long serialVersionUID = 1L;

    public ResourceBadRequestException(String msg) {
        super(msg);
    }
}

