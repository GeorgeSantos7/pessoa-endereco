package io.gupy.attornatus.pessoaendereco.pessoa.application.service;

import java.util.UUID;

import javax.validation.Valid;

import io.gupy.attornatus.pessoaendereco.pessoa.application.api.PessoaCriadoResponse;
import io.gupy.attornatus.pessoaendereco.pessoa.application.api.PessoaNovoRequest;

public interface PessoaService {

	PessoaCriadoResponse criaNovoUsuario(@Valid PessoaNovoRequest novaPessoa);

	PessoaCriadoResponse buscaUsuarioPorId(UUID idPessoa);

}
