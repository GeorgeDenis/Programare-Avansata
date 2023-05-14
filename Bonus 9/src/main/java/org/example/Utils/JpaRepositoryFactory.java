package org.example.Utils;

import org.example.Repository.AlbumRepository;
import org.example.Repository.ArtistRepository;
import org.example.Repository.GenreRepository;
import org.example.Repository.RepositoryFactory;
import org.example.repo.Jpa.JpaAlbumRepository;
import org.example.repo.Jpa.JpaArtistRepository;
import org.example.repo.Jpa.JpaGenreRepository;

public class JpaRepositoryFactory implements RepositoryFactory {
    @Override
    public ArtistRepository createArtistRepository() {
        return new JpaArtistRepository();
    }

    @Override
    public GenreRepository createGenreRepository() {
        return new JpaGenreRepository();
    }

    @Override
    public AlbumRepository createAlbumRepository() {
        return new JpaAlbumRepository();
    }
}
