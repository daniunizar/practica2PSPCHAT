package pruebaLogin;

public class Usuario {
	String nombre;
	String contra;
	public Usuario(String nombre, String contra) {
		super();
		this.nombre = nombre;
		this.contra = contra;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra = contra;
	}
	
	
}
