package io.gupy.attornatus.pessoaendereco.pessoa.domain;

import java.util.List;
import java.util.UUID;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import io.gupy.attornatus.pessoaendereco.pessoa.application.api.EnderecoRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Endereco {


	@NotBlank(message = "Logradouro é obrigatório")
	private String logradouro;

	@NotBlank(message = "CEP é obrigatório")
	private long cep;

	@NotBlank(message = "Número é obrigatório")
	private int numero;

	@NotBlank(message = "Cidade é obrigatória")
	private String cidade;
	


	public Endereco(List<EnderecoRequest> enderecoRequest, UUID idPessoa) {
		this.logradouro = getLogradouro();
		this.cep = getCep();
		this.numero = getNumero();
		this.cidade = getCidade();
		
	}
}
