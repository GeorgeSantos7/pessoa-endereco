package io.gupy.attornatus.pessoaendereco.endereco.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import io.gupy.attornatus.pessoaendereco.endereco.application.api.EnderecoIdResponse;
import io.gupy.attornatus.pessoaendereco.endereco.application.api.EnderecoListResponse;
import io.gupy.attornatus.pessoaendereco.endereco.application.api.EnderecoRequest;
import io.gupy.attornatus.pessoaendereco.endereco.domain.Endereco;

public interface EnderecoService {
	Endereco buscaPorIdEndereco(String pessoa, UUID idEndereco);
	EnderecoIdResponse criaEndereco(UUID idPessoa, @Valid EnderecoRequest enderecoRequest);
	List<EnderecoListResponse> buscaTodosEnderecos(UUID idPessoa);

}
