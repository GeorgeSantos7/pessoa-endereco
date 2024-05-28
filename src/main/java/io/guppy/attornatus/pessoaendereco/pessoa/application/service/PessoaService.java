package io.guppy.attornatus.pessoaendereco.pessoa.application.service;

import java.util.List;
import java.util.UUID;

import io.guppy.attornatus.pessoaendereco.pessoa.application.api.EditaPessoaRequest;
import io.guppy.attornatus.pessoaendereco.pessoa.application.api.EnderecoRequest;
import io.guppy.attornatus.pessoaendereco.pessoa.application.api.PessoaListResponse;
import io.guppy.attornatus.pessoaendereco.pessoa.application.api.PessoaRequest;
import io.guppy.attornatus.pessoaendereco.pessoa.application.api.PessoaResponse;
import io.guppy.attornatus.pessoaendereco.pessoa.domain.Pessoa;

public interface PessoaService {

	PessoaResponse criaNovoUsuario(PessoaRequest novaPessoa);
	Pessoa buscaUsuarioPorId(UUID idPessoa);
	void editaPessoa(UUID idPessoa, EditaPessoaRequest editaPessoaRequest);
	Pessoa adicionaNovoEnderecoPessoa(UUID idPessoa,  EnderecoRequest enderecoRequest);
	List<PessoaListResponse> buscaTodasPessoas();

}
