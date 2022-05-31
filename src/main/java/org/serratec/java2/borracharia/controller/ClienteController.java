package org.serratec.java2.borracharia.controller;

import java.util.List;

import org.serratec.java2.borracharia.dto.ClienteDto;
import org.serratec.java2.borracharia.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<ClienteDto>> listarTodos() {
		return ResponseEntity.ok(clienteService.listarTodos());
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody ClienteDto clienteDto) {
		return new ResponseEntity<>(clienteService.salvar(clienteDto), HttpStatus.CREATED);
	}
	
}
