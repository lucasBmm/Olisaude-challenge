package br.com.olisaude.challenge.domain.cliente;

import jakarta.validation.constraints.NotBlank;

public record ProblemaSaudeRecord(
		@NotBlank
		String nome,
		@NotBlank
		Integer grau
) {}
