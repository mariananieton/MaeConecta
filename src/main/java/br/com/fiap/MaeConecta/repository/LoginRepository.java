package br.com.fiap.MaeConecta.repository;

import br.com.fiap.MaeConecta.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {

	Optional<Login> findByEmail(String email);
}
