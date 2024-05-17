package io.gupy.attornatus.pessoaendereco.pessoa.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.gupy.attornatus.pessoaendereco.pessoa.application.api.EnderecoRequest;
import io.gupy.attornatus.pessoaendereco.pessoa.application.api.PessoaNovoRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Pessoa {
	@Id
	private UUID idPessoa;
	@NotBlank
	private String nome;
	@NotNull
	private LocalDate data;
	@Embedded
	List<EnderecoRequest> endereco = new ArrayList<>();

	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraDaUltimaAlteracao;

	public Pessoa(PessoaNovoRequest novaPessoa) {
		this.idPessoa = UUID.randomUUID();
		this.nome = novaPessoa.getNome();
		this.data = novaPessoa.getData();
		this.endereco = novaPessoa.getEndereco();
	}
}
