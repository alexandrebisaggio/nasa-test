
package bisaggio.nasa.rest.handler;

import bisaggio.nasa.service.exception.InvalidStepException;
import bisaggio.nasa.validator.exception.InvalidPositionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author bisaggio
 */
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    MessageSource messageSource;

    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidPositionException.class)
    public ResponseEntity<?> handledPositionInvalidException(InvalidPositionException ex, WebRequest request) {

        String message = messageSource.getMessage("mensage.position.invalid", null, LocaleContextHolder.getLocale());

        return handleExceptionInternal(ex, message, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, request);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidStepException.class)
    public ResponseEntity<?> handledCommandDoesNotValidException(InvalidStepException ex, WebRequest request) {

        String message = messageSource.getMessage("mensage.command.invalid", null, LocaleContextHolder.getLocale());

        return handleExceptionInternal(ex, message, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, request);
    }

}
