package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ICitaMedicaService {
	public void agendar(Integer noCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente);

	public void actualizar(Integer noCita, String diagnostico, String receta, LocalDateTime fechaProximaCita);

}
