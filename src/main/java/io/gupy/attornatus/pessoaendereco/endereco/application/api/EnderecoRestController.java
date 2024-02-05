package io.gupy.attornatus.pessoaendereco.endereco.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import io.gupy.attornatus.pessoaendereco.endereco.application.service.EnderecoService;
import io.gupy.attornatus.pessoaendereco.pessoa.application.repository.PessoaRepository;
import io.gupy.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@RestController
@Log4j2
@RequiredArgsConstructor
public class EnderecoRestController implements EnderecoAPI {

	private final EnderecoService enderecoService;
	private final PessoaRepository pessoaRepository;

	@Override
	public EnderecoIdResponse postNovaTarefa(UUID idPessoa, @Valid EnderecoRequest enderecoRequest) {
		log.info("[inicia] - EnderecoRestController - postNovaTarefa");
		EnderecoIdResponse enderecoCriado = enderecoService.criaEndereco(idPessoa, enderecoRequest);
		log.info("[finaliza] - EnderecoRestController - postNovaTarefa");
		return enderecoCriado;
	}

	@Override
	public void alteraEnderecoPorId(UUID idPessoa, UUID idEndereco) {
		log.info("[inicia] - EnderecoRestController - alteraEnderecoPorId");
		Pessoa pessoa = pessoaRepository.buscaUsuarioPorId(idPessoa);
		pessoa.marcaEnderecoComoPrincipal(idEndereco);
		this.pessoaRepository.salva(pessoa);
		log.info("[finaliza] - EnderecoRestController - alteraEnderecoPorId");
	}

	@Override
	public List<EnderecoListResponse> getTodosEnderecos(UUID idPessoa) {
		log.info("[inicia] - EnderecoRestController - getTodosEnderecos");
		List<EnderecoListResponse> endereco = enderecoService.buscaTodosEnderecos(idPessoa);
		log.info("[finaliza] - EnderecoRestController - getTodosEnderecos");
		return endereco;
	}

}
