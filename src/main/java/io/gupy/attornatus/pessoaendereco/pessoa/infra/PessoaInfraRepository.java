package io.gupy.attornatus.pessoaendereco.pessoa.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import io.gupy.attornatus.pessoaendereco.pessoa.application.repository.PessoaRepository;
import io.gupy.attornatus.pessoaendereco.pessoa.domain.Pessoa;
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
	public Pessoa  buscaUsuarioPorId(UUID idPessoa) {
		log.info("[inicia] PessoaInfraRepository - buscaUsuarioPorId");
		Pessoa pessoaPorId = pessoaSpringDataJPARepository.findByIdPessoa(idPessoa);
		log.info("[finalzia] PessoaInfraRepository - buscaUsuarioPorId");
		return pessoaPorId;
	}

	@Override
	public List<Pessoa> buscaTodasPessoas() {
		log.info("[inicia] - PessoaInfraRepository - buscaTodasGalinhas");
		List<Pessoa> todasPessoas = pessoaSpringDataJPARepository.findAll();
		log.info("[finaliza] - PessoaInfraRepository - buscaTodasGalinhas");
		return todasPessoas;
	}

}
