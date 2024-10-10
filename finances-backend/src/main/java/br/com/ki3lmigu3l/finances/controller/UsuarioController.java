package br.com.ki3lmigu3l.finances.controller;

import br.com.ki3lmigu3l.finances.dto.UsuarioDTO;
import br.com.ki3lmigu3l.finances.model.Usuario;
import br.com.ki3lmigu3l.finances.service.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers () {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAllUsers());
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario (@RequestBody UsuarioDTO usuarioDTO) {
        var usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.createUsuario(usuario));
    }
}
