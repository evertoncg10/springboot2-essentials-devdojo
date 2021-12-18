package com.everton.springboot2.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.everton.springboot2.service.AnimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Anime> listAll() {
		log.info(dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
		return animeService.listAll();

	}
}
