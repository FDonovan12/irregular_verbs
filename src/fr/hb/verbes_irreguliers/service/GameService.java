package fr.hb.verbes_irreguliers.service;

import fr.hb.verbes_irreguliers.business.Game;

public interface GameService {

	public Game initGame();

	public void initRandomVerbs(Game game);

	public void updateScore(Game game);

	public void printScoreFinal(Game game);

	public void runNewGame();

}
