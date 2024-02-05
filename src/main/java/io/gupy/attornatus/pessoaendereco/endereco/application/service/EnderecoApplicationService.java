package io.gupy.attornatus.pessoaendereco.endereco.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import io.gupy.attornatus.pessoaendereco.endereco.application.api.EnderecoIdResponse;
import io.gupy.attornatus.pessoaendereco.endereco.application.api.EnderecoListResponse;
import io.gupy.attornatus.pessoaendereco.endereco.application.api.EnderecoRequest;
import io.gupy.attornatus.pessoaendereco.endereco.application.repository.EnderecoRepository;
import io.gupy.attornatus.pessoaendereco.endereco.domain.Endereco;
import io.gupy.attornatus.pessoaendereco.pessoa.application.repository.PessoaRepository;
import io.gupy.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
@RequiredArgsConstructor
public class EnderecoApplicationService implements EnderecoService {

	private final PessoaRepository pessoaReposiory;
	private final EnderecoRepository enderecoRepository;

	@Override
	public EnderecoIdResponse criaEndereco(UUID idPessoa, @Valid EnderecoRequest enderecoRequest) {
		log.info("[inicia] - EnderecoApplicationService - criaEndereco");
		Pessoa pessoa = pessoaReposiory.buscaUsuarioPorId(idPessoa);
		Endereco novoEndereco = new Endereco(enderecoRequest);
		pessoa.addEndereco(novoEndereco);
		pessoaReposiory.salva(pessoa);
		log.info("[finaliza] - EnderecoApplicationService - criaEndereco");
		return new EnderecoIdResponse(novoEndereco.getIdEndereco());
	}

	@Override
	public Endereco buscaPorIdEndereco(String pessoa, UUID idEndereco) {
		return null;
	}

	@Override
	public List<EnderecoListResponse> buscaTodosEnderecos(UUID idPessoa) {
		log.info("[inicia] - EnderecoApplicationService - buscaTodosEnderecos");
		List<Endereco> endereco = enderecoRepository.buscaEnderecos();
		log.info("[inicia] - EnderecoApplicationService - buscaTodosEnderecos");
		return EnderecoListResponse.converte(endereco);
	}

}
