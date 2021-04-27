package com.qbo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "sala")
public class Sala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idsala;
	
	@Column(name = "descsala")
	private String descsala;
	
	@Column(name = "asientos")
	private String asientos;

	public Long getIdsala() {
		return idsala;
	}

	public void setIdsala(Long idsala) {
		this.idsala = idsala;
	}

	public String getDescsala() {
		return descsala;
	}

	public void setDescsala(String descsala) {
		this.descsala = descsala;
	}

	public String getAsientos() {
		return asientos;
	}

	public void setAsientos(String asientos) {
		this.asientos = asientos;
	}
	
	@OneToOne(cascade = CascadeType.ALL) // Si se elimina el objeto Sala se elimina el objeto estado
	@JoinColumn(name = "idestado")
	private Estado estado;
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@JsonManagedReference
	@OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Asiento> listaasiento = new ArrayList<Asiento>();

	public List<Asiento> getListaasiento() {
		return listaasiento;
	}

	public void setListaasiento(List<Asiento> listaasiento) {
		this.listaasiento = listaasiento;
	}
	
	
	

}
