package ro.mycode.autovitapi.exceptii;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.autovitapi.constants.Constants.CAR_DUPLICATION;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptieExistingCar extends RuntimeException {
    public ExceptieExistingCar(){
        super(CAR_DUPLICATION);
    }
}


