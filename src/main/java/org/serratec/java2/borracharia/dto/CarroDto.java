package org.serratec.java2.borracharia.dto;

import java.util.List;

import org.serratec.java2.borracharia.entity.Cliente;
import org.serratec.java2.borracharia.entity.Servico;

public class CarroDto {

	private String modelo;
	private String marca;
	private Integer ano;
	private Integer clienteId;
	

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

}
