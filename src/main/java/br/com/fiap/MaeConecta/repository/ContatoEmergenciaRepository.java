package br.com.fiap.MaeConecta.repository;

import br.com.fiap.MaeConecta.model.ContatoEmergencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContatoEmergenciaRepository extends JpaRepository<ContatoEmergencia, Long> {

	List<ContatoEmergencia> findAllByUsuarioId(Long userId);
}
