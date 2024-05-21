package com.aluracursos.screensound.model;

import jakarta.persistence.*;

@Entity
@Table(name = "canciones")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    public Cancion(){}

    public Cancion(String nombreCancion) {
        this.titulo = nombreCancion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "'" + titulo + '\'';
    }
}
