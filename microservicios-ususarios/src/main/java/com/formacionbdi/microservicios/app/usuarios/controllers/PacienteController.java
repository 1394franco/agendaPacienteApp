

package com.formacionbdi.microservicios.app.usuarios.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Paciente;
import com.formacionbdi.microservicios.app.usuarios.services.PacienteService;



// CONTROLADOR CRUD 

@RestController
public class PacienteController {
	
	
	@Autowired
	private PacienteService service;
	
	// Se pasa el cuerpo de la respuesta una lista de Entity (Por debajo va un Json)
	@GetMapping
	public ResponseEntity<?>listar(){
		return ResponseEntity.ok().body(service);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		Optional<Paciente> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
		
	}
	
	@PostMapping
	public  ResponseEntity<?> crear(@RequestBody Paciente paciente){
		
		Paciente pacienteDb = service.save(paciente);
		return ResponseEntity.status(HttpStatus.CREATED).body(pacienteDb);
	}
	
	
	@PutMapping  ("/{id}")
	public ResponseEntity<?> editar(@RequestBody Paciente paciente,  @PathVariable Long id){    
		Optional<Paciente> o = service.findById(id);
		
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Paciente pacienteDb = o.get();
		pacienteDb.setNombre(paciente.getNombre());
		pacienteDb.setApellido(paciente.getApellido());
		pacienteDb.setEmail(paciente.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(pacienteDb));
		
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();	
		
	
	}
	
	
}
