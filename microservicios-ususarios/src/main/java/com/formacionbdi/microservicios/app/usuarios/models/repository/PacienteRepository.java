package com.formacionbdi.microservicios.app.usuarios.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, Long> {
	
	

}
