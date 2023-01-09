package ro.mycode.autovitapi;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.autovitapi.model.Masina;
import ro.mycode.autovitapi.repository.MasinaRepo;

@SpringBootApplication
public class AutovitApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(AutovitApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(MasinaRepo masinaRepo){
			return args -> {



//				for(int i=0;i<100;i++){
//
//
//
//
//				masinaRepo.getAllMarci().forEach((e)->{
//
//					System.out.println(e);
//				});

			};
	}

}
