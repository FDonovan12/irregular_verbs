package fr.hb.verbes_irreguliers.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import fr.hb.verbes_irreguliers.business.Game;
import fr.hb.verbes_irreguliers.business.Question;
import fr.hb.verbes_irreguliers.business.Verb;
import fr.hb.verbes_irreguliers.service.GameService;
import fr.hb.verbes_irreguliers.service.QuestionService;
import fr.hb.verbes_irreguliers.service.Utils;
import fr.hb.verbes_irreguliers.service.VerbService;

public class GameServiceImpl implements GameService {
	
	private static VerbService verbService = new VerbServiceImpl();
	private static QuestionService questionService = new QuestionServiceImpl();
	
	public void runNewGame() {
		Game game = initGame();
		for (int i = 0; i < game.getNumberOfQuestion(); i++) {

			Question question = game.getQuestions().get(i);
			questionService.doQuestion(question, i);
			updateScore(game);
		}
		printScoreFinal(game);
	}
	
	public void updateScore(Game game) {
		Question question = game.getQuestion();
		if(questionService.isResponseValid(question)) {
			game.incrementScore();
			System.out.print(" Bravo ! ");
		}
		System.out.print(" Ce n’est pas la bonne réponse. ");
		System.out.printf(" Score : %s/%s\n",game.getScore(), game.getCurrentQuestion()+1);
		game.incrementCurrentQuestion();
	}
	
	
	public void printScoreFinal(Game game) {
		System.out.printf(" Score Final : %s/%s\n",game.getScore(), game.getNumberOfQuestion());
		System.out.printf(" Temps moyen de reponse : %f\n", meanTimeOfResponse(game));
		System.out.println(" Historique des verbes demandées : ");
		System.out.printf("\t %-11s %-11s %-11s\n",  "baseVerb"  , "preterit"  , "pastParticiple");
		game.getQuestions().stream().map(Question::getVerb).forEach(System.out::println);
	}
	
	public float meanTimeOfResponse(Game game) {
		return (float) (game.getQuestions().stream().mapToLong(Question::getTimeResponse).sum())/1000;
	}
	
	
	public void initRandomVerbs(Game game) {
		int numberOfQuestion = game.getNumberOfQuestion();
		Collections.shuffle(VerbServiceImpl.getVerbs());
		List<Verb> verbs = VerbServiceImpl.getVerbs().subList(0, numberOfQuestion);
		List<Question> questions = verbs.stream().map(verb -> new Question(verb)).toList();
		game.setQuestions(questions);
	}
	
	public Game initGame() {
		verbService.initVerbsWithCsv();
		System.out.println(" Bienvenue sur les verbes irreguliers !");
		System.out.printf(" Il y as %d verbes irreguliers disponible !", VerbServiceImpl.getVerbs().size());
		System.out.println(" Nouvelle partie !");
		int nbQuestion = Utils.questionScannerInt(" Combien de  verbe voulait vous pour cette partie ?");
		Game game = new Game(nbQuestion);
		initRandomVerbs(game);
		return game;
	}
	
}
