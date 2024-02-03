package io.gupy.attornatus.pessoaendereco.pessoa.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import io.gupy.attornatus.pessoaendereco.pessoa.application.api.PessoaNovoRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Pessoa {
	@Id
	private UUID idPessoa;
	@NotBlank
	private String nome;
	private Sexo sexo;
	private LocalDate data;
    
    private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraDaUltimaAlteracao;
	
	
	public Pessoa(@javax.validation.Valid PessoaNovoRequest pessoaNovoRequest) {
		this.idPessoa = UUID.randomUUID();
		this.nome = pessoaNovoRequest.getNome();
		this.sexo = pessoaNovoRequest.getSexo();
	}
}
