package org.serratec.java2.borracharia.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "servico")
public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "servicoId")
	private Integer servicoId;

	@NotNull
	private Double valorServico;

	@NotNull
	private String descricaoServico;

	@NotNull
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private LocalDateTime dataServico;

	@ManyToOne
	@JoinColumn(name = "carro_id", referencedColumnName = "carroId")
	private Carro carro;

	public Servico() {
	}

	public Integer getServicoId() {
		return servicoId;
	}

	public void setServicoId(Integer servicoId) {
		this.servicoId = servicoId;
	}

	public Double getValorServico() {
		return valorServico;
	}

	public void setValorServico(Double valorServico) {
		this.valorServico = valorServico;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public LocalDateTime getDataServico() {
		return dataServico;
	}

	public void setDataServico(LocalDateTime dataServico) {
		this.dataServico = dataServico;
	}

}
