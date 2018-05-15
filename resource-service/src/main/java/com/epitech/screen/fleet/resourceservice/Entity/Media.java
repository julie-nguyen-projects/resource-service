package com.epitech.screen.fleet.resourceservice.Entity;

import javax.persistence.*;

@Entity
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mediaName")
    private String name;

    @Column(name = "mediaPath")
    private String path;

    @Column(name = "mediaType")
    private MediaType mediaType;

    public Media() {
    }

    public Media(String name, String path, MediaType mediaType) {

        this.name = name;
        this.path = path;
        this.mediaType = mediaType;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }
}

