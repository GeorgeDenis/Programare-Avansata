package org.example.Repository;

import org.example.Repository.AlbumRepository;
import org.example.Repository.ArtistRepository;
import org.example.Repository.GenreRepository;

public interface RepositoryFactory {
    ArtistRepository createArtistRepository();

    GenreRepository createGenreRepository();
    AlbumRepository createAlbumRepository();
}
