package ro.mycode.autovitapi.exceptii;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.autovitapi.constants.Constants.EMPTY_DATABASE_EXCEPTION;

@ResponseStatus(HttpStatus.BAD_REQUEST)//sa nu arunce eroare de 404,va arunca Bad_request
public class ExceptieMasinaDBEmpty extends  RuntimeException{
    public ExceptieMasinaDBEmpty(){
        super(EMPTY_DATABASE_EXCEPTION);
    }
}
