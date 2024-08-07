package fr.hb.verbes_irreguliers.business;

import java.util.List;

public class Verb {
	private Long id;
	private String baseVerb;
	private String preterit;
	private String pastParticiple;
	private String translate;
	private Long count = 0L;

	public Verb(String baseVerb, String preterit, String pastParticiple, String translate) {
		this.id = count++;
		this.baseVerb = baseVerb;
		this.preterit = preterit;
		this.pastParticiple = pastParticiple;
		this.translate = translate;
	}

	public String getBaseVerb() {
		return baseVerb;
	}

	public String getPreterit() {
		return preterit;
	}

	public String getTranslate() {
		return translate;
	}

	public String getPastParticiple() {
		return pastParticiple;
	}

	@Override
	public String toString() {
		return String.format("  %-11s %-11s %-11s",  baseVerb  , preterit  , pastParticiple);
	}

}
