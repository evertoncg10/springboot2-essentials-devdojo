package com.everton.springboot2.repository;

import com.everton.springboot2.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
