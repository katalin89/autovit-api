package ro.mycode.autovitapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.autovitapi.model.Masina;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MasinaRepo extends JpaRepository<Masina, Long> {


    @Query("select  distinct p.marca from Masina  p")
    List<String> getAllMarci();

    @Query("select m  from  Masina m where  m.marca = ?1")
//?1 este primul parametru de la List<masina>,daca ar avea 2 parametri am putea scrie si doi

    List<Masina> getAllCarByMarca(String marca);

    @Transactional
    @Modifying
    @Query("delete from  Masina m where m.marca like ?1")
    void deleteCarByMarca(String marca);

    @Transactional
    @Modifying
    @Query("delete from  Masina m where m.model like ?1")
    void deleteCarByModel(String model);

    @Transactional
    @Modifying
    @Query("delete from Masina  m where m.id = ?1")//la string in loc de egal este like
    void deleteById(Long id);


//la find merge si fara query,scriem findBy si se completeaza singur
    Masina findMasinaByModel(String model);

    Masina findMasinaById(Long id);



    @Transactional
    @Modifying
    //ordoneaza in ordine crescatoare
    @Query("select distinct m from Masina m order by m.pret")
    List<Masina> sortByPrice();

    @Transactional
    @Modifying
    @Query("select distinct m from Masina m order by m.culoare")
    List<Masina>sortByColor();

    @Transactional
    @Modifying
    @Query("select distinct m from Masina m order by m.marca")
    List<Masina>sortByMarca();
//ordoneaza in ordine crescatoare


    @Transactional
    @Modifying
    @Query("select distinct m from Masina m order by  m.model")
    List<Masina>sortByModel();

    @Transactional
    @Modifying
    @Query("select  distinct m from Masina m order by m.nrDeLocuri")
    List<Masina>sortByNrDeLoc();

    ///metoda  daca este unic  dupa marca si model
    @Transactional
    @Modifying
    @Query("select  m from Masina m where m.marca = ?1 and m.model = ?2 ")
    List<Masina> findCarWith(String marca ,String model);




}








