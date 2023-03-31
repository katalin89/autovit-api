package ro.mycode.autovitapi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.autovitapi.dtos.MasinaDTO;
import ro.mycode.autovitapi.model.Masina;
import ro.mycode.autovitapi.service.MasinaService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/masina")
@CrossOrigin
public class MasinaResource {

    private MasinaService masinaService;

    public MasinaResource(MasinaService masinaService) {
        this.masinaService = masinaService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Masina>> getAllCars() {
        List<Masina> allMasini = masinaService.getAllMasini();
        return new ResponseEntity<>(allMasini, HttpStatus.OK);
    }

    @DeleteMapping("/deleteByModel/{model}")
    ResponseEntity deleteByModel(@PathVariable String model){
        this.masinaService.deleteMasinaByModel(model);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteById(@PathVariable Long id){
        this.masinaService.deleteById(id);
        //return id;
        return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @PostMapping("/add")
    public ResponseEntity addCar( @RequestBody Masina masina){
        masinaService.addCar(masina);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/update")
     public ResponseEntity update(@Valid @RequestBody MasinaDTO masina, String model){
        this.masinaService.update(masina,model);
        return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/sortByColor")
    public List<Masina>sortByColor(){
        return masinaService.sortByColor();
    }
    @GetMapping("/sortByMarca")

    public List<Masina>sortByMarca(){
        return masinaService.sortByMarca();
    }

    @GetMapping("/sortByModel")
    public List<Masina>sortByModel(){
        return  masinaService.sortByModel();
    }

    @GetMapping("/sortByNrDeLoc")
    public List<Masina>sortByNrDeLoc(){
        return  masinaService.sortByNrDeLoc();
    }

    @GetMapping("/sortByPrice")
    public List<Masina>sortByPrice(){
        return masinaService.sortByPrice();
    }

}
