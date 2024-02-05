package io.gupy.attornatus.pessoaendereco.endereco.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/v1/endereco")
public interface EnderecoAPI {
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	EnderecoIdResponse postNovaTarefa(UUID idPessoa, @RequestBody @Valid EnderecoRequest enderecoRequest);
	
	@PatchMapping(value = "/endereco-como-principal/{idEndereco}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void alteraEnderecoPorId(UUID idPessoa, UUID idEndereco);
	
	@GetMapping(value = "/todos-enderecos/{idPessoa}")
	@ResponseStatus(code = HttpStatus.OK)
	List<EnderecoListResponse> getTodosEnderecos(UUID idPessoa);
	}
