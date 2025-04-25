


package com.formacionbdi.microservicios.app.usuarios.services;
import com.formacionbdi.microservicios.app.usuarios.models.entity.Paciente;
import com.formacionbdi.microservicios.app.usuarios.models.repository.PacienteRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



public class PacienteServiceImpl implements PacienteService {
	
	@Autowired
	private PacienteRepository repository;
	@Override
	@Transactional(readOnly = true)
	public Iterable<Paciente> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Paciente> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Paciente save(Paciente paciente) {
		return repository.save(paciente);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

}
