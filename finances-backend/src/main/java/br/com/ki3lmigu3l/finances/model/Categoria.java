package br.com.ki3lmigu3l.finances.model;

import br.com.ki3lmigu3l.finances.model.enums.CategoriaPadrao;
import jakarta.persistence.*;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private boolean padrao;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Categoria() {
    }

    public Categoria (CategoriaPadrao categoriasPadrao) {
        this.nome = categoriasPadrao.name();
        this.padrao = true;
        this.usuario = null;
    }

    public Categoria (String nome, Usuario usuario) {
        this.nome = nome;
        this.padrao = false;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isPadrao() {
        return padrao;
    }

    public void setPadrao(boolean padrao) {
        this.padrao = padrao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
