package fr.hb.verbes_irreguliers.business;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import fr.hb.verbes_irreguliers.service.Color;
import fr.hb.verbes_irreguliers.service.Utils;

public class Question {
	private Long id;
	private String preteritResponse;
	private String pastParticipleResponse;
	private LocalDateTime startQuestion;
	private LocalDateTime endQuestion;
	private Verb verb;
	private static Long count = 0L;
	
	
	public Question(Verb verb) {
		this.id = count++;
		this.startQuestion = LocalDateTime.now();
		this.verb = verb;
	}
	
	public String getPreteritResponse() {
		return preteritResponse;
	}
	
	public String getPastParticipleResponse() {
		return pastParticipleResponse;
	}
	
	public Question doResponse(String preteritResponse, String pastParticipleResponse) {
		this.preteritResponse = preteritResponse;
		this.pastParticipleResponse = pastParticipleResponse;
		this.endQuestion = LocalDateTime.now();
		return this;
	}
	
	public void resetTimer() {
		this.startQuestion = LocalDateTime.now();
	}
	
	public void setVerb(Verb verb) {
		this.verb = verb;
	}
	
	public Verb getVerb() {
		return verb;
	}
	
	public String getQuestionExam(int i) {
		Verb verb = this.getVerb();
		this.resetTimer();
		return String.format(" Question %d : donnez le prétérit et le participe passé du verbe %s (%s) :", i+1, verb.getBaseVerb(), verb.getTranslate());
	}
	
	public String getVerbToString() {
		if(this.isResponseValid()) {
			return Utils.addColorToContent(verb.toString(), Color.GREEN);
		}
		return Utils.addColorToContent(verb.toString(), Color.RED);
	}
	
	public boolean isResponseValid() {
		Verb verb = this.getVerb();
		boolean isGoodPreterit = this.getPreteritResponse().equals(verb.getPreterit());
		boolean isGoodPAstParticple = this.getPastParticipleResponse().equals(verb.getPastParticiple());
		return isGoodPreterit && isGoodPAstParticple;

	}
	public Long getTimeResponse() {
		return ChronoUnit.MILLIS.between(startQuestion, endQuestion);
	}

	@Override
	public String toString() {
		return "Question\n preteritResponse=" + preteritResponse + ", pastParticipleResponse=" + pastParticipleResponse
				+ ", time=" + getTimeResponse();
	}
	
	
}
