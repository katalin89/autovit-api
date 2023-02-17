package ro.mycode.autovitapi;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.autovitapi.model.Masina;
import ro.mycode.autovitapi.repository.MasinaRepo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class AutovitApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(AutovitApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(MasinaRepo masinaRepo) {
		return args -> {

			//masinaRepo.deleteMasinaByMarca("Dodge");

			masinaRepo.getAllMarci().forEach((e)->{
				System.out.println(e);
			});


//				for(int i=0;i<100;i++){
//
//
//
//
//				masinaRepo.getAllMarci().forEach((e)->{
//
//					System.out.println(e);
//				});

//-----------------
//			List<Masina> listMasini = masinaRepo.getAllMasinaByMarca("Toyota");
//			Iterator iterator = listMasini.iterator();
//			while (iterator.hasNext()) {
//				System.out.println(iterator.next());
//			}

		};

	}
}
