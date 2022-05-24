package webg66.musique.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import webg66.musique.entities.Artist;

@Repository
public interface ArtistDB extends CrudRepository<Artist, String>{
    
}
