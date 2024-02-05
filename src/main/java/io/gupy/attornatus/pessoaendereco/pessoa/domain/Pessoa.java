package io.gupy.attornatus.pessoaendereco.pessoa.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import io.gupy.attornatus.pessoaendereco.endereco.domain.Endereco;
import io.gupy.attornatus.pessoaendereco.endereco.domain.StatusEndereco;
import io.gupy.attornatus.pessoaendereco.pessoa.application.api.EditaPessoaRequest;
import io.gupy.attornatus.pessoaendereco.pessoa.application.api.PessoaNovoRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Pessoa {
	@Id
	@Column(name = "idPessoa", insertable = false, updatable = false)
	private UUID idPessoa;
	@NotBlank
	private String nome;
	private LocalDate data;
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private List<Endereco> endereco;

	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraDaUltimaAlteracao;

	public Pessoa(@Valid PessoaNovoRequest pessoaNovoRequest) {
		this.idPessoa = UUID.randomUUID();
		this.nome = pessoaNovoRequest.getNome();

		Endereco novoEndereco = new Endereco(pessoaNovoRequest.getEndereco());
		novoEndereco.setStatus(StatusEndereco.PRINCIPAL);
		this.endereco = new ArrayList<>();
		this.endereco.add(novoEndereco);
	}

	public void edita(@Valid EditaPessoaRequest pessoaNovoRequest) {
		this.nome = pessoaNovoRequest.getNome();
		this.data = pessoaNovoRequest.getData();
	}

	public void addEndereco(Endereco endereco) {
		this.addEndereco(endereco);

	}

	public void marcaEnderecoComoPrincipal(UUID idEndereco) {
		Endereco enderecoParaMarcarComoPrincipal = null;
		for (Endereco endereco : this.endereco) {
			if (endereco.getIdEndereco().equals(idEndereco)) {
				enderecoParaMarcarComoPrincipal = endereco;
				break;
			}
		}
		if (enderecoParaMarcarComoPrincipal == null) {
			throw new RuntimeException("endereço nao pertece ao usuario");
		}
		for (Endereco endereco : this.endereco) {
			endereco.setStatus(StatusEndereco.SECUNDARIO);
		}

		enderecoParaMarcarComoPrincipal.setStatus(StatusEndereco.PRINCIPAL);

	}
}
