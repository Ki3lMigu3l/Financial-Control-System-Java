package br.com.ki3lmigu3l.finances.controller;

import br.com.ki3lmigu3l.finances.dto.GastoDTO;
import br.com.ki3lmigu3l.finances.model.Gasto;
import br.com.ki3lmigu3l.finances.model.Usuario;
import br.com.ki3lmigu3l.finances.service.GastoService;
import br.com.ki3lmigu3l.finances.service.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gastos")
public class GastoController {

    @Autowired
    private GastoService gastoService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/{id}")
    public ResponseEntity<Object> createGasto (@RequestBody GastoDTO gastoDTO, @PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioService.findUserById(id);
        if (usuarioOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }

        var gasto = new Gasto();
        BeanUtils.copyProperties(gastoDTO, gasto);
        return ResponseEntity.status(HttpStatus.CREATED).body(gastoService.save(gasto, id));
    }

    @GetMapping
    public ResponseEntity<List<Gasto>> getAllGastos () {
        return ResponseEntity.status(HttpStatus.OK).body(gastoService.getAllGastos());
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Object> deleteGasto (@PathVariable Long id) {
        Optional<Gasto> gastoOptional = gastoService.findGastoById(id);
        if (gastoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Gasto não localizado!");
        }

        gastoService.delete(gastoOptional.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Gasto removido: " + gastoOptional.get().getTitulo());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateGasto (@PathVariable Long id, @RequestBody GastoDTO gastoDTO) {
        Optional<Gasto> gastoOptional = gastoService.findGastoById(id);
        if (gastoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Gasto não localizado!");
        }

        var gasto = gastoOptional.get();
        BeanUtils.copyProperties(gastoDTO, gasto);
        gastoService.update(gasto);
        return ResponseEntity.status(HttpStatus.OK).body(gastoDTO);
    }
}
