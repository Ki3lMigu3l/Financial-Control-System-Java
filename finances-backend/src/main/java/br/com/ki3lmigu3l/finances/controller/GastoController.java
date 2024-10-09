package br.com.ki3lmigu3l.finances.controller;

import br.com.ki3lmigu3l.finances.dto.GastoDTO;
import br.com.ki3lmigu3l.finances.model.Gasto;
import br.com.ki3lmigu3l.finances.service.GastoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gastos")
public class GastoController {

    @Autowired
    private GastoService gastoService;

    @PostMapping
    public ResponseEntity<Gasto> createGasto (@RequestBody GastoDTO gastoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gastoService.save(gastoDTO));
    }
}
