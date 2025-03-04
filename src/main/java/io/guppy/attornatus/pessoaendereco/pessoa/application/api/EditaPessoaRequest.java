package io.guppy.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class EditaPessoaRequest {
	private String nomePessoa;
	private LocalDate dataNascimento;
	private EnderecoRequest endereco;
}
