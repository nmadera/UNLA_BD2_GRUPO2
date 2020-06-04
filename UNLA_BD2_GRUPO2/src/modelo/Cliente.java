package modelo;

import java.util.ArrayList;
import java.util.Arrays;

import org.bson.Document;

public class Cliente {
	
	private String apellido;
	private String nombre;
	private int dni;
	private int numeroAfiliado;
	private Domicilio domicilio;
	
	public Cliente() {}
	
	public Cliente(String apellido, String nombre, int dni, int numeroAfiliado, Domicilio domicilio) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.numeroAfiliado = numeroAfiliado;
		this.domicilio = domicilio;
	}
	
	public Document toDocumentCliente() {
		
		Document documento =  new Document("apellido", this.apellido)
				.append("nombre", this.nombre)
				.append("dni", this.dni)
				.append("numeroAfiliado", this.numeroAfiliado)
				.append("domicilio", this.domicilio.toDocumentDomicilio());
		
		return documento;
	
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getNumeroAfiliado() {
		return numeroAfiliado;
	}

	public void setNumeroAfiliado(int numeroAfiliado) {
		this.numeroAfiliado = numeroAfiliado;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	@Override
	public String toString() {
		return "Cliente [apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni + ", numeroAfiliado="
				+ numeroAfiliado + ", domicilio=" + domicilio + "]";
	}
	
	

	
	

}
