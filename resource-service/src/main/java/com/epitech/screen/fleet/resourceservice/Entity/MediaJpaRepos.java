package com.epitech.screen.fleet.resourceservice.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MediaJpaRepos extends JpaRepository<Media, Long> {
}
