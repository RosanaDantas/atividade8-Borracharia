package org.serratec.java2.borracharia.service;

import org.serratec.java2.borracharia.dto.CarroDto;
import org.serratec.java2.borracharia.entity.Carro;
import org.serratec.java2.borracharia.repository.CarroRepository;
import org.serratec.java2.borracharia.repository.ClienteRepository;
import org.serratec.java2.borracharia.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {
	
	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ServicoRepository servicoRepository;
	

	public Carro transformaDtoemEntity(CarroDto carroDto, Carro carro) {
		
		carro.setAno(carroDto.getAno());
		carro.setMarca(carroDto.getMarca());
		carro.setModelo(carroDto.getModelo());
		carro.setCliente(null);
		
		if (carroDto.getClienteId() != null) {
			carro.setCliente(clienteRepository.findById(carroDto.getClienteId()).get());
		}

		return carro;
	}
	
	public String salvar(CarroDto carroDto) {
		Carro carro = new Carro();
		transformaDtoemEntity(carroDto, carro);

		carroRepository.save(carro);
	
		return "Carro salvo com id: " + carro.getCarroId();
	}

}
