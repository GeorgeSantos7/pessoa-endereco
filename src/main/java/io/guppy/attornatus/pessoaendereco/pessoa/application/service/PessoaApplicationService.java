package io.guppy.attornatus.pessoaendereco.pessoa.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.guppy.attornatus.pessoaendereco.pessoa.application.api.EditaPessoaRequest;
import io.guppy.attornatus.pessoaendereco.pessoa.application.api.EnderecoRequest;
import io.guppy.attornatus.pessoaendereco.pessoa.application.api.PessoaListResponse;
import io.guppy.attornatus.pessoaendereco.pessoa.application.api.PessoaRequest;
import io.guppy.attornatus.pessoaendereco.pessoa.application.api.PessoaResponse;
import io.guppy.attornatus.pessoaendereco.pessoa.application.repository.PessoaRepository;
import io.guppy.attornatus.pessoaendereco.pessoa.domain.Endereco;
import io.guppy.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PessoaApplicationService implements PessoaService {

	private final PessoaRepository pessoaRepository;

	@Override
	public PessoaResponse criaNovoUsuario(PessoaRequest novaPessoa) {
		log.info("[inicia] PessoaApplicationService - criaNovoUsuario");
		log.info("[PessoaApplicationService] {}", novaPessoa);
		Pessoa pessoa = pessoaRepository.salva(new Pessoa(novaPessoa));
		log.info("[finaliza] PessoaApplicationService - criaNovoUsuario");
		return new PessoaResponse(pessoa);
	}

	@Override
	public Pessoa buscaUsuarioPorId(UUID idPessoa) {
		log.info("[inicia] PessoaApplicationService - buscaUsuarioPorId");
		log.info("[idPessoa] {}", idPessoa);
		Pessoa pessoa = pessoaRepository.buscaUsuarioPorId(idPessoa);
		log.info("[finaliza] PessoaApplicationService - buscaUsuarioPorId");
		return pessoa;
	}

	@Override
	public void editaPessoa(UUID idPessoa, EditaPessoaRequest editaPessoaRequest) {
		log.info("[inicia] PessoaApplicationService - editaPessoa");
		Pessoa pessoa = buscaUsuarioPorId(idPessoa);
		pessoa.altera(editaPessoaRequest);
		pessoaRepository.salva(pessoa);
		log.info("[finaliza] PessoaApplicationService - editaPessoa");
		
	}

	@Override
	public Pessoa adicionaNovoEnderecoPessoa(UUID idPessoa, EnderecoRequest enderecoRequest) {
		log.info("[inicia] PessoaApplicationService - adicionaNovoEnderecoPessoa");
		Pessoa pessoa = buscaUsuarioPorId(idPessoa);
		Endereco novoEndereco = new Endereco(enderecoRequest);
		pessoa.adicionarEndereco(novoEndereco);
		pessoaRepository.salva(pessoa);
		log.info("[finaliza] PessoaApplicationService - adicionaNovoEnderecoPessoa");
		return pessoa;
	}

	@Override
	public List<PessoaListResponse> buscaTodasPessoas() {
		log.info("[inicia] PessoaApplicationService - buscaTodasPessoas");
		List<Pessoa> pessoas = pessoaRepository.buscaTodasPessoas();
		List<PessoaListResponse> resposta = new ArrayList<>();
	    for (Pessoa pessoa : pessoas) {
	        resposta.add(new PessoaListResponse(pessoa));
	    }
		log.info("[finaliza] PessoaApplicationService - buscaTodasPessoas");
		return resposta;
	}
}
