package io.guppy.attornatus.pessoaendereco.pessoa.infra;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.guppy.attornatus.pessoaendereco.pessoa.domain.Pessoa;

public interface PessoaSpringDataJPARepository extends MongoRepository<Pessoa, UUID>{

	Pessoa findByIdPessoa(UUID idPessoa);

}
