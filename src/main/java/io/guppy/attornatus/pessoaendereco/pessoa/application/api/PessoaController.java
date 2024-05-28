package io.guppy.attornatus.pessoaendereco.pessoa.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import io.guppy.attornatus.pessoaendereco.pessoa.application.service.PessoaService;
import io.guppy.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Log4j2
@RequiredArgsConstructor
@RestController
public class PessoaController implements PessoaAPI {

	private final PessoaService pessoaService;

	@Override
	public PessoaResponse postPessoa(PessoaRequest novaPessoa) {
		log.info("[inicia] PessoaController - postPessoa");
		log.info("[PessoaController] {}", novaPessoa);
		PessoaResponse pessoaCriada = pessoaService.criaNovoUsuario(novaPessoa);
		log.info("[finaliza] PessoaController - postPessoa");
		return pessoaCriada;
	}

	@Override
	public Pessoa buscaPessoaPorId(UUID idPessoa) {
		log.info("[inicia] PessoaController - buscaUsuarioPorId");
		log.info("[idUsuario] {}", idPessoa);
		Pessoa buscaPessoa = pessoaService.buscaUsuarioPorId(idPessoa);
		log.info("[finaliza] PessoaController - buscaUsuarioPorId");
		return buscaPessoa;
	}

	@Override
	public void editaPessoa(UUID idPessoa, @Valid EditaPessoaRequest editaPessoaRequest) {
		log.info("[inicia] PessoaController - editaPessoa");
		pessoaService.editaPessoa(idPessoa, editaPessoaRequest);
		log.info("[finaliza] PessoaController - editaPessoa");
		
	}

}
