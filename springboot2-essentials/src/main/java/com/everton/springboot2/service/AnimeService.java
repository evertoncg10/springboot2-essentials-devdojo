package com.everton.springboot2.service;

import com.everton.springboot2.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService {
    // private final AnimeRepository animeRepository;

    private static List<Anime> animes;

    static {
        animes = new ArrayList<>(List.of(new Anime(1L,"DBZ"), new Anime(2L,"Berserk"), new Anime(3L,"Naruto")));
    }
    public List<Anime> listAll() {
        return animes;
    }

    public Anime findById(long id) {
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }

    public Anime save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(4, 1000000));
        animes.add(anime);
        return anime;
    }
}
