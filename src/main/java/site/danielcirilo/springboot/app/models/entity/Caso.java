package site.danielcirilo.springboot.app.models.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * 
 * @author Daniel Cirilo
 *
 */
@Entity
@Table(name = "casos")
public class Caso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoCaso;

	@JoinColumn(name = "nombre_servicio")
	@OneToOne(cascade = CascadeType.ALL)
	private Servicio nombreServicio;

	@Column(name = "fecha_inicio")
	private Date fechaInicio;

	@Column(name = "fecha_finalizacion")
	private Date fechaFinalizacion;

	@JoinColumn(name = "nombre_cliente")
	@OneToOne(cascade = CascadeType.ALL)
	private Cliente nombreCliente;

	@OneToOne(fetch = FetchType.LAZY)
	private Abogado licencia;

	@Column(name = "titulo_caso")
	private String titulo;

	@PrePersist
	public void prePersist() {
		fechaInicio = new Date();
	}

	public Long getCodigoCaso() {
		return codigoCaso;
	}

	public void setCodigoCaso(Long codigoCaso) {
		this.codigoCaso = codigoCaso;
	}

	public Servicio getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(Servicio nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public Cliente getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(Cliente nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Abogado getLicencia() {
		return licencia;
	}

	public void setLicencia(Abogado licencia) {
		this.licencia = licencia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
