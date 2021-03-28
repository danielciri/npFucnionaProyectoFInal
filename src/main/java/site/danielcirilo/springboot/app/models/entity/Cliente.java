package site.danielcirilo.springboot.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import ch.qos.logback.core.subst.Token.Type;

@Entity
@Table (name="clientes")
@PrimaryKeyJoinColumn(referencedColumnName = "documento_persona")
public class Cliente extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column
	private String direccion;
	
	@Column
	private char sexo;
	
	@Column (name = "fecha_nacimiento")
	private Date fecha_nacimiento;
	
	@OneToMany(mappedBy = "cliente",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Factura> facturas;
	
	@OneToOne(mappedBy = "cliente",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Cita cita;
	
	public Cliente() {
		facturas = new ArrayList<>();
	}
	
	
	
	
	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public char getSexo() {
		return sexo;
	}


	public void setSexo(char sexo) {
		this.sexo = sexo;
	}


	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public List<Factura> getFacturas() {
		return facturas;
	}


	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public void addFactura(Factura factura) {
		facturas.add(factura);
	}

}
