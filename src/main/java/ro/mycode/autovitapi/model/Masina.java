package ro.mycode.autovitapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.*;

@Data
@Entity//o sa creeze o tabla in baze de date
@Table(name="masini")
@AllArgsConstructor
@NoArgsConstructor
public class Masina  implements Comparable<Masina>{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String marca;

    private String model;
    private int nrDeLocuri;
    private int pret;
    private String culoare;

    public Masina(String marca, int nrDeLocuri, int pret, String culoare) {
        this.marca = marca;
        this.nrDeLocuri = nrDeLocuri;
        this.pret = pret;
        this.culoare = culoare;
    }

    @Override
    public String toString(){
        String text="";
        text+=marca+","+nrDeLocuri+","+pret+","+culoare;
        return  text;
    }

    @Override
    public int compareTo(Masina o) {
        return 0;
    }

   public int compare(Object o){
        Masina masina=(Masina)o;

        if(this.pret> masina.pret){
            return  1;
        }else if(this.pret<masina.pret){
            return  0;

        }
        return -1;


   }

}
