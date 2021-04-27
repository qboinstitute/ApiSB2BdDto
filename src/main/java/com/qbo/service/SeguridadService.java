package com.qbo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qbo.repository.RolUsuarioRepository;
import com.qbo.repository.UsuarioRepository;
import com.qbo.model.security.*;

@Service
public class SeguridadService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private RolUsuarioRepository rolUsuarioRepository;
	
	public Optional<Usuario> autenticarUsuario(String usuario, 
			String password){
		Optional<Usuario> entityOptional = 
				usuarioRepository.autenticarUsuario(usuario, password);
		if(entityOptional.isEmpty()) {
			return Optional.empty();
		}
		return entityOptional;
	}
	
	public String[] listarRolesPorUsuario(Long idusuario) {
		List<RolUsuario> listarolusuario = rolUsuarioRepository
				.listarRolesPorUsuario(idusuario);
		String[] listaroles = new String[listarolusuario.size()];
		for(int i = 0; i< listarolusuario.size(); i++) {
			listaroles[i] = listarolusuario.get(i).getNomrol();
		}
		return listaroles;
	}
}
