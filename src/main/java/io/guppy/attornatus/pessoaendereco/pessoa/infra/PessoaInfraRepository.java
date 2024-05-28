package io.guppy.attornatus.pessoaendereco.pessoa.infra;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import io.guppy.attornatus.pessoaendereco.pessoa.application.repository.PessoaRepository;
import io.guppy.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Repository
@Log4j2
@RequiredArgsConstructor
public class PessoaInfraRepository implements PessoaRepository {

	private final PessoaSpringDataJPARepository pessoaSpringDataJPARepository;

	@Override
	public Pessoa salva(Pessoa pessoa) {
		log.info("[inicia] PessoaInfraRepository - salva");
		Pessoa novaPessoa = pessoaSpringDataJPARepository.save(pessoa);
		log.info("[finaliza] PessoaInfraRepository - salva");
		return novaPessoa;
	}

	@Override
	public Pessoa buscaUsuarioPorId(UUID idPessoa) {
		log.info("[inicia] PessoaInfraRepository - buscaUsuarioPorId");
		Pessoa pessoa = pessoaSpringDataJPARepository.findByIdPessoa(idPessoa);
		log.info("[finalzia] PessoaInfraRepository - buscaUsuarioPorId");
		return pessoa;
	}
}
