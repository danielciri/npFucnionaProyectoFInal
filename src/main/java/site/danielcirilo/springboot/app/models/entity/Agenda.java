package site.danielcirilo.springboot.app.models.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Daniel Cirilo
 *
 */
@Entity
@Table (name="agendas")
public class Agenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String actividad;
	@Column (name = "fecha_creacion")
	private Date fechaCreacion;
	@Column(name = "fecha_finalizacion")
	private Date fechaFinalizacion;

}
