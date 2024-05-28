package io.guppy.attornatus.pessoaendereco.pessoa.domain;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.guppy.attornatus.pessoaendereco.pessoa.application.api.EditaPessoaRequest;
import io.guppy.attornatus.pessoaendereco.pessoa.application.api.PessoaRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "pessoas")
public class Pessoa {
	@Id
	private UUID idPessoa;
	@NotBlank
	private String nomePessoa;
	@NotNull
	private LocalDate dataNascimento;
	private Endereco endereco;

	public Pessoa(PessoaRequest novaPessoa) {
		this.idPessoa = UUID.randomUUID();
		this.nomePessoa = novaPessoa.getNomePessoa();
		this.dataNascimento = novaPessoa.getDataNascimento();
		 this.endereco = new Endereco(novaPessoa.getEndereco());
	}

	public void altera(EditaPessoaRequest editaPessoaRequest) {
		this.nomePessoa = editaPessoaRequest.getNomePessoa();
		this.dataNascimento = editaPessoaRequest.getDataNascimento();
	}
}
