package io.gupy.attornatus.pessoaendereco.pessoa.application.api;

import org.springframework.web.bind.annotation.RestController;

import io.gupy.attornatus.pessoaendereco.pessoa.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@RestController
public class PessoaController implements PessoaAPI {

	private final PessoaService pessoaService;

	@Override
	public PessoaCriadoResponse postNovaPessoa(PessoaNovoRequest pessoaNovoRequest) {
		log.info("[inicia] PessoaController - postNovaPessoa");
		PessoaCriadoResponse pessoaCriada = pessoaService.criaNovoUsuario(pessoaNovoRequest);
		log.info("[finaliza] PessoaController - postNovaPessoa");
		return pessoaCriada;
	}
}
