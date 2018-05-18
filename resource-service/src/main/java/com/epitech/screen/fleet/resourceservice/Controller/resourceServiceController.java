package com.epitech.screen.fleet.resourceservice.Controller;

import com.epitech.screen.fleet.resourceservice.Model.Media;
import com.epitech.screen.fleet.resourceservice.Repository.MediaJpaRepos;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class resourceServiceController {
    @Autowired
    private MediaJpaRepos mediaJpaRepos;

    @GetMapping("/resource-media/all")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<Media> retrieveAllMediaFile(){
        return mediaJpaRepos.findAll();
    }

    @PostMapping(value = "/resource-media", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:8080")
    public Media insertMedia(@RequestBody Media media){
        mediaJpaRepos.save(media);
        return media;
    }

    @DeleteMapping(value = "resource-media/{id}")
    public void updateMedia(@PathVariable Long id){
        mediaJpaRepos.deleteById(id);

    }


    @PutMapping(value = "resource-media/", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public void updateMedia(@RequestBody Media media) throws NotFoundException {
        Optional<Media> mediaUpdate = mediaJpaRepos.findById(media.getId());

        if (!mediaUpdate.isPresent())
            throw new NotFoundException("id" + media.getId());

        Media updatedMedia = mediaUpdate.get();

        updatedMedia.setName(media.getName());
        updatedMedia.setPath(media.getPath());
        updatedMedia.setMediaType(media.getMediaType());
        mediaJpaRepos.save(updatedMedia);
    }

    @GetMapping(value = "resource-media/{id}")
    public Media retrieveMedia(@PathVariable Long id){
        Optional<Media> mediaOptional = mediaJpaRepos.findById(id);
        Media mediaRetrieve = mediaOptional.get();

        return mediaRetrieve;
    }
}
