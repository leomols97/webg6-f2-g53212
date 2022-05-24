package webg66.commitManager.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webg66.commitManager.business.MyService;
import webg66.commitManager.dtos.RepositoryDetailDto;


@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/api")
public class RepositoryRest {

    @Autowired
    private MyService myService;

    @GetMapping("/repository/{repositoryId}")
    public ResponseEntity<RepositoryDetailDto> getRepositoryDetails(@PathVariable("repositoryId") int repositoryId){
        return new ResponseEntity<>(myService.getRepositoryDetail(repositoryId), HttpStatus.OK);
    }
}
