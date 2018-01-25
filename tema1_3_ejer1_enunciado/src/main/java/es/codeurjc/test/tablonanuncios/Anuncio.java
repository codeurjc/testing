package es.codeurjc.test.tablonanuncios;

public class Anuncio {

	private Long id;
	private String nombre;
	private String asunto;
	private String comentario;

	public Anuncio() {

	}

	public Anuncio(String nombre, String asunto, String comentario) {
		this(null, nombre, asunto, comentario);
	}
	
	public Anuncio(Long id, String nombre, String asunto, String comentario) {
		this.id = id;
		this.nombre = nombre;
		this.asunto = asunto;
		this.comentario = comentario;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Anuncio [id="+id+" nombre=" + nombre + ", asunto=" + asunto + ", comentario=" + comentario + "]";
	}

}
