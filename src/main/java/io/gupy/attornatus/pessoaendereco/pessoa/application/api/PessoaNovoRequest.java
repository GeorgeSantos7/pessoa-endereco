package io.gupy.attornatus.pessoaendereco.pessoa.application.api;

import java.util.UUID;

import lombok.Value;

@Value
public class PessoaNovoRequest {
	private UUID idPessoa;
}
