package br.com.ki3lmigu3l.finances.controller;

import br.com.ki3lmigu3l.finances.dto.CategoriaRequestDTO;
import br.com.ki3lmigu3l.finances.model.Categoria;
import br.com.ki3lmigu3l.finances.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategoria () {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.getAllCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Categoria>> getAllCategoriaByUser(@PathVariable Long id) {
        List<Categoria> categorias = categoriaService.getAllCategoriasByUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(categorias);
    }

    @PostMapping
    public ResponseEntity<Categoria> createCategoria (@RequestBody CategoriaRequestDTO categoriaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.createCategoria(categoriaDTO));
    }
}
