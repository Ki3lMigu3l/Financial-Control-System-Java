package br.com.ki3lmigu3l.finances.repository;

import br.com.ki3lmigu3l.finances.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
}
