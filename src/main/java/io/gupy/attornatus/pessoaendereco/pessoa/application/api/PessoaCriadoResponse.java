package io.gupy.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.gupy.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.Value;

@Value
public class PessoaCriadoResponse {
	@Id
	private final UUID idPessoa;
	@NotBlank
	private final String nome;
	@NotNull
	private final LocalDate data;
	final List<EnderecoRequest> endereco;

	public PessoaCriadoResponse(@Valid Pessoa pessoa) {

		this.idPessoa = pessoa.getIdPessoa();
		this.nome = pessoa.getNome();
		this.data = pessoa.getData();
		this.endereco = pessoa.getEndereco();
	}
}
