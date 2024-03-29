package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.CitaMedica;
import com.uce.edu.repository.modelo.Doctor;
import com.uce.edu.repository.modelo.Paciente;
import com.uce.edu.service.ICitaMedicaService;
import com.uce.edu.service.IDoctorService;
import com.uce.edu.service.IPacienteService;

@SpringBootApplication
public class EfinalPa2P4CoApplication implements CommandLineRunner {

	// autowired del service
	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private IPacienteService iPacienteService;

	@Autowired
	private ICitaMedicaService citaMedicaService;

	public static void main(String[] args) {
		SpringApplication.run(EfinalPa2P4CoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// 1 y 2
		Doctor doctor1 = new Doctor();
		doctor1.setNombre("Carlos");
		doctor1.setApellido("Caceres");
		doctor1.setCedula("1723");
		doctor1.setCodigoSenecyt("lld");
		doctor1.setFechaNacimiento(LocalDateTime.now());
		doctor1.setGenero("M");
		doctor1.setNumeroConsultorio("2641");
		this.doctorService.guardar(doctor1);

		Paciente paciente1 = new Paciente();
		paciente1.setNombre("Andres");
		paciente1.setApellido("Olivares");
		paciente1.setCedula("1750");
		paciente1.setCodigoSeguro("llp");
		paciente1.setEstatura(1.65f);
		paciente1.setFechaNacimiento(LocalDateTime.now());
		paciente1.setGenero("M");
		paciente1.setPeso(15.3f);
		this.iPacienteService.guardar(paciente1);

		// 3
		this.citaMedicaService.agendar(1, LocalDateTime.of(2024, 02, 13, 12, 30), new BigDecimal(20), "H Sur", "1723",
				"1750");

		// 4
		this.citaMedicaService.actualizar(1, "Diabetes", "Mejorar la calidad de la comida",
				LocalDateTime.of(2024, 03, 01, 13, 30));

	}

}
