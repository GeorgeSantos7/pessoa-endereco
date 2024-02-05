package io.gupy.attornatus.pessoaendereco.pessoa.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import io.gupy.attornatus.pessoaendereco.pessoa.application.api.EditaPessoaRequest;
import io.gupy.attornatus.pessoaendereco.pessoa.application.api.PessoaCriadoResponse;
import io.gupy.attornatus.pessoaendereco.pessoa.application.api.PessoaListRespose;
import io.gupy.attornatus.pessoaendereco.pessoa.application.api.PessoaNovoRequest;
import io.gupy.attornatus.pessoaendereco.pessoa.domain.Pessoa;

public interface PessoaService {

	PessoaCriadoResponse criaNovoUsuario(@Valid PessoaNovoRequest novaPessoa);
	Pessoa buscaUsuarioPorId(UUID idPessoa);
	void editaPessoa(UUID idPessoa, @Valid EditaPessoaRequest pessoaNovoRequest);
	List<PessoaListRespose> buscaTodosClientes();

}
