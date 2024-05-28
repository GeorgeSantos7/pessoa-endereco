package io.guppy.attornatus.pessoaendereco.pessoa.application.repository;

import java.util.UUID;

import io.guppy.attornatus.pessoaendereco.pessoa.domain.Pessoa;

public interface PessoaRepository {

	Pessoa salva(Pessoa pessoa);
	Pessoa buscaUsuarioPorId(UUID idPessoa);
}
