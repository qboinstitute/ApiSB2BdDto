package com.qbo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qbo.exception.ResourceNotFoundException;
import com.qbo.model.Cliente;
import com.qbo.service.ClienteService;


//@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping(path = "api/v1/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService servicio;
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/dni/{dni}")
	public ResponseEntity<Cliente> buscarClientePorDni(@PathVariable("dni") 
	String dni){
		Cliente cliente = servicio.buscarClientePorDni(dni)
				.orElseThrow(()-> 
				new ResourceNotFoundException
				("Cliente con el DNI: " + dni+ " NO EXISTE."));
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<?> buscarClientesPorNombre(
			@RequestParam String nombre, 
			Pageable pageable
			){
		Page<Cliente> clientes = servicio.buscarClientePorNombre(nombre, pageable);
		if(clientes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}
	
	

}
