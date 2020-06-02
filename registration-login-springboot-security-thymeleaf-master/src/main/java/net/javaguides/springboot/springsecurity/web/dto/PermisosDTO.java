package net.javaguides.springboot.springsecurity.web.dto;

public class PermisosDTO {

private Integer consecutivo;
	
	private String placa;
	
	private String tipo;
	
	private String entidad;
	
	private String nombreApellido;
	
	private String cedula;
	
	private String estado;
	
	private Integer page;
	 
	private Integer size;
	
	private String tipoDocumento;
	
	private String excepciones;

	public PermisosDTO() {
		
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

	public Integer getPage() {
		return page;
	}

	public Integer getSize() {
		return size;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setSize(Integer size) {
		this.size = size;
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
