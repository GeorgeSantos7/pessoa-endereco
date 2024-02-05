package io.gupy.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.gupy.attornatus.pessoaendereco.endereco.application.api.EnderecoRequest;
import lombok.Value;

@Value
public class PessoaNovoRequest {
	@NotBlank
	private String nome;
	@NotNull
	private LocalDate data;
	@NotNull
	private EnderecoRequest endereco;
}
