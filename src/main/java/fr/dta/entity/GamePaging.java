package fr.dta.entity;

import java.util.List;

public class GamePaging {

	private int pages;
	private List<GameLight> games;

	public GamePaging() {
	}

	public GamePaging(int pages, List<GameLight> games) {
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

	public List<GameLight> getGames() {
		return games;
	}

	public void setGames(List<GameLight> games) {
		this.games = games;
	}
}
