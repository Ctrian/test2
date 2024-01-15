package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DoctorRepositoryImpl implements IDoctorRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Doctor seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	public void insertar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(doctor);
	}

	@Override
	public void actualizar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(doctor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Doctor doctor = this.seleccionar(id);
		this.entityManager.remove(doctor);
	}

	@Override
	public Doctor seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT d FROM Doctor d WHERE d.cedula = : variable");
		myQuery.setParameter("variable", cedula);
		return (Doctor)myQuery.getSingleResult();
	}

}