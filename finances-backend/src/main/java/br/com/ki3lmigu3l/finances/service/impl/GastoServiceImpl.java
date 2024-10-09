package br.com.ki3lmigu3l.finances.service.impl;

import br.com.ki3lmigu3l.finances.dto.GastoDTO;
import br.com.ki3lmigu3l.finances.model.Gasto;
import br.com.ki3lmigu3l.finances.repository.GastoRepository;
import br.com.ki3lmigu3l.finances.service.GastoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GastoServiceImpl implements GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    @Override
    public Gasto save(GastoDTO gastoDto) {
        var gasto = new Gasto();
        BeanUtils.copyProperties(gastoDto, gasto);
        return gastoRepository.save(gasto);
    }
}
