package org.serratec.java2.borracharia.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.java2.borracharia.dto.ClienteDto;
import org.serratec.java2.borracharia.entity.Cliente;
import org.serratec.java2.borracharia.repository.CarroRepository;
import org.serratec.java2.borracharia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	CarroRepository carroRepository;

	public ClienteDto transformarEntityEmDTO(Cliente cliente, ClienteDto clienteDto) {

		clienteDto.setCpf(cliente.getCpf());
		clienteDto.setEmail(cliente.getEmail());
		clienteDto.setNome(cliente.getNome());
		clienteDto.setNumeroTelefone(cliente.getNumeroTelefone());

		return clienteDto;
	}

	public Cliente transformaDTOEmEntity(ClienteDto clienteDto, Cliente cliente) {
		cliente.setCpf(clienteDto.getCpf());
		cliente.setEmail(clienteDto.getEmail());
		cliente.setNome(clienteDto.getNome());
		cliente.setNumeroTelefone(clienteDto.getNumeroTelefone());

		return cliente;
	}

	public String salvar(ClienteDto clienteDto) {
		Cliente cliente = new Cliente();
		transformaDTOEmEntity(clienteDto, cliente);
		clienteRepository.save(cliente);
		
//		carroRepository.saveAll(cliente.getListacarro());

		return "Cliente salvo com id: " + cliente.getClienteId();
	}

	public List<ClienteDto> listarTodos() {
		List<Cliente> listaClienteEntity = clienteRepository.findAll();
		List<ClienteDto> listaClienteDto = new ArrayList<>();

		for (Cliente cliente : listaClienteEntity) {
			ClienteDto clienteDto = new ClienteDto();
			transformarEntityEmDTO(cliente, clienteDto);
			listaClienteDto.add(clienteDto);
		}
		return listaClienteDto;
	}
}
