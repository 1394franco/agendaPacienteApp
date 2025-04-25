


package com.formacionbdi.microservicios.app.usuarios.services;

import java.util.Optional;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Paciente;


// INTERFAZ PACIENTE SERVICE CON CRUD BASICO

public interface PacienteService {

	public Iterable<Paciente> findAll();
	
	public Optional<Paciente> findById(Long id);
	
	public Paciente save (Paciente paciente); 
	
	public void deleteById(Long id);
	
	
}
