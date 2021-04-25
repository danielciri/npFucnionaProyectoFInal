package site.danielcirilo.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "citas")
public class Cita implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCita;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nombre_cliente")
	private Cliente cliente;

	
	@DateTimeFormat(pattern = "HH:mm:ss")
	@Temporal(TemporalType.TIME)
	//@NotNull
	@Column(name = "hora")
	private Date hora;

	@Column
	@NotEmpty
	private String asunto;

	/*
	@OneToOne(fetch = FetchType.LAZY)
	private Abogado abogado;
	*/


	@NotNull
	
	@Column(name = "fecha_programada")
	private java.sql.Date fechaProgramada;

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


	public java.sql.Date getFechaProgramada() {
		return fechaProgramada;
	}

	public void setFechaProgramada(java.sql.Date fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
	}

	@Override
	public String toString() {
		return "Cita [idCita=" + idCita + ", cliente=" + cliente + ", hora=" + hora + ", asunto=" + asunto
				+ ", fechaProgramada=" + fechaProgramada + "]";
	}
	

}
