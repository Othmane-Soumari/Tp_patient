package org.sid.springmvc;

import java.util.Date;

import org.sid.springmvc.dao.PatientRepository;
import org.sid.springmvc.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmvcApplication implements CommandLineRunner {
	
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null, "Othmane", new Date(), false));
		patientRepository.save(new Patient(null, "Reda", new Date(), false));
		patientRepository.save(new Patient(null, "Marwan", new Date(), true));
		
		patientRepository.findAll().forEach(p -> {
			System.out.println(p.getName());
		});
	}

}
