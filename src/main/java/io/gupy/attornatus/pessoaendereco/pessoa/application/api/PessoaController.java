package io.gupy.attornatus.pessoaendereco.pessoa.application.api;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
@Log4j2
public class PessoaController implements PessoaAPI {

	@Override
	public PessoaCriadoResponse postNovaPessoa(@Valid PessoaNovoRequest novaPessoa) {
		log.info("[inicia] PessoaController - postNovaPessoa");
		log.info("[finaliza] PessoaController - postNovaPessoa");
		return null;
	}

}
