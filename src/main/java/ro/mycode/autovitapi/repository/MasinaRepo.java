package ro.mycode.autovitapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.autovitapi.model.Masina;

import java.util.List;

@Repository
public interface MasinaRepo extends JpaRepository<Masina,Long> {


    @Query("select  distinct p.marca from Masina  p")
    List<String> getAllMarci();
}
