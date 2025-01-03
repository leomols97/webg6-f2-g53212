package webg66.musique.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webg66.musique.business.MyService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class TrackRest {
    
    @Autowired
    private MyService myService;

    @GetMapping("/tracks/{streamsAmount}")
    public ResponseEntity<Iterable<Object[]>> getTracksWithStreamAmountHigherThan(@PathVariable("streamsAmount") long streamsAmount){
        return new ResponseEntity<>(myService.getTracksWhereStreamAmountHigherThan(streamsAmount), HttpStatus.OK);
    }

}
