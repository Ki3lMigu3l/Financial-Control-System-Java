package br.com.ki3lmigu3l.finances.service.impl;

import br.com.ki3lmigu3l.finances.model.Categoria;
import br.com.ki3lmigu3l.finances.model.Usuario;
import br.com.ki3lmigu3l.finances.model.enums.CategoriaPadrao;
import br.com.ki3lmigu3l.finances.repository.CategoriaRepository;
import br.com.ki3lmigu3l.finances.repository.UsuarioRepository;
import br.com.ki3lmigu3l.finances.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Usuario createUsuario(Usuario usuario) {
        Usuario newUser = usuarioRepository.save(usuario);

        for (CategoriaPadrao categoriasPadrao : CategoriaPadrao.values()) {
            Categoria categoria = new Categoria(categoriasPadrao);
            categoria.setUsuario(newUser);
            categoriaRepository.save(categoria);
        }

        return newUser;
    }

    @Override
    public Optional<Usuario> findUserById(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado!");
        }
        return usuarioOptional;
    }

    @Override
    public List<Usuario> findAllUsers() {
        return usuarioRepository.findAll();
    }
}
