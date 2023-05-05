package org.example.Utils;

import com.github.javafaker.Faker;
import org.example.Entity.Album;
import org.example.Entity.Artist;
import org.example.Repository.AlbumRepository;
import org.example.Repository.ArtistRepository;

public class FakeDate {
    /**
     * Metoda creeaza folosindu-se de biblioteca Faker artisti si albume si pentru a le insera in baza de date
     * @param numArtist numarul de artisti
     * @param albumsPerArtist numarul de albume per artist
     */

    public static void createData(int numArtist,int albumsPerArtist){
        ArtistRepository artistRepository = new ArtistRepository();
        AlbumRepository albumRepository = new AlbumRepository();
        Faker faker = new Faker();
        for(int i = 0; i < numArtist;i++){
            String name = faker.name().fullName();
            if(artistRepository.findByAttribute("name","Artist.findByName",name).isEmpty())
            {
                Artist artist = new Artist();
                artist.setName(name);
                artistRepository.create(artist);
                for(int j = 0; j < albumsPerArtist; j++){
                    String title = faker.lorem().words(3).toString();
                    if(albumRepository.findByAttribute("title","Album.findByName",title).isEmpty()) {
                        Album album = new Album();
                        album.setTitle(title);
                        album.setReleaseYear(faker.number().numberBetween(2002, 2023));
                        album.setArtist(artist);
                        albumRepository.create(album);
                    }
            }
            }
        }

    }
}
