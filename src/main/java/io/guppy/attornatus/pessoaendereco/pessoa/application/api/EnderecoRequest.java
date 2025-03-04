package io.guppy.attornatus.pessoaendereco.pessoa.application.api;

import io.guppy.attornatus.pessoaendereco.pessoa.domain.StatusEndereco;
import lombok.Value;

@Value
public class EnderecoRequest {
	private StatusEndereco status;
	private String logradouro;
	private String cep;
	private int numero;
	private String cidade;
}
