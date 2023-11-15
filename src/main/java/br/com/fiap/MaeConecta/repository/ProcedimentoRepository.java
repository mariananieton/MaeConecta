package br.com.fiap.MaeConecta.repository;

import br.com.fiap.MaeConecta.model.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long> {

	List<Procedimento> findAllByUsuarioId(Long userId);
}
