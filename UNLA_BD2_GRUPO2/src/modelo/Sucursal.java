package modelo;

import org.bson.Document;

public class Sucursal {
	
	private Domicilio domicilio;
	private int nroSucursal;
	
	public Sucursal(Domicilio domicilio, int nroSucursal) {
		this.domicilio = domicilio;
		this.nroSucursal = nroSucursal;
	}
	
	public Document toDocumentSucursal() {
		Document documento =  new Document("nroSucursal", this.nroSucursal)
				.append("domicilio", this.domicilio.toDocumentDomicilio());
		return documento;
	}
	
	public Domicilio getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	public int getNroSucursal() {
		return nroSucursal;
	}
	public void setNroSucursal(int nroSucursal) {
		this.nroSucursal = nroSucursal;
	}
	
}
