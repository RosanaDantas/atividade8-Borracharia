package org.serratec.java2.borracharia.dto;

import java.time.LocalDateTime;

import org.serratec.java2.borracharia.entity.Carro;

public class ServicoDto {

	private Double valorServico;
	private String descricaoServico;
	private LocalDateTime dataServico;
	private Integer carroId;

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

	public LocalDateTime getDataServico() {
		return dataServico;
	}

	public void setDataServico(LocalDateTime dataServico) {
		this.dataServico = dataServico;
	}

	public Integer getCarroId() {
		return carroId;
	}

	public void setCarroId(Integer carroId) {
		this.carroId = carroId;
	}

}
