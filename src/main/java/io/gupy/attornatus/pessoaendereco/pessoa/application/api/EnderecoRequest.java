package io.gupy.attornatus.pessoaendereco.pessoa.application.api;

import lombok.Value;

@Value
public class EnderecoRequest {
	private String logradouro;
    private long cep;
    private int numero;
    private String cidade;


}
