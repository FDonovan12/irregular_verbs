package fr.hb.verbes_irreguliers.service.impl;

import fr.hb.verbes_irreguliers.business.Question;
import fr.hb.verbes_irreguliers.business.Verb;
import fr.hb.verbes_irreguliers.service.QuestionService;
import fr.hb.verbes_irreguliers.service.Utils;

public class QuestionServiceImpl implements QuestionService {

	public boolean isResponseValid(Question question) {
		Verb verb = question.getVerb();
		boolean isGoodPreterit = question.getPreteritResponse().equals(verb.getPreterit());
		boolean isGoodPAstParticple = question.getPastParticipleResponse().equals(verb.getPastParticiple());
		return isGoodPreterit && isGoodPAstParticple;

	}
	
	public void doQuestion(Question question, int currentQuestion) {
		String questionExam = question.getQuestionExam(currentQuestion);
		String input = Utils.questionScanner(questionExam);
		String preterit = "";
		String pastParticiple = "";
		try {
			String[] inputs = input.split(", ?");
			preterit = inputs[0];
			pastParticiple = inputs[1];
		} catch (Exception e) {
		}
		question.doResponse(preterit, pastParticiple);
	}

}
