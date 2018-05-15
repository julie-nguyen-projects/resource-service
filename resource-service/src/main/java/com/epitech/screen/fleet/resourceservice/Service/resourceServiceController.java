package com.epitech.screen.fleet.resourceservice.Service;

import com.epitech.screen.fleet.resourceservice.Entity.Media;
import com.epitech.screen.fleet.resourceservice.Entity.MediaJpaRepos;
import com.epitech.screen.fleet.resourceservice.Entity.MediaType;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.ws.Response;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class resourceServiceController {
    @Autowired
    private MediaJpaRepos mediaJpaRepos;

    @GetMapping("/resource-media/all")
    public List<Media> retrieveAllMediaFile(){
        return mediaJpaRepos.findAll();
    }

    @PostMapping(value = "/resource-media/insert", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public Media insertMedia(@RequestBody Media media){
        mediaJpaRepos.save(media);
        return media;
    }

    @DeleteMapping(value = "resource-media/delete/{id}")
    public void updateMedia(@PathVariable Long id){
        mediaJpaRepos.deleteById(id);

    }

    @PutMapping(value = "resource-media/update/{id}", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public void updateMedia(@PathVariable long id, @RequestBody Media media) throws NotFoundException {
        Optional<Media> mediaUpdate = mediaJpaRepos.findById(id);

        if (!mediaUpdate.isPresent())
            throw new NotFoundException("id" + id);

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
