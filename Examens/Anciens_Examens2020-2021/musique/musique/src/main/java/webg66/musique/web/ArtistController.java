package webg66.musique.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webg66.musique.business.MyService;
import webg66.musique.entities.Artist;
import webg66.musique.entities.Track;

@Controller
public class ArtistController {

    @Autowired
    private MyService myService;

    @GetMapping("/artists")
    public String getArtists(Model model) {
        model.addAttribute("artists", myService.getArtists());
        return "artists";
    }

    @GetMapping("/artist")
    public String getArtist(Model model, @RequestParam String artistId) {
        model.addAttribute("artist", myService.getArtist(artistId).get());
        model.addAttribute("track", new Track());
        return "artist";
    }

    @PostMapping("/updateTrack/{artistId}/{trackId}")
    public String updateStreamsOfTrack(
            @PathVariable("artistId") String artistId,
            @PathVariable("trackId") int trackId,
            Track track) {

        Optional<Artist> artistToUpdate = myService.getArtist(artistId);
        for (Track track2 : artistToUpdate.get().getTracks()) {
            if (track2.getId() == trackId) {
                track2.setStream(track.getStream());
            }
        }
        myService.updateArtist(artistToUpdate.get());
        return "redirect:/artist?artistId=" + artistId;
    }

}