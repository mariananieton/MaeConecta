package br.com.fiap.MaeConecta.repository;

import br.com.fiap.MaeConecta.model.OcorrenciaGestacional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OcorrenciaGestacionalRepository extends JpaRepository<OcorrenciaGestacional, Long> {

	List<OcorrenciaGestacional> findAllByUsuarioId(Long userId);
}
