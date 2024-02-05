package io.gupy.attornatus.pessoaendereco.pessoa.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.gupy.attornatus.pessoaendereco.pessoa.domain.Pessoa;

public interface PessoaSpringDataJPARepository extends JpaRepository<Pessoa, UUID>  {

	Pessoa findByIdPessoa(UUID idPessoa);

}
