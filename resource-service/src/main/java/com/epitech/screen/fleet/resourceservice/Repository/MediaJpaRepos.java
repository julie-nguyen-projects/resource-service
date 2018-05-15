package com.epitech.screen.fleet.resourceservice.Repository;

import com.epitech.screen.fleet.resourceservice.Model.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaJpaRepos extends JpaRepository<Media, Long> {
}
