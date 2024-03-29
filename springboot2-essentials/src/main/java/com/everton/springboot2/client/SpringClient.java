package com.everton.springboot2.client;

import com.everton.springboot2.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        //List
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}", Anime.class, 3);
        log.info(entity.getBody());

        Anime anime = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class, 3);
        log.info(anime);

        Anime[] animes = new RestTemplate().getForObject("http://localhost:8080/animes/all", Anime[].class, 3);
        log.info(Arrays.toString(animes));

        ResponseEntity<List<Anime>> exchange = new RestTemplate().exchange("http://localhost:8080/animes/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        log.info(exchange.getBody());


        // Save
//        Anime kindom = Anime.builder().name("Kindom").build();
//        Anime kindomSaved = new RestTemplate().postForObject("http://localhost:8080/animes/", kindom, Anime.class);
//        log.info(kindomSaved);

        Anime samuraiChamplog = Anime.builder().name("Samurai Champlog").build();
        ResponseEntity<Anime> samuraiChamplogSaved = new RestTemplate().exchange("http://localhost:8080/animes/",
                HttpMethod.POST,
                new HttpEntity<>(samuraiChamplog, createJsonHeader()),
                Anime.class);
        log.info("Saved anime {}", samuraiChamplogSaved);


        //UPDATE
        Anime animeToBeUpdated = samuraiChamplogSaved.getBody();
        animeToBeUpdated.setName("Samurai Champlog 2");
        ResponseEntity<Void> samuraiChamplogUpdated = new RestTemplate().exchange("http://localhost:8080/animes/",
                HttpMethod.PUT,
                new HttpEntity<>(animeToBeUpdated, createJsonHeader()),
                Void.class);
        log.info("Updated anime {}", samuraiChamplogUpdated);


        //DELETE
        ResponseEntity<Void> samuraiChamplogDeleted = new RestTemplate().exchange("http://localhost:8080/animes/{id}",
                HttpMethod.DELETE,
                null,
                Void.class,
                22);
        log.info("Deleted anime {}", samuraiChamplogDeleted);
    }

    private static HttpHeaders createJsonHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}
