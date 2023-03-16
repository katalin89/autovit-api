package ro.mycode.autovitapi.exceptii;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.autovitapi.constants.Constants.MASINA_NOT_FOUND_EXCEPTION;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MasinaNotFoundException extends RuntimeException {

    public MasinaNotFoundException(){
        super(MASINA_NOT_FOUND_EXCEPTION);
    }
}
