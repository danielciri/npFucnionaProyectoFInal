package site.danielcirilo.springboot.app.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity 
@Table(name = "citas")
public class Cita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCita;
	
	@Column(name = "nombre_cliente")
	@OneToOne
	private Cliente nomCliente;
	
	@Column(name = "hora_cita")
	private DateTimeFormat hora;
	
	@Column
	private String asunto;
	
	@Column(name = "nombre_abogado")
	@OneToOne
	private Abogado nomAbogado;
	
	@Column(name = "estado_cita")
	private boolean estadoCita;
	
	@Column(name = "fecha_programada")
	private Date fechaProgramada;
	
	

}
