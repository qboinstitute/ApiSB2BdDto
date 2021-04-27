package com.qbo.model.dto;

public class SalaDto implements DtoEntity {
	
	private String descsala;
	private Integer asientos;
	public String getDescsala() {
		return descsala;
	}
	public void setDescsala(String descsala) {
		this.descsala = descsala;
	}
	public Integer getAsientos() {
		return asientos;
	}
	public void setAsientos(Integer asientos) {
		this.asientos = asientos;
	}
	public SalaDto(String descsala, Integer asientos) {
		super();
		this.descsala = descsala;
		this.asientos = asientos;
	}
	public SalaDto() {
	}
	
	

}
