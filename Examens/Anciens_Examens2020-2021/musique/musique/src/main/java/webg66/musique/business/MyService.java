package webg66.musique.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webg66.musique.entities.Artist;
import webg66.musique.entities.Track;
import webg66.musique.repository.ArtistDB;
import webg66.musique.repository.TrackDB;

@Service
public class MyService {

    @Autowired
    private ArtistDB artistDB;

    @Autowired
    private TrackDB trackDB;

    public Iterable<Artist> getArtists() {
        return artistDB.findAll();
    }

    public Optional<Artist> getArtist(String login) {
        return artistDB.findById(login);
    }

    public void updateArtist(Artist artist) {
        artistDB.save(artist);
    }

    public Iterable<Track> getTracks() {
        return trackDB.findAll();
    }

    public Optional<Track> getTrack(int id) {
        return trackDB.findById(id);
    }

    public void updateTrack(Track track) {
        trackDB.save(track);
    }

    public Iterable<Object[]> getTracksWhereStreamAmountHigherThan(long streamsAmount) {
        return trackDB.getTracksWhereStreamAmountHigherThan(streamsAmount);
    }
}
