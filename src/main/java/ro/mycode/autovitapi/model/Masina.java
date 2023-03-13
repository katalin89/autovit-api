package ro.mycode.autovitapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Masina")//o sa creeze o tabla in baze de date
@Table(name = "masini")

public class Masina implements Comparable<Masina> {

    @Id
    @SequenceGenerator(name = "masina_sequence", sequenceName = "masina_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "masina_sequence")

    private Long id;

    @Column(name="marca",nullable = false)
    @Size(min=4,message="Marca trebuie sa fie minim 4 caractere")
    private String marca;

    @Column(name="model",nullable = false)
    @Size(max=20,message = "Nu poate fi mai lung decat 20 de caractere")
    private String model;

    @Column(name="nrDeLocuri",nullable = false)
    @Min(value=2,message = "O masina trebuie sa aiba min 2 locuri")
    private  int nrDeLocuri;


    @Column(name="pret",nullable = false)
    @Max(value = 100000,message="Pretul nu poate fi peste 100 000 euro")
    private int pret;

    @Column(name="culoare",nullable = false)
    @Size(min=4,message="Culoare trebuie sa fie minim 4 caractere")
    private  String culoare;

    @Override
    public int compareTo(Masina m) {
        if(this.model.compareTo(m.model)>0){
            return 1;
        }
        if(this.model.compareTo(m.model)<0){
            return -1;
        }else

        return 0;
    }
    @Override
    public boolean equals(Object o){
        Masina masina=(Masina)o ;
        return  this.model.equals(masina.model);

    }

}

