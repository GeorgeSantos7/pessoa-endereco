package io.gupy.attornatus.pessoaendereco.pessoa.application.repository;

import java.util.UUID;

import io.gupy.attornatus.pessoaendereco.pessoa.domain.Pessoa;

public interface PessoaRepository {

	Pessoa salva(Pessoa pessoa);
	Pessoa buscaUsuarioPorId(UUID idPessoa);

}
