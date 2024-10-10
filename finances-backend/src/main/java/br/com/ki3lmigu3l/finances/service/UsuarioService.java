package br.com.ki3lmigu3l.finances.service;

import br.com.ki3lmigu3l.finances.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    Usuario createUsuario(Usuario usuario);
    Optional<Usuario> findUserById(Long id);

    List<Usuario> findAllUsers();
}
