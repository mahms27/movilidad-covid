package net.javaguides.springboot.springsecurity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Permisos {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer consecutivo;
	
	private String placa;
	
	private String tipo;
	
	private String entidad;
	
	private String nombreApellido;
	
	private String cedula;
	
	private String estado;
	
	private String tipoDocumento;
	
	private String excepciones;

	public Permisos() {
		
	}

	public Integer getConsecutivo() {
		return consecutivo;
	}

	public String getPlaca() {
		return placa;
	}

	public String getTipo() {
		return tipo;
	}

	public String getEntidad() {
		return entidad;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public String getCedula() {
		return cedula;
	}

	public String getEstado() {
		return estado;
	}

	public void setConsecutivo(Integer consecutivo) {
		this.consecutivo = consecutivo;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getExcepciones() {
		return excepciones;
	}

	public void setExcepciones(String excepciones) {
		this.excepciones = excepciones;
	}

}
