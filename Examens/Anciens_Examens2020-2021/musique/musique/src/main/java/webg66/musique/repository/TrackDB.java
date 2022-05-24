package webg66.musique.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import webg66.musique.entities.Track;

@Repository
public interface TrackDB extends CrudRepository<Track, Integer>  {
    @Query(value="SELECT t, a.name FROM Track t JOIN t.artist a WHERE t.stream > :streams")
    List<Object[]> getTracksWhereStreamAmountHigherThan(long streams);
}
