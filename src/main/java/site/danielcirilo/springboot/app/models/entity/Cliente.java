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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Primary;

import site.danielcirilo.springboot.app.models.tipoDocumento.TipoDocumento;

@Entity
@Table(name = "clientes")
@DiscriminatorValue("cliente")
public class Cliente extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;


	@Column(name = "documento_cliente")
	@Size(max = 9,min = 9)
	private String documentoCliente;
	
	@Column
	@NotEmpty
	@Size(min = 4)
	private String nacionalidad;

	@Enumerated(value = EnumType.STRING)
	@NotNull
	private TipoDocumento tipoDocumento;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Factura> facturas;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Cita> citas;

	public Cliente() {

	}

	









	public Cliente(Long id, String direccion, Date fecha_nacimiento, String nombre, String apellido, String email,
			long telefono, String documentoCliente, @NotEmpty @Size(min = 4) String nacionalidad,
			@NotNull TipoDocumento tipoDocumento, List<Factura> facturas, List<Cita> citas) {
		super(id, direccion, fecha_nacimiento, nombre, apellido, email, telefono);
		this.documentoCliente = documentoCliente;
		this.nacionalidad = nacionalidad;
		this.tipoDocumento = tipoDocumento;
		this.facturas = facturas;
		this.citas = citas;
	}



	public String getDocumentoCliente() {
		return documentoCliente;
	}

	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}



	public List<Cita> getCitas() {
		return citas;
	}











	public void setCitas(List<Cita> citas) {
		this.citas = citas;
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
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}



}
