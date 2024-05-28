package io.guppy.attornatus.pessoaendereco.pessoa.application.api;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.guppy.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/v1/pessoa")
public interface PessoaAPI {
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	PessoaResponse postPessoa(@RequestBody @Valid PessoaRequest novaPessoa);

	@GetMapping(value = "/{idPessoa}")
	@ResponseStatus(code = HttpStatus.OK)
	Pessoa buscaPessoaPorId(@PathVariable UUID idPessoa);

	@PatchMapping("/editaPessoa/{idPessoa}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void editaPessoa(@PathVariable UUID idPessoa, @RequestBody @Valid EditaPessoaRequest editaPessoaRequest);
	
	@PostMapping("/{idPessoa}/endereco")
	@ResponseStatus(code = HttpStatus.CREATED)
	PessoaResponse adcionaNovoEndereco(@PathVariable UUID idPessoa,
			@RequestBody @Valid EnderecoRequest enderecoRequest);
}
