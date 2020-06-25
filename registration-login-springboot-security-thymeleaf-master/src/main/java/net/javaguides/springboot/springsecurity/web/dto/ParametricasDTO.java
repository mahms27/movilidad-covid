package net.javaguides.springboot.springsecurity.web.dto;

public class ParametricasDTO {
	
    private Integer id;
	
	private String nombre;
	
	private String valor;
	
	private Integer page;
	 
	private Integer size;

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setValor(String valor) {
		this.valor = valor;
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
	
	
	
}


