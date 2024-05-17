package io.gupy.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Value;

@Value

public class PessoaNovoRequest {
	@NotBlank
	private String nome;
	@NotNull
	private LocalDate data;
	@NotNull
	List<EnderecoRequest> endereco;
}
