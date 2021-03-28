package site.danielcirilo.springboot.app.models.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "expedientes")
public class Expediente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "num_expediente")
	private Long num_expediente;

	@Column(name = "fecha_apertura")
	private Date fechaApertura;

	@Column(name = "fecha_cerrado")
	private Date fechaCerrado;

	@Column
	private String observacion;

	@JoinColumn(name = "codigo_caso")
	@OneToOne(cascade = CascadeType.ALL)
	private Caso caso;

	@Column
	private boolean estado;

	@PrePersist
	public void prePersiste() {
		fechaApertura = new Date();
	}

	public Long getNum_expediente() {
		return num_expediente;
	}

	public void setNum_expediente(Long num_expediente) {
		this.num_expediente = num_expediente;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public Date getFechaCerrado() {
		return fechaCerrado;
	}

	public void setFechaCerrado(Date fechaCerrado) {
		this.fechaCerrado = fechaCerrado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
