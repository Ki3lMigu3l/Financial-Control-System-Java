package br.com.ki3lmigu3l.finances.repository;

import br.com.ki3lmigu3l.finances.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
