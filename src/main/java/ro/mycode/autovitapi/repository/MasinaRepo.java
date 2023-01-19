package ro.mycode.autovitapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.autovitapi.model.Masina;

import java.util.List;

@Repository
public interface MasinaRepo extends JpaRepository<Masina, Long> {


    @Query("select  distinct p.marca from Masina  p")
    List<String> getAllMarci();

    @Query("select m  from  Masina m where  m.marca = ?1")
//?1 este primul parametru de la List<masina>,daca ar avea 2 parametri am putea scrie si doi

    List<Masina> getAllMasinaByMarca(String marca);
}

//ordoneaza in ordine crescatoare



//select * from autovit_db.masini order by pret asc;
