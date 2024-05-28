package io.guppy.attornatus.pessoaendereco.pessoa.domain;

import java.util.UUID;

import org.springframework.data.annotation.Id;

import io.guppy.attornatus.pessoaendereco.pessoa.application.api.EnderecoRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Endereco {
	@Id
	private UUID idEndereco;
	private StatusEndereco status;
	@NotBlank
	private String logradouro;
	@NotBlank
	private String cep;
	@NotBlank
	private int numero;
	@NotBlank
	private String cidade;
	
	public Endereco(EnderecoRequest enderecoRequest) {
	    this.idEndereco = UUID.randomUUID();
	    this.logradouro = enderecoRequest.getLogradouro();
	    this.cep = enderecoRequest.getCep();
	    this.numero = enderecoRequest.getNumero();
	    this.cidade = enderecoRequest.getCidade();
	    this.status = StatusEndereco.PRINCIPAL;
	}
}
