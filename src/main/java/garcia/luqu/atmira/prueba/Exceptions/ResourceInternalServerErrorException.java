package garcia.luqu.atmira.prueba.Exceptions;

public class ResourceInternalServerErrorException extends RuntimeException{


    private static final long serialVersionUID = 1L;

    public ResourceInternalServerErrorException(String msg) {
        super(msg);
    }
}

