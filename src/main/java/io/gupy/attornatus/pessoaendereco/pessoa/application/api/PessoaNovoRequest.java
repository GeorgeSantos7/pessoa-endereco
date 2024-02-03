package io.gupy.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDate;

import io.gupy.attornatus.pessoaendereco.pessoa.domain.Sexo;
import lombok.Value;

@Value
public class PessoaNovoRequest {
	private String nome;
	private LocalDate data;
	private Sexo sexo;
}
