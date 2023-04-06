package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_CLIENTE")
@SequenceGenerator(name="cliente", sequenceName = "SQ_TB_CLIENTE", allocationSize = 1)
public class Cliente {
	
	@Id
	@Column(name="cd_cliente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	private Integer codigo;
	
	@Column(name="ds_nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name="ds_endereco", nullable = false, length = 80)
	private String endereco;
	
	@Column(name="nm_telefone", precision = 11)
	private int telefone;
	
	@Column(name="ds_email", nullable = false, length = 80)
	private String email;
	
	public Cliente() {}

	public Cliente(String nome, String endereco, int telefone, String email) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
