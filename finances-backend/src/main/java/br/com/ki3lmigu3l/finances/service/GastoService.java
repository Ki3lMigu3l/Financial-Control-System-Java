package br.com.ki3lmigu3l.finances.service;

import br.com.ki3lmigu3l.finances.dto.GastoDTO;
import br.com.ki3lmigu3l.finances.model.Gasto;

import java.util.List;
import java.util.Optional;


public interface GastoService {

    Gasto save(Gasto gasto, Long userId);
    Gasto update(Gasto gasto);
    List<Gasto> getAllGastos();
    Optional<Gasto> findGastoById(Long id);
    void delete(Gasto gasto);
}
