package com.aluracursos.screensound.principal;

import com.aluracursos.screensound.model.Artista;
import com.aluracursos.screensound.model.Cancion;
import com.aluracursos.screensound.model.TipoArtista;
import com.aluracursos.screensound.repository.ArtistaRepository;
import com.aluracursos.screensound.service.ConsultaChatGPT;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ArtistaRepository repositorio;

    public Principal(ArtistaRepository repository) { this.repositorio = repository; }

    public void muestraElMenu(){
        var opcion = -7;

        while (opcion != 0) {
            var menu = """
                    \n
                    1 - Registrar artista
                    2 - Registrar canciones
                    3 - Listar canciones
                    4 - Buscar canciones por artista
                    5 - Buscar los datos de un artista - ChatGPT
                    
                    0 - Salir
                    """;

            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1:
                    registrarArtista();
                    break;
                case 2:
                    registrarCanciones();
                    break;
                case 3:
                    listarCanciones();
                    break;
                case 4:
                    buscarCancionesPorArtista();
                    break;
                case 5:
                    buscarDatosDelArtista();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación ...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void registrarArtista() {
        var registrarNuevo = "SI";

        while (registrarNuevo.equalsIgnoreCase("SI")){
            System.out.println("¿Cuál es el nombre del artista?");
            var nombre = teclado.nextLine();
            System.out.println("¿Qué tipo de artista es (solo, duo, banda?");
            var tipo = teclado.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nombre, tipoArtista);
            repositorio.save(artista);
            System.out.println("¿Deseas registrar nuevo artista? (SI/NO)");
            registrarNuevo = teclado.nextLine();
        }
    }

    private void registrarCanciones() {
        var opcionElegida = "SI";

        while(opcionElegida.equalsIgnoreCase("SI")){
            System.out.println("¿De qué artista es la canción?");
            var nombre = teclado.nextLine();
            Optional<Artista> artista = repositorio.findByNombreContainsIgnoreCase(nombre);
            if (artista.isPresent()){
                System.out.println("Informa el titulo de la canción");
                var nombreCancion = teclado.nextLine();
                Cancion cancion = new Cancion(nombreCancion);
                cancion.setArtista(artista.get());
                artista.get().getCanciones().add(cancion);
                repositorio.save(artista.get());
            } else {
                System.out.println("Artista no encontrado");
            }
            System.out.println("¿Desea agregar otra canción? (SI/NO)");
            opcionElegida = teclado.nextLine();
        }
    }

    private void listarCanciones() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(System.out::println);
    }

    private void buscarCancionesPorArtista() {
        System.out.println("¿De qué artista quieres buscar la canción?");
        var nombre = teclado.nextLine();
        List<Cancion> canciones = repositorio.buscaCancionesPorArtista(nombre);
        canciones.forEach(System.out::println);
    }

    private void buscarDatosDelArtista() {
        System.out.println("¿De qué artista desea buscar información?");
        var artista = teclado.nextLine();
        var respuesta = ConsultaChatGPT.obtenerInformacion(artista);
        System.out.println(respuesta.trim());
    }
}
