package ro.mycode.autovitapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/api/v1/masini")
    public List<Masina>getAllCars(){
        return masinaRepo.findAll();
    }
    //endpont care aduce marcile

    @GetMapping("api/v1/masini/marci")
    public List<String>getAllMarci(){
        return masinaRepo.getAllMarci();
    }
}
