package br.com.ki3lmigu3l.finances.service;

import br.com.ki3lmigu3l.finances.dto.GastoDTO;
import br.com.ki3lmigu3l.finances.model.Gasto;


public interface GastoService {

    Gasto save(GastoDTO gastoDto);
}
