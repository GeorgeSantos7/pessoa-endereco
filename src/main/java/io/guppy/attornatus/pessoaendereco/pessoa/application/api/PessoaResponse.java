package io.guppy.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDate;
import java.util.UUID;

import io.guppy.attornatus.pessoaendereco.pessoa.domain.Endereco;
import io.guppy.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.Data;
@Data
public class PessoaResponse {
	private UUID idPessoa;
	private String nomePessoa;
	private LocalDate dataNascimento;
	private Endereco endereco;
	
	public PessoaResponse(Pessoa pessoa) {
		this.idPessoa = pessoa.getIdPessoa();
		this.nomePessoa = pessoa.getNomePessoa();
		this.dataNascimento = pessoa.getDataNascimento();
		this.endereco = pessoa.getEndereco();
	}
}
