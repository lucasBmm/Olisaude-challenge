package br.com.olisaude.challenge.domain.cliente;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record ClienteRecord(
		@NotBlank
		String nome,
		@NotBlank
		Date dataNascimento,
		@NotBlank
		Character genero,
		@NotBlank
		List<ProblemaSaudeRecord> problemaSaude
) {}
