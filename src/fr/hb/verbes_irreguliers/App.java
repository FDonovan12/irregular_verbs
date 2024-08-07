package fr.hb.verbes_irreguliers;

import java.util.Scanner;

import fr.hb.verbes_irreguliers.business.Game;
import fr.hb.verbes_irreguliers.business.Question;
import fr.hb.verbes_irreguliers.service.GameService;
import fr.hb.verbes_irreguliers.service.QuestionService;
import fr.hb.verbes_irreguliers.service.Utils;
import fr.hb.verbes_irreguliers.service.VerbService;
import fr.hb.verbes_irreguliers.service.impl.GameServiceImpl;
import fr.hb.verbes_irreguliers.service.impl.QuestionServiceImpl;
import fr.hb.verbes_irreguliers.service.impl.VerbServiceImpl;

public class App {
	private static GameService gameService = new GameServiceImpl();
	private static QuestionService questionService = new QuestionServiceImpl();
	private static VerbService verbService = new VerbServiceImpl();
	
	public static void main(String[] args) {
		runProject();
	}
	
	public static void runProject() {
		boolean wantContinue = true;
		do {
			gameService.runNewGame();
			String input = Utils.questionScanner(" Voulait vous faire une autre partie ? (Y/N)");
			if (input.toLowerCase().equals("n")) {
				wantContinue = false;
			}
		} while (wantContinue);
		System.out.println(" Bonne journée. Au revoir.");
	}
}
