package ee.icd0004.project.exception;

public class UnsupportedFileTypeException extends  RuntimeException{
    public UnsupportedFileTypeException(String errorMessage){
        super(errorMessage);
    }
}
