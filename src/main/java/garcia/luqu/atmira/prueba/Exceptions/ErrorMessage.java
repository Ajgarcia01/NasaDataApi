package garcia.luqu.atmira.prueba.Exceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ErrorMessage {
    private int statusCode;
    private String timestamp;
    private String message;
    private String path;

    public ErrorMessage(int statusCode, String timestamp, String message, String path) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.path = path;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getTimestamp() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format( new Date());
        return dateString;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}