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
@Table(name="TB_AGENDAMENTO")
@SequenceGenerator(name="agendamento", sequenceName = "SQ_TB_AGENDAMENTO", allocationSize = 1)
public class Agendamento {
	
	@Id
	@Column(name="cd_agendamento")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agendamento")
	private Integer codigo;
	
	@Column(name="vl_agendamento", nullable = false, precision = 8)
	private int valorAgendamento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_agendamento")
	private Calendar dataAgendamento;

	public Agendamento() {}
	
	public Agendamento(int valorAgendamento, Calendar dataAgendamento) {
		this.valorAgendamento = valorAgendamento;
		this.dataAgendamento = dataAgendamento;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public int getValorAgendamento() {
		return valorAgendamento;
	}

	public void setValorAgendamento(int valorAgendamento) {
		this.valorAgendamento = valorAgendamento;
	}

	public Calendar getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Calendar dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	
}
