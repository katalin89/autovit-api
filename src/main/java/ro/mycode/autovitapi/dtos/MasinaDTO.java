package ro.mycode.autovitapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor

// clasa asta ne permite sa schimbam datele petru mai putine atribute decat sunt(ex numai unu sau doi din 5 atribute
public class MasinaDTO {
    private String marca="";
    private String model="";
    private int nrDeLocuri=0;
    private int pret=0;
    private String culoare="";


}
