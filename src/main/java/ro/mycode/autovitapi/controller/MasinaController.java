package ro.mycode.autovitapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.autovitapi.model.Masina;
import ro.mycode.autovitapi.repository.MasinaRepo;

import java.util.List;

@RestController
@CrossOrigin
public class MasinaController {
    private MasinaRepo masinaRepo;

    public MasinaController(MasinaRepo masinaRepo) {
        this.masinaRepo = masinaRepo;
    }

    @GetMapping("api/v1/masini")
    public List<Masina> getAllCars() {
        System.out.println("aici");

        return masinaRepo.findAll();
    }
    //endpont care aduce marcile

    @GetMapping("api/v1/masini/marci")
    public List<String> getAllMarci() {
        return masinaRepo.getAllMarci();
    }


    //enpoint care sa returneze toate obiectele care au marca respectiva,primeste ca parametru marca


    //cad apasam pe toyota sa apara numai randul toyota
    @GetMapping("api/v1/masini/{marca}")
    public List<Masina> getAllMasiniByMarca(@PathVariable String marca) {//daca vom alege alt marca punem @PathVariable
        return masinaRepo.getAllMasinaByMarca(marca);
    }

    @PostMapping("api/v1/add")// asa vom face add in baza de date
    public  Masina  addCar(@RequestBody Masina masina){

        this.masinaRepo.save(masina);


        return  masina;
    }


}


