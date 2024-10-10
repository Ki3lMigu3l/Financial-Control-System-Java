package br.com.ki3lmigu3l.finances.service;

import br.com.ki3lmigu3l.finances.dto.CategoriaRequestDTO;
import br.com.ki3lmigu3l.finances.model.Categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> getAllCategoriasByUser (Long userId);
    Categoria createCategoria (CategoriaRequestDTO categoriaRequestDTO);

    List<Categoria> getAllCategorias ();

}
