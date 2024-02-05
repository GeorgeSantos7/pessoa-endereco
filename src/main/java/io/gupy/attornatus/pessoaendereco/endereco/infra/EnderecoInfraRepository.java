package io.gupy.attornatus.pessoaendereco.endereco.infra;

import java.util.List;

import org.springframework.stereotype.Repository;

import io.gupy.attornatus.pessoaendereco.endereco.application.repository.EnderecoRepository;
import io.gupy.attornatus.pessoaendereco.endereco.domain.Endereco;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@RequiredArgsConstructor
@Log4j2
@Repository
public class EnderecoInfraRepository implements EnderecoRepository {

	private final EnderecoSpringDataJPARepository enderecoSpringDataJPARepository;

	@Override
	public Endereco salva(Endereco endereco) {
		log.info("[inicia] - EnderecoInfraRepository - salva");
		enderecoSpringDataJPARepository.save(endereco);
		log.info("[finaliza] - EnderecoInfraRepository - salva");
		return endereco;
	}

	@Override
	public List<Endereco> buscaEnderecos() {
		log.info("[inicia] - EnderecoInfraRepository - buscaEnderecos");
		List<Endereco> todosEnderecos = enderecoSpringDataJPARepository.findAll();
		log.info("[finaliza] - EnderecoInfraRepository - buscaEnderecos");
		return todosEnderecos;
	}

}
