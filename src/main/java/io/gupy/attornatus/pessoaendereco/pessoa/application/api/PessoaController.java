package io.gupy.attornatus.pessoaendereco.pessoa.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.gupy.attornatus.pessoaendereco.pessoa.application.service.PessoaService;
import io.gupy.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@RestController
public class PessoaController implements PessoaAPI {

	private final PessoaService pessoaService;

	@PostMapping
	@Override
	public PessoaCriadoResponse postNovaPessoa(@Valid PessoaNovoRequest pessoaNovoRequest) {
		log.info("[inicia] PessoaController - postNovaPessoa");
		PessoaCriadoResponse pessoaCriada = pessoaService.criaNovoUsuario(pessoaNovoRequest);
		log.info("[finaliza] PessoaController - postNovaPessoa");
		return pessoaCriada;
	}

	@Override
	public Pessoa buscaPessoaPorId(UUID idPessoa) {
		log.info("[inicia] PessoaController - buscaUsuarioPorId");
		Pessoa buscaPessoa = pessoaService.buscaUsuarioPorId(idPessoa);
		log.info("[finaliza] PessoaController - buscaUsuarioPorId");
		return buscaPessoa;
	}

	@Override
	public void editaPessoa(UUID idPessoa, @Valid EditaPessoaRequest pessoaNovoRequest) {
		log.info("[inicia] PessoaController - editaPessoa");
		pessoaService.editaPessoa(idPessoa, pessoaNovoRequest);
		log.info("[finaliza] PessoaController - editaPessoa");
	}

	@Override
	public List<PessoaListRespose> getTodasPessoas() {
		log.info("[inicia] - PessoaController - getTodasPessoas");
		List<PessoaListRespose> pessoa = pessoaService.buscaTodosClientes();
		log.info("[finaliza] - PessoaController - getTodasPessoas");
		return pessoa;
	}

}
