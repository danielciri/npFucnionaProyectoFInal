package site.danielcirilo.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "citas")
public class Cita implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCita;

	@OneToOne(fetch = FetchType.LAZY)
	private Cliente cliente;

	@Temporal(TemporalType.TIME)
	@Column(name = "hora_cita", unique = true)
	private Date hora;

	@Column
	private String asunto;

	@OneToOne(fetch = FetchType.LAZY)
	private Abogado abogado;

	@Column(name = "estado_cita")
	private boolean estadoCita;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_programada")
	private Date fechaProgramada;

	public Long getIdCita() {
		return idCita;
	}

	public void setIdCita(Long idCita) {
		this.idCita = idCita;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public Abogado getAbogado() {
		return abogado;
	}

	public void setAbogado(Abogado abogado) {
		this.abogado = abogado;
	}

	public boolean isEstadoCita() {
		return estadoCita;
	}

	public void setEstadoCita(boolean estadoCita) {
		this.estadoCita = estadoCita;
	}

	public Date getFechaProgramada() {
		return fechaProgramada;
	}

	public void setFechaProgramada(Date fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
	}

}
