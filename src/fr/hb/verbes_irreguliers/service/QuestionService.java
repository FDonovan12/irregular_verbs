package fr.hb.verbes_irreguliers.service;

import fr.hb.verbes_irreguliers.business.Question;
import fr.hb.verbes_irreguliers.business.Verb;

public interface QuestionService {

	boolean isResponseValid(Question question);

	void doQuestion(Question question, int i);
	
}
