package io.gupy.attornatus.pessoaendereco.endereco.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import io.gupy.attornatus.pessoaendereco.endereco.application.api.EnderecoRequest;
import io.gupy.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
public class Endereco {
	@Id
	private UUID idEndereco;
	@NotBlank
	private Integer cep;
	@NotBlank
	private String cidade;
	@NotBlank
	private Integer numero;
	private String logradouro;
	@NotBlank
	private StatusEndereco status;
	@ManyToOne
	@JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
	private Pessoa pessoa;

	public Endereco(@Valid EnderecoRequest enderecoRequest) {
		this.idEndereco = enderecoRequest.getIdEndereco();
		this.cep = enderecoRequest.getCep();
		this.cidade = enderecoRequest.getCidade();
		this.numero = enderecoRequest.getNumero();
		this.logradouro = enderecoRequest.getLogradouro();
		this.status = StatusEndereco.PRINCIPAL;
	}
}
