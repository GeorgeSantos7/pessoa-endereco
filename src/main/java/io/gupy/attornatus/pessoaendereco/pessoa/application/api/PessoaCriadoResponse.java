package io.gupy.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDate;

import lombok.Value;

@Value
public class PessoaCriadoResponse {
	private String nome;
	private LocalDate data;
}
