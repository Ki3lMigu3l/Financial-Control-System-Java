package br.com.ki3lmigu3l.finances.service.impl;

import br.com.ki3lmigu3l.finances.dto.CategoriaRequestDTO;
import br.com.ki3lmigu3l.finances.model.Categoria;
import br.com.ki3lmigu3l.finances.model.Usuario;
import br.com.ki3lmigu3l.finances.repository.CategoriaRepository;
import br.com.ki3lmigu3l.finances.service.CategoriaService;
import br.com.ki3lmigu3l.finances.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UsuarioService usuarioService;


    @Override
    public List<Categoria> getAllCategoriasByUser (Long userId) {
        Usuario usuario = usuarioService.findUserById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return categoriaRepository.findByUsuario(usuario);
    }

    @Override
    public Categoria createCategoria(CategoriaRequestDTO categoriaRequestDTO) {
        Usuario usuario = usuarioService.findUserById(categoriaRequestDTO.userId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Categoria categoria = new Categoria(categoriaRequestDTO.nome(), usuario);
        return categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }
}
