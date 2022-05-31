package org.serratec.java2.borracharia.controller;

import org.serratec.java2.borracharia.dto.CarroDto;
import org.serratec.java2.borracharia.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	CarroService carroService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody CarroDto carroDto) {
		return new ResponseEntity<>(carroService.salvar(carroDto), HttpStatus.CREATED);
	}
}
