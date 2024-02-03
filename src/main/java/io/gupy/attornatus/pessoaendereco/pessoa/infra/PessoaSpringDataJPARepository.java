package io.gupy.attornatus.pessoaendereco.pessoa.infra;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.gupy.attornatus.pessoaendereco.pessoa.domain.Pessoa;

public interface PessoaSpringDataJPARepository extends JpaRepository<Pessoa, UUID>  {

	Optional<Pessoa> findByIdPessoa(UUID idPessoa);

}
