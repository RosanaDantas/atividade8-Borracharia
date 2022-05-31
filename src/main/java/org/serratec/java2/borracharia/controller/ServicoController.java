package org.serratec.java2.borracharia.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.serratec.java2.borracharia.dto.RelatorioServicoDto;
import org.serratec.java2.borracharia.dto.ServicoDto;
import org.serratec.java2.borracharia.exception.EmailException;
import org.serratec.java2.borracharia.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servico")
public class ServicoController {
	
	@Autowired
	ServicoService servicoService;

	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody ServicoDto servicoDto) throws MessagingException, EmailException {
		return new ResponseEntity<>(servicoService.salvar(servicoDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/relatorio")
	public ResponseEntity<List<RelatorioServicoDto>> buscarUltimosCincoServicos(){
		return ResponseEntity.ok(servicoService.buscarUltimosCinco());
	}
}
