package org.serratec.java2.borracharia.service;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.serratec.java2.borracharia.dto.RelatorioServicoDto;
import org.serratec.java2.borracharia.dto.ServicoDto;
import org.serratec.java2.borracharia.entity.Servico;
import org.serratec.java2.borracharia.exception.EmailException;
import org.serratec.java2.borracharia.repository.CarroRepository;
import org.serratec.java2.borracharia.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {
	
	@Autowired
	ServicoRepository servicoRepository;
	
	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	EmailService emailService;
	
	public String salvar(ServicoDto servicoDto) throws MessagingException, EmailException {
		Servico servico = new Servico();
		transformaDTOEmEntity(servicoDto, servico);
		servicoRepository.save(servico);
		emailService.emailTeste(servico);
		
		return "Serviço salvo com id: " + servico.getServicoId();
	}

	
	public Servico transformaDTOEmEntity(ServicoDto servicoDto, Servico servico) {
		servico.setDescricaoServico(servicoDto.getDescricaoServico());
		servico.setDataServico(servicoDto.getDataServico());
		servico.setValorServico(servicoDto.getValorServico());
		
		if(servicoDto.getCarroId() != null) {
			servico.setCarro(carroRepository.findById(servicoDto.getCarroId()).get());
		}

		return servico;
	}


	public List<RelatorioServicoDto> buscarUltimosCinco() {
		
		List<Servico> listaServico = servicoRepository.buscarUltimosCincoServicos();
		List<RelatorioServicoDto> listaRelatorioServico = new ArrayList<>();
		
		for (Servico servico : listaServico) {
			RelatorioServicoDto relatorioServicoDto = new RelatorioServicoDto();
			relatorioServicoDto.setNomeCliente(servico.getCarro().getCliente().getNome());
			relatorioServicoDto.setModeloCarro(servico.getCarro().getModelo());
			relatorioServicoDto.setValorServico(servico.getValorServico());
			relatorioServicoDto.setDescricaoServico(servico.getDescricaoServico());
			listaRelatorioServico.add(relatorioServicoDto);
		}
		return listaRelatorioServico;
	}
}
