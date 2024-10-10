package br.com.ki3lmigu3l.finances.service.impl;

import br.com.ki3lmigu3l.finances.model.Gasto;
import br.com.ki3lmigu3l.finances.model.Usuario;
import br.com.ki3lmigu3l.finances.repository.GastoRepository;
import br.com.ki3lmigu3l.finances.service.GastoService;
import br.com.ki3lmigu3l.finances.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GastoServiceImpl implements GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Gasto save(Gasto gasto, Long userId) {
        Usuario usuario = usuarioService.findUserById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        Gasto newGasto = new Gasto(usuario);
        return gastoRepository.save(gasto);
    }

    @Override
    public Gasto update(Gasto gasto) {
        return gastoRepository.save(gasto);
    }

    @Override
    public List<Gasto> getAllGastos() {
        return gastoRepository.findAll();
    }

    @Override
    public Optional<Gasto> findGastoById(Long id) {
        return gastoRepository.findById(id);
    }

    @Override
    public void delete(Gasto gasto) {
        gastoRepository.delete(gasto);
    }

}
