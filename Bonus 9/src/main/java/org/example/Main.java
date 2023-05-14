package org.example;


import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.BoolVar;
import org.example.Entity.*;
import org.example.Repository.AlbumRepository;
import org.example.Repository.ArtistRepository;
import org.example.Repository.GenreRepository;
import org.example.Repository.RepositoryFactory;
import org.example.Utils.RepositoryFactoryProvider;
import org.example.repo.Jpa.JpaAlbumRepository;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        RepositoryFactory factory = RepositoryFactoryProvider.getFactory("jpa");

        //Artist
        ArtistRepository artistRepository = factory.createArtistRepository();

        Artist newArtist = new Artist();
        newArtist.setName("BUG2");
        artistRepository.create(newArtist);

        Artist foundArtist = artistRepository.findById(1367);
        System.out.println("Am găsit artistul cu ID-ul: " + foundArtist.getId());

        List<Artist> artists = artistRepository.findByName(newArtist.getName());
        System.out.println("Am găsit " + artists.size() + " artiști cu numele " + newArtist.getName());
        //Genre
        GenreRepository genreRepository = factory.createGenreRepository();

        Genre newGenre = new Genre();
        newGenre.setName("gen24");
        genreRepository.create(newGenre);

        Genre foundGenre = genreRepository.findById(80);
        System.out.println("Am găsit genul cu ID-ul: " + foundGenre.getId());

        List<Genre> genres = genreRepository.findByName(newGenre.getName());
        System.out.println("Am găsit " + genres.size() + " genuri cu numele " + newGenre.getName());

        //Album
        AlbumRepository albumRepository = factory.createAlbumRepository();
        Album newAlbum = new Album();
        newAlbum.setReleaseYear(2002);
        newAlbum.setTitle("Album7");
        newAlbum.setArtist(artistRepository.findById(1367));
        albumRepository.create(newAlbum);

        Album foundAlbum = albumRepository.findById(9452);
        System.out.println("Am găsit albumul cu ID-ul: " + foundAlbum.getId() + " si numele: " + foundAlbum.getTitle());

        JpaAlbumRepository jpaAlbumRepository = new JpaAlbumRepository();
        List<Album> albums = jpaAlbumRepository.findAll();
        int k = 5;
        int p = 2;

// Creăm modelul
        Model model = new Model("Find albums");

// Creăm variabilele de decizie
        BoolVar[] albumVars = new BoolVar[albums.size()];
        for (int i = 0; i < albums.size(); i++) {
            albumVars[i] = model.boolVar("Album " + i);
        }

// Adăugăm restricția că cel puțin k albume trebuie selectate
        model.sum(albumVars, ">=", k).post();

// Adăugăm restricția că toate albumele selectate încep cu aceeași literă
        for (int i = 0; i < albums.size(); i++) {
            for (int j = i + 1; j < albums.size(); j++) {
                model.ifThen(
                        model.and(albumVars[i], albumVars[j]),
                        model.arithm(
                                model.intVar((int) (albums.get(i).getTitle().isEmpty() ? '\0' : albums.get(i).getTitle().charAt(0))),
                                "=",
                                model.intVar((int) (albums.get(j).getTitle().isEmpty() ? '\0' : albums.get(j).getTitle().charAt(0)))
                        )
                );
            }
        }

// Adăugăm restricția că diferența dintre anii de lansare a oricăror două albume selectate nu depășește p
        for (int i = 0; i < albums.size(); i++) {
            for (int j = i + 1; j < albums.size(); j++) {
                model.ifThen(
                        model.and(albumVars[i], albumVars[j]),
                        model.arithm(
                                model.intOffsetView(model.intVar(albums.get(i).getReleaseYear()), -albums.get(j).getReleaseYear()),
                                "<=",
                                p
                        )
                );
            }
        }

// Rezolvăm problema
        Solution solution = model.getSolver().findSolution();
        if (solution != null) {
            // Afișăm albumele selectate
            for (int i = 0; i < albums.size(); i++) {
                if (solution.getIntVal(albumVars[i]) == 1) {
                    System.out.println(albums.get(i));
                }
            }
        } else {
            System.out.println("Nu există o soluție care să îndeplinească restricțiile.");
        }


    }
}
