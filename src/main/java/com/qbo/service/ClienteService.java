package com.qbo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.qbo.model.Cliente;
import com.qbo.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository respository;
	
	public Optional<Cliente> buscarClientePorDni(String dniCliente){
		Optional<Cliente> cliente 
		= respository.buscarClientePorDniNativeQuery(dniCliente);
		if(cliente.isEmpty()) {
			return Optional.empty();
		}else {
			return cliente;
		}
	}
	
	public Page<Cliente> buscarClientePorNombre(String nombreCliente,
			Pageable pageable){
		return respository.buscarClienteporNombreNativeQuery(nombreCliente,
				pageable);
	}
	

}
