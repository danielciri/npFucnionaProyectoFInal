package site.danielcirilo.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import site.danielcirilo.springboot.app.models.tipoDocumento.TipoDocumento;

@Entity
@Table(name = "clientes")
@DiscriminatorValue("cliente")
public class Cliente extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "cliente_documento", unique = true)
	private String documentoCliente;

	@Column
	private String nacionalidad;

	@Enumerated(value = EnumType.STRING)
	TipoDocumento TipoDocumento;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Factura> facturas;

	@OneToOne(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Cita cita;

	public Cliente() {

	}

	public Cliente(String direccion, Date fecha_nacimiento, char sexo, String nombre, String apellido, String email,
			long telefono, String documentoCliente, String nacionalidad,
			site.danielcirilo.springboot.app.models.tipoDocumento.TipoDocumento tipoDocumento) {
		super(direccion, fecha_nacimiento, sexo, nombre, apellido, email, telefono);
		this.documentoCliente = documentoCliente;
		this.nacionalidad = nacionalidad;
		TipoDocumento = tipoDocumento;

	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
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

	public TipoDocumento getTipoDocumento() {
		return TipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		TipoDocumento = tipoDocumento;
	}

}
