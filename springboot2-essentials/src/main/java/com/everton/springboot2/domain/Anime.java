package com.everton.springboot2.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Anime {
	private String name;

	public Anime() {
	}

	public Anime(String name) {
		this.setName(name);
	}

}
