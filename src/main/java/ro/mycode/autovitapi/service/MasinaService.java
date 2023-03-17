package ro.mycode.autovitapi.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ro.mycode.autovitapi.dtos.MasinaDTO;
import ro.mycode.autovitapi.exceptii.ExceptieExistingCar;
import ro.mycode.autovitapi.exceptii.ExceptieMasinaDBEmpty;
import ro.mycode.autovitapi.exceptii.MasinaNotFoundException;
import ro.mycode.autovitapi.model.Masina;
import ro.mycode.autovitapi.repository.MasinaRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MasinaService {

    private MasinaRepo masinaRepo;

    public MasinaService(MasinaRepo masinaRepo) {
        this.masinaRepo = masinaRepo;
    }

    public List<Masina> getAllMasini() throws ExceptieMasinaDBEmpty {
        List<Masina> masini = masinaRepo.findAll();
        if (masini.size() > 0) {
            return masini;
        }
        throw new ExceptieMasinaDBEmpty();
    }

    public void deleteMasinaByModel(String model) throws MasinaNotFoundException {
        Masina byModel = masinaRepo.findMasinaByModel(model);
        if (byModel != null) {
            masinaRepo.deleteMasinaByModel(model);
        } else {
            throw new MasinaNotFoundException();
        }

    }

    @Transactional
    @Modifying
    public  void addCar(Masina masina) throws MasinaNotFoundException{

        List<Masina> carWith = masinaRepo.findCarWith(masina.getMarca(), masina.getModel());


        if(carWith.size()>0){

            throw  new ExceptieExistingCar();
        }

        this.masinaRepo.saveAndFlush(masina);
    }

    @Transactional
    @Modifying
    //public void update (@RequestBody MasinaDTO masina)throws MasinaNotFoundException{
    public void update(@RequestBody MasinaDTO masina,String model) throws MasinaNotFoundException {
        Masina m = masinaRepo.findMasinaByModel(masina.getModel());


        if (m == null) {
            throw new MasinaNotFoundException();
        }
        if (masina.getMarca().equals("") == false) {
            m.setMarca(masina.getMarca());
        }

        if (masina.getCuloare().equals("") == false) {
            m.setCuloare(masina.getCuloare());
        }

        if (masina.getNrDeLocuri() != 0) {
            m.setNrDeLocuri(masina.getNrDeLocuri());
        }
        if (masina.getPret() != 0) {
            m.setPret(masina.getPret());
        }


    }



}
