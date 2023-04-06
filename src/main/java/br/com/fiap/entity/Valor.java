package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_VALOR")
@SequenceGenerator(name="valor", sequenceName = "SQ_TB_VALOR", allocationSize = 1)
public class Valor {
	
	@Id
	@Column(name="cd_valor")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "valor")
	private Integer codigo;
	
	@Column(name="vl_agendamento", precision = 8)
	private float valorAgendamento;
	
	@Column(name="vl_contrato", precision = 8)
	private float valorContrato;

	public Valor() {}
	
	public Valor(float valorAgendamento, float valorContrato) {
		this.valorAgendamento = valorAgendamento;
		this.valorContrato = valorContrato;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public float getValorAgendamento() {
		return valorAgendamento;
	}

	public void setValorAgendamento(float valorAgendamento) {
		this.valorAgendamento = valorAgendamento;
	}

	public float getValorContrato() {
		return valorContrato;
	}

	public void setValorContrato(float valorContrato) {
		this.valorContrato = valorContrato;
	}
	
	
}
