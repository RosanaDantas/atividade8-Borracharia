package org.serratec.java2.borracharia.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer clienteId;

	@NotNull
	@Size(min = 3, max = 20)
	@Column(name = "nomeCliente")
	private String nome;

	@NotNull
	@Size(min = 11, max = 11)
	@Column(name = "clienteCpf")
	private String cpf;

	@Column(name = "ClienteTelefone")
	private String numeroTelefone;

	@Email
	@Column(name = "ClienteEmail")
	private String email;

	@OneToMany(mappedBy = "cliente")
	@JsonIgnore
	private List<Carro> listacarro;

	public Cliente() {

	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Carro> getListacarro() {
		return listacarro;
	}

	public void setListacarro(List<Carro> listacarro) {
		this.listacarro = listacarro;
	}

}
