package org.example.Utils;

import org.example.Repository.AlbumRepository;
import org.example.Repository.ArtistRepository;
import org.example.Repository.GenreRepository;
import org.example.Repository.RepositoryFactory;
import org.example.repo.Jdbc.JdbcAlbumRepository;
import org.example.repo.Jdbc.JdbcArtistRepository;
import org.example.repo.Jdbc.JdbcGenreRepository;

public class JdbcRepositoryFactory implements RepositoryFactory {
    @Override
    public ArtistRepository createArtistRepository() {
        return new JdbcArtistRepository();
    }

    @Override
    public GenreRepository createGenreRepository() {
        return new JdbcGenreRepository();
    }

    @Override
    public AlbumRepository createAlbumRepository() {
        return new JdbcAlbumRepository();
    }
}
