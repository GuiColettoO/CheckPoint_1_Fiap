package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_SERVICO")
@SequenceGenerator(name="servico", sequenceName = "SQ_TB_SERVICO", allocationSize = 1)
public class Servico {
	
	@Id
	@Column(name="cd_servico")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servico")
	private Integer codigo;
	
	@Column(name="ds_nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name="ds_descricao", nullable = false, length = 255)
	private String descricao;
	
	@Column(name="vl_preco", precision = 8)
	private float preco;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Servico() {}

	public Servico(String nome, String descricao, float preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	
}
