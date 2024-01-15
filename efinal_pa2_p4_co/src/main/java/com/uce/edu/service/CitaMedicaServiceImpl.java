package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ICitaMedicaRepository;
import com.uce.edu.repository.IDoctorRepository;
import com.uce.edu.repository.IPacienteRepository;
import com.uce.edu.repository.modelo.CitaMedica;
import com.uce.edu.repository.modelo.Doctor;
import com.uce.edu.repository.modelo.Paciente;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService {

	@Autowired
	private IPacienteRepository iPacienteRepository;

	@Autowired
	private IDoctorRepository doctorRepository;

	@Autowired
	private ICitaMedicaRepository citaMedicaRepository;

	@Override
	public void agendar(Integer noCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		// TODO Auto-generated method stub
		Doctor doctor1 = this.doctorRepository.seleccionarPorCedula(cedulaDoctor);
		Paciente paciente1 = this.iPacienteRepository.seleccionarPorCedula(cedulaPaciente);

		CitaMedica citaMedica = new CitaMedica();
		citaMedica.setNumeroCita(noCita);
		citaMedica.setFechaCita(fechaCita);
		citaMedica.setValorCita(valorCita);
		citaMedica.setLugarCita(lugarCita);
		citaMedica.setDoctor(doctor1);
		citaMedica.setPaciente(paciente1);
		this.citaMedicaRepository.insertar(citaMedica);

	}

	@Override
	public void actualizar(Integer noCita, String diagnostico, String receta, LocalDateTime fechaProximaCita) {
		// TODO Auto-generated method stub
		CitaMedica citaMedica1 = this.citaMedicaRepository.seleccionarPorNoCita(noCita);
		
		citaMedica1.setNumeroCita(noCita);
		citaMedica1.setDiagnostico(diagnostico);
		citaMedica1.setReceta(receta);
		citaMedica1.setFechaProximaCita(fechaProximaCita);
		
		this.citaMedicaRepository.actualizar(citaMedica1);
	}

}
