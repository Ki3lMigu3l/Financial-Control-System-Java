package br.com.ki3lmigu3l.finances.dto;

import br.com.ki3lmigu3l.finances.model.Gasto;

import java.time.LocalDate;

public record GastoDTO(
        String descricao,
        LocalDate data,
        Double valor
) {
    public GastoDTO(Gasto gasto) {
        this(gasto.getDescricao(), gasto.getData(), gasto.getValor());
    }
}
