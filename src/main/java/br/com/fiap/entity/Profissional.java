package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PROFISSIONAL")
@SequenceGenerator(name="profissional", sequenceName = "SQ_TB_PROFISSIONAL", allocationSize = 1)
public class Profissional {
	@Id
	@Column(name="cd_profissional")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profissional")
	private Integer codigo;
	
	@Column(name="ds_nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name="ds_especializacao", nullable = false, length = 30)
	private Especializacao especializacao;
	
	@Column(name="nm_telefone", precision = 12)
	private int telefone;
	
	@Column(name="nm_endereco", nullable = false, length = 80)
	private String endereco;
	
	@Column(name="ds_email", nullable = false, length = 80)
	private String email;
	
	public Profissional() {}
	


	public Profissional(String nome, Especializacao especializacao, int telefone, String endereco, String email) {
		this.nome = nome;
		this.especializacao = especializacao;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
	}



	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
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

	public Especializacao getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(Especializacao especializacao) {
		this.especializacao = especializacao;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
