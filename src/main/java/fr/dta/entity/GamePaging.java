package fr.dta.entity;

import java.util.List;

public class GamePaging {

	private int pages;
	private List<Game> games;

	public GamePaging() {
	}

	public GamePaging(int pages, List<Game> games) {
		super();
		this.pages = pages;
		this.games = games;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
}
