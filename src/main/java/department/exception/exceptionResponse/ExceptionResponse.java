package department.exception.exceptionResponse;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
    public ExceptionResponse() {
    }

    public ExceptionResponse(HttpStatus httpStatus, String className, String message) {
        this.httpStatus = httpStatus;
        this.className = className;
        this.message = message;
    }

    private HttpStatus httpStatus;

    private String className;

    private String message;
}
