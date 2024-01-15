package com.uce.edu.service;

import com.uce.edu.repository.modelo.Paciente;

public interface IPacienteService {

	public void guardar(Paciente paciente);

	public void actualizar(Paciente paciente);

	public Paciente buscarPorCedula(String cedula);
}
