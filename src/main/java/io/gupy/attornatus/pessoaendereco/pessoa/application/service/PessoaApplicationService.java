package io.gupy.attornatus.pessoaendereco.pessoa.application.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.gupy.attornatus.pessoaendereco.handler.APIException;
import io.gupy.attornatus.pessoaendereco.pessoa.application.api.EditaPessoaRequest;
import io.gupy.attornatus.pessoaendereco.pessoa.application.api.PessoaCriadoResponse;
import io.gupy.attornatus.pessoaendereco.pessoa.application.api.PessoaListRespose;
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
		Pessoa pessoa = new Pessoa(novaPessoa);
		pessoa = pessoaRepository.salva(pessoa);
		log.info("[finaliza] PessoaApplicationService - PessoaCriadoResponse");
		return new PessoaCriadoResponse(pessoa);
	}

	@Override
	public Pessoa buscaUsuarioPorId(UUID idPessoa) {
		log.info("[inicia] PessoaApplicationService - buscaUsuarioPorId");
		Pessoa pessoa = pessoaRepository.buscaUsuarioPorId(idPessoa);
		log.info("[finaliza] PessoaApplicationService - buscaUsuarioPorId");
		return pessoa;
	}

	@Override
	public void editaPessoa(UUID idPessoa, @Valid EditaPessoaRequest pessoaNovoRequest) {
		log.info("[inicia] PessoaApplicationService - buscaUsuarioPorId");
		Pessoa pessoa = buscaUsuarioPorId(idPessoa);
		pessoa.edita(pessoaNovoRequest);
		pessoaRepository.salva(pessoa);
		log.info("[finaliza] PessoaApplicationService - buscaUsuarioPorId");
		
	}

	@Override
	public List<PessoaListRespose> buscaTodosClientes() {
		log.info("[inicia] - PessoaApplicationService - buscaTodosClientes");
		List<Pessoa> pessoa = pessoaRepository.buscaTodasPessoas();
		log.info("[finaliza] - PessoaApplicationService - buscaTodosClientes");
		return PessoaListRespose.converte(pessoa);
	}

}
