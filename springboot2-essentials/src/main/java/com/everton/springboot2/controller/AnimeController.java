package com.everton.springboot2.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everton.springboot2.domain.Anime;
import com.everton.springboot2.util.DateUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("anime")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {

	private final DateUtil dateUtil;

	@GetMapping(path = "list")
	public List<Anime> list() {
		log.info(dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
		return List.of(new Anime("DBZ"), new Anime("Berserk"), new Anime("Naruto"));

	}
}
