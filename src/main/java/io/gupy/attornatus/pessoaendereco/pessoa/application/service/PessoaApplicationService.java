package io.gupy.attornatus.pessoaendereco.pessoa.application.service;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import io.gupy.attornatus.pessoaendereco.pessoa.application.api.PessoaCriadoResponse;
import io.gupy.attornatus.pessoaendereco.pessoa.application.api.PessoaNovoRequest;
import io.gupy.attornatus.pessoaendereco.pessoa.application.repository.PessoaRepository;
import io.gupy.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PessoaApplicationService implements PessoaService {
	
	private final PessoaRepository pessoaRepository;

	@Override
	public PessoaCriadoResponse criaNovoUsuario(@Valid PessoaNovoRequest novaPessoa) {
		log.info("[inicia] PessoaApplicationService - PessoaCriadoResponse");
		Pessoa pessoa = pessoaRepository.salva(new Pessoa(novaPessoa));
		log.info("[finaliza] PessoaApplicationService - PessoaCriadoResponse");
		return new PessoaCriadoResponse(pessoa);
	}

	@Override
	public PessoaCriadoResponse buscaUsuarioPorId(UUID idPessoa) {
		log.info("[inicia] PessoaApplicationService - buscaUsuarioPorId");
		Pessoa pessoa = pessoaRepository.buscaUsuarioPorId(idPessoa);
		log.info("[finaliza] PessoaApplicationService - buscaUsuarioPorId");
		return new PessoaCriadoResponse(pessoa);
	}

}
