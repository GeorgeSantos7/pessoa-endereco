package io.gupy.attornatus.pessoaendereco.pessoa.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Pessoa {
	
	private UUID idPessoa;
	@NotBlank
	private String nome;
	private LocalDate data;
    
    private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraDaUltimaAlteracao;
}
