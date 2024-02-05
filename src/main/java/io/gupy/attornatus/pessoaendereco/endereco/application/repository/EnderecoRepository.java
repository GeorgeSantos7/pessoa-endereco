package io.gupy.attornatus.pessoaendereco.endereco.application.repository;

import java.util.List;

import io.gupy.attornatus.pessoaendereco.endereco.domain.Endereco;

public interface EnderecoRepository {
	Endereco salva(Endereco endereco);
	List<Endereco> buscaEnderecos();

}
