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
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
	private Long id;

	@JoinColumn(name = "servicio")
	@OneToOne(cascade = CascadeType.ALL)
	@NotNull
	private Servicio servicio;

	@Column(name = "fecha_inicio")
	private Date fechaInicio;

	@NotNull
	@Future
	@Column(name = "fecha_finalizacion")
	private Date fechaFinalizacion;

	@JoinColumn(name = "cliente")
	@OneToOne(cascade = CascadeType.ALL)
	@NotNull
	private Cliente cliente;

	@OneToOne(fetch = FetchType.LAZY)
	private Abogado abogado;

	@Column(name = "nombre")
	@NotEmpty
	private String nombre;

	@Column
	@NotEmpty
	private String descripcion;

	@PrePersist
	public void prePersist() {
		fechaInicio = new Date();
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Abogado getAbogado() {
		return abogado;
	}

	public void setAbogado(Abogado abogado) {
		this.abogado = abogado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTitulo() {
		return nombre;
	}

	public void setTitulo(String nombre) {
		this.nombre = nombre;
	}

}
