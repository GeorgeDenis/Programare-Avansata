package org.example;


import org.example.Entity.Album;
import org.example.Entity.AlbumGenre;
import org.example.Entity.Artist;
import org.example.Entity.Genre;
import org.example.Repository.AlbumGenreRepository;
import org.example.Repository.AlbumRepository;
import org.example.Repository.ArtistRepository;
import org.example.Repository.GenreRepository;
import org.example.Utils.FakeDate;

import java.util.List;

import static org.example.Utils.FakeDate.createData;

public class Main {

    public static void main(String[] args) {

        ArtistRepository artistRepository = new ArtistRepository();
        AlbumRepository albumRepository = new AlbumRepository();
        GenreRepository genreRepository = new GenreRepository();
        AlbumGenreRepository albumGenreRepository = new AlbumGenreRepository();
        

        Album albumTest = albumRepository.findById(8014);
        Genre genreTest = genreRepository.findById(60);
        AlbumGenreKey albumGenreKey = new AlbumGenreKey(albumTest.getId(),genreTest.getId());
        AlbumGenre albumGenre = new AlbumGenre();
        albumGenre.setAlbum(albumTest);
        albumGenre.setGenre(genreTest);
        albumGenre.setId(albumGenreKey);
        albumGenreRepository.create(albumGenre);
        System.out.println(artistRepository.findById(3));
        System.out.println(albumRepository.findById(2));
        System.out.println(artistRepository.findByAttribute("name","Artist.findByName","Bob Dylan"));

        int numArtist = 100;
        int albumsPerArtist = 10;
        long startTime = System.currentTimeMillis();
        createData(numArtist,albumsPerArtist);
        long endtime = System.currentTimeMillis();
        long duration = endtime - startTime;
        System.out.println(duration);
       EntityManagerFactoryUtil.closeEntityManagerFactory();

    }
}
