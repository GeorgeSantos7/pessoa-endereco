package io.gupy.attornatus.pessoaendereco.pessoa.application.service;

import io.gupy.attornatus.pessoaendereco.pessoa.application.api.PessoaCriadoResponse;
import io.gupy.attornatus.pessoaendereco.pessoa.application.api.PessoaNovoRequest;

public interface PessoaService {

	PessoaCriadoResponse criaNovoUsuario(PessoaNovoRequest novaPessoa);
}
