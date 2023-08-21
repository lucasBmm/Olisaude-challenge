package br.com.olisaude.challenge.domain.cliente;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cliente")
public class ClienteEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private Date dataNascimento;

    @Column(name = "genero", nullable = false)
    private char genero;

    @Column(name = "problema_saude", nullable = false)
    @ManyToMany
    private List<ProblemaSaudeEntity> problemasSaude;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;
    
    @PrePersist
    public void prePersist() {
        this.setDataCriacao(LocalDateTime.now());
        this.setDataAtualizacao(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate() {
        this.setDataAtualizacao(LocalDateTime.now());
    }

    public ClienteEntity() {}
    
    public ClienteEntity(ClienteRecord cliente) {
    	this.nome = cliente.nome();
        this.dataNascimento = cliente.dataNascimento();
        this.genero = cliente.genero();
        this.problemasSaude = cliente.problemaSaude().stream().map(ProblemaSaudeEntity::new).toList();
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public List<ProblemaSaudeEntity> getProblemasSaude() {
		return problemasSaude;
	}

	public void setProblemaSaude(List<ProblemaSaudeEntity> problemasSaude) {
		this.problemasSaude = problemasSaude;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
}
