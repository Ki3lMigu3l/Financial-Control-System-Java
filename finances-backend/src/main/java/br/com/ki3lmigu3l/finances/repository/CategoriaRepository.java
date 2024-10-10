package br.com.ki3lmigu3l.finances.repository;

import br.com.ki3lmigu3l.finances.model.Categoria;
import br.com.ki3lmigu3l.finances.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByUsuario(Usuario usuario);
}
