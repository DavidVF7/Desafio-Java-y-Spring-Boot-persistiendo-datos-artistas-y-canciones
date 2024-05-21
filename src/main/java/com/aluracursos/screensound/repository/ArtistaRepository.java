package com.aluracursos.screensound.repository;

import com.aluracursos.screensound.model.Artista;
import com.aluracursos.screensound.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    Optional<Artista> findByNombreContainsIgnoreCase(String nombre);

    @Query("SELECT m FROM Artista a JOIN a.canciones m WHERE a.nombre ILIKE %:nombre%")
    List<Cancion> buscaCancionesPorArtista(String nombre);
}
