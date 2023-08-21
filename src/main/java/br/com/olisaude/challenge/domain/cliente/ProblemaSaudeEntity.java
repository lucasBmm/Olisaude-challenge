package br.com.olisaude.challenge.domain.cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "problema_saude")
public class ProblemaSaudeEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
    private String nome;

	@Column(nullable = false)
    private Integer grau;
	
	public ProblemaSaudeEntity() {}
	
	public ProblemaSaudeEntity(ProblemaSaudeRecord problemaSaude) {
		this.nome = problemaSaude.nome();
		this.grau = problemaSaude.grau();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getGrau() {
		return grau;
	}

	public void setGrau(Integer grau) {
		this.grau = grau;
	}
}
