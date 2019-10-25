package exceptions;

public class FileStructureValidationException extends Exception{

    public FileStructureValidationException(String errorMessage){
        super(errorMessage);
    }
}
