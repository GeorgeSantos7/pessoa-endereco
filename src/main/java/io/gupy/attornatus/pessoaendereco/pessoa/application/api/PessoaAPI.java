package io.gupy.attornatus.pessoaendereco.pessoa.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.gupy.attornatus.pessoaendereco.pessoa.domain.Pessoa;

@RestController
@RequestMapping(value = "/v1/pessoa")
public interface PessoaAPI {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	PessoaCriadoResponse postNovaPessoa(@RequestBody @Valid PessoaNovoRequest pessoaNovoRequest);
	
	@GetMapping(value = "/{idPessoa}")
	@ResponseStatus(code = HttpStatus.OK)
	Pessoa buscaPessoaPorId(@PathVariable UUID idPessoa);
	
	@PatchMapping(value = "/edita-pessoa/{idPessoa}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void editaPessoa(@PathVariable UUID idPessoa,
			@RequestBody @Valid EditaPessoaRequest pessoaNovoRequest);
	
	@GetMapping(value = "/todas-pessoas")
	@ResponseStatus(code = HttpStatus.OK)
	List<PessoaListRespose> getTodasPessoas();

	
}
