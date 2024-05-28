package io.guppy.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDate;

import lombok.Value;
@Value
public class PessoaRequest {
	private String nomePessoa;
	private LocalDate dataNascimento;
	private EnderecoRequest endereco;
}
