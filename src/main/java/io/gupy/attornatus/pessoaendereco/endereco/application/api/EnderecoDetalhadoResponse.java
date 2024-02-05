package io.gupy.attornatus.pessoaendereco.endereco.application.api;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.gupy.attornatus.pessoaendereco.endereco.domain.StatusEndereco;
import lombok.NonNull;
import lombok.Value;
@Value
public class EnderecoDetalhadoResponse {
	private UUID idEndereco;
	@NotBlank
	private Integer cep;
	@NotBlank
	private String cidade;
	@NotNull
	private UUID idPessoa;
	@NonNull
	private Integer numero;
	private String logradouro;
	@NotBlank
	private StatusEndereco status;

}
