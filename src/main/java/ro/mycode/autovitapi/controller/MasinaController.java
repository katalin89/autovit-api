package ro.mycode.autovitapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.autovitapi.dtos.MasinaDTO;
import ro.mycode.autovitapi.model.Masina;
import ro.mycode.autovitapi.repository.MasinaRepo;

import javax.validation.Valid;
import java.security.PublicKey;
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
    public Masina addCar(@Valid @RequestBody Masina masina) {

        this.masinaRepo.save(masina);


        return masina;
    }

    @DeleteMapping("api/v1/deleteByMarca/{marca}")
    public String deleteCar(@PathVariable String marca) {

        this.masinaRepo.deleteMasinaByMarca(marca);

        return marca;
    }

    @DeleteMapping("api/v1/delete/{id}")
    public long deleteCarById(@PathVariable long id) {
        this.masinaRepo.deleteById(id);
        return id;
    }

    @PutMapping("api/v1/update")// asa vom face add in baza de date
    public Masina updateCar(@Valid @RequestBody MasinaDTO masina) {
        Masina m = masinaRepo.findByModel(masina.getModel());

        if (masina.getPret() != 0) {
            m.setPret(masina.getPret());
        }else System.out.println("Nu are valoare");
        if (masina.getCuloare().equals("") == false) {
            m.setCuloare(masina.getCuloare());
        }else System.out.println("Nu are valoare");
        System.out.println("nrdelocuri:" + masina.getNrDeLocuri());
        if (masina.getNrDeLocuri() != 0) {
            m.setNrDeLocuri(masina.getNrDeLocuri());
        }else System.out.println("Nu are valoare");
        if (masina.getMarca().equals("") == false) {

            m.setMarca(masina.getMarca());
        }else System.out.println("Nu are valoare");
        masinaRepo.save(m);
        return m;
    }

    //find car by id

    @GetMapping("api/v1/get/car/{id}")
    public Masina getCarById(@PathVariable int id){

        return  masinaRepo.findById(Long.valueOf(id)).get();
    }

    @GetMapping("api/v1/sortByPrice")
    public List<Masina> sortByPrice(){
        return  masinaRepo.sortByPrice();

    }

    @GetMapping("api/v1/sortByColor")
    public List<Masina>sortByColor(){
        return masinaRepo.sortByColor();
    }

    @GetMapping("api/v1/sortByMarca")
    public  List<Masina>sortByMarca(){
        return  masinaRepo.sortByMarca();
    }


    @GetMapping("api/v1/sortByModel")
    public List<Masina>sortByModel(){
        return  masinaRepo.sortByModel();

    }

    @GetMapping("api/v1/sortByNrDeLocuri")
    public List<Masina>sortByNrDeLocuri(){
        return  masinaRepo.sortByModel();
    }
}

//sort by price







