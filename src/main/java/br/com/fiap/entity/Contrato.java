package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_CONTRATO")
@SequenceGenerator(name="contrato", sequenceName = "SQ_TB_CONTRATO", allocationSize = 1)
public class Contrato {
	
	@Id
	@Column(name="cd_contrato")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contrato")
	private Integer codigo;
	
	@Column(name="vl_total", nullable = false, precision = 8)
	private int valortotal;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_inicio")
	private Calendar dataInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_termino")
	private Calendar dataTermino;

	public Contrato() {}
	
	public Contrato(int valortotal, Calendar dataInicio, Calendar dataTermino) {
		this.valortotal = valortotal;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public int getValortotal() {
		return valortotal;
	}

	public void setValortotal(int valortotal) {
		this.valortotal = valortotal;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Calendar dataTermino) {
		this.dataTermino = dataTermino;
	}
}
