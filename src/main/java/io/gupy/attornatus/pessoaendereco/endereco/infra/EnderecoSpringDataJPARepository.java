package io.gupy.attornatus.pessoaendereco.endereco.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.gupy.attornatus.pessoaendereco.endereco.domain.Endereco;

public interface EnderecoSpringDataJPARepository extends JpaRepository<Endereco, UUID> {

}
