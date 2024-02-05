package io.gupy.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import io.gupy.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.Value;

@Value
public class PessoaListRespose {
	private UUID idPessoa;
    private String nome;
    private LocalDate data;
	public static List<PessoaListRespose> converte(List<Pessoa> pessoa) {
		return pessoa.stream()
				.map(PessoaListRespose::new)
				.collect(Collectors.toList());
	}
	public PessoaListRespose(Pessoa pessoa) {
		this.idPessoa = pessoa.getIdPessoa();
		this.nome = pessoa.getNome();
		this.data = pessoa.getData();
	}
	
}
