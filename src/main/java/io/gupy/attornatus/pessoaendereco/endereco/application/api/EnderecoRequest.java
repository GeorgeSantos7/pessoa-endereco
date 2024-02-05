package io.gupy.attornatus.pessoaendereco.endereco.application.api;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import io.gupy.attornatus.pessoaendereco.endereco.domain.StatusEndereco;
import lombok.NonNull;
import lombok.Value;
@Value
public class EnderecoRequest {
	private UUID idEndereco;
	@NotBlank
	private Integer cep;
	@NotBlank
	private String cidade;
	@NonNull
	private Integer numero;
	private String logradouro;
	private StatusEndereco status;

}
