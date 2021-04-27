package com.qbo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qbo.convertdto.DtoUtil;
import com.qbo.model.Sala;
import com.qbo.model.dto.DtoEntity;
import com.qbo.model.dto.SalaDto;
import com.qbo.service.SalaService;

@RestController
@RequestMapping(path = "api/v1/sala")
public class SalaController {
	
	@Autowired
	private SalaService servicio;

	@GetMapping("/fulldata")
	public ResponseEntity<List<Sala>> obtenerFullDataSala(){
		List<Sala> salas = new ArrayList<Sala>();
		servicio.obtenerTodo().forEach(salas::add);
		if(salas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(salas, HttpStatus.OK);
	}
	
	@GetMapping("/dto")
	public ResponseEntity<List<DtoEntity>> obtenerSalaDto(){
		List<DtoEntity> salasdto = new ArrayList<DtoEntity>();
		salasdto = servicio.obtenerTodo()
				.stream()
				.map(x -> new DtoUtil().convertirADto(x, new SalaDto()))
				.collect(Collectors.toList());
		if(salasdto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(salasdto, HttpStatus.OK);
	}
	
}
