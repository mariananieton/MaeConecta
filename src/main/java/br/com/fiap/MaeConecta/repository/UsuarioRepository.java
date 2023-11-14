package br.com.fiap.MaeConecta.repository;

import br.com.fiap.MaeConecta.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
