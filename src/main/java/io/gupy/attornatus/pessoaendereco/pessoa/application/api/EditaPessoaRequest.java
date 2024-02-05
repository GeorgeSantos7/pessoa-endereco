package io.gupy.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.gupy.attornatus.pessoaendereco.endereco.application.api.EnderecoRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EditaPessoaRequest {
	@NotBlank
	private String nome;
	@NotNull
	private LocalDate data;
	@NonNull
	private EnderecoRequest endereco;
}
