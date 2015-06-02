package exception;

/**
 * Created by ${Dotin} on ${4/25/2015}.
 */
public class WrongDataException extends  Exception {
    private String message;
    public WrongDataException(String message)
    {
        this.message=message;
    }
    public String getMessage()
    {
        return  message;
    }
}
