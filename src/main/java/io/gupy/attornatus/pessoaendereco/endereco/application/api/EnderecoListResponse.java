package io.gupy.attornatus.pessoaendereco.endereco.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import io.gupy.attornatus.pessoaendereco.endereco.domain.Endereco;
import io.gupy.attornatus.pessoaendereco.endereco.domain.StatusEndereco;
import lombok.NonNull;
import lombok.Value;
@Value
public class EnderecoListResponse {
	private UUID idEndereco;
	@NotBlank
	private Integer cep;
	@NotBlank
	private String cidade;
	@NonNull
	private Integer numero;
	private String logradouro;
	private StatusEndereco status;
	public static List<EnderecoListResponse> converte(List<Endereco> endereco) {
		return endereco.stream()
				.map(EnderecoListResponse::new)
				.collect(Collectors.toList());
	}
	public EnderecoListResponse(Endereco endereco) {
		this.idEndereco = endereco.getIdEndereco();
		this.cep = endereco.getCep();
		this.cidade = endereco.getCidade();
		this.numero = endereco.getNumero();
		this.logradouro = endereco.getLogradouro();
		this.status = endereco.getStatus();
	}
}
