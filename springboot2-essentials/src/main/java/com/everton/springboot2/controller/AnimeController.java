package com.everton.springboot2.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.everton.springboot2.service.AnimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.everton.springboot2.domain.Anime;
import com.everton.springboot2.util.DateUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {

	private final DateUtil dateUtil;
	private final AnimeService animeService;

	@GetMapping
	public  ResponseEntity<List<Anime>> listAll() {
		log.info(dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
		return ResponseEntity.ok(animeService.listAll());

	}

	@GetMapping(path = "/{id}")
	public  ResponseEntity<Anime> findById(@PathVariable long id) {
		return ResponseEntity.ok(animeService.findById(id));

	}

	@PostMapping
	public ResponseEntity<Anime> save(@RequestBody Anime anime) {
		return new ResponseEntity(animeService.save(anime), HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id) {
		animeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
