package io.gupy.attornatus.pessoaendereco.pessoa.application.api;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import io.gupy.attornatus.pessoaendereco.pessoa.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Log4j2
@RequiredArgsConstructor
@RestController
public class PessoaController implements PessoaAPI {


	private PessoaService pessoaAppplicationService;

	@Override
	public PessoaCriadoResponse postNovaPessoa(@Valid PessoaNovoRequest novaPessoa) {
		log.info("[inicia] PessoaController - postNovaPessoa");
		PessoaCriadoResponse pessoaCriada = pessoaAppplicationService.criaNovoUsuario(novaPessoa);
		log.info("[finaliza] PessoaController - postNovaPessoa");
		return pessoaCriada;
	}

	@Override
	public PessoaCriadoResponse buscaPessoaPorId(UUID idPessoa) {
		log.info("[inicia] PessoaController - buscaUsuarioPorId");
		PessoaCriadoResponse buscaPessoa = pessoaAppplicationService.buscaUsuarioPorId(idPessoa);
		log.info("[finaliza] PessoaController - buscaUsuarioPorId");
		return buscaPessoa;
	}

}
