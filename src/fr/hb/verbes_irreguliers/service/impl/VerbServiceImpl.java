package fr.hb.verbes_irreguliers.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.hb.verbes_irreguliers.business.Verb;
import fr.hb.verbes_irreguliers.service.VerbService;

public class VerbServiceImpl implements VerbService {
	private static List<Verb> verbs;

	public void initVerbsWithCsv() {
		List<Verb> verbs = readCsv("verbes.csv");
		VerbServiceImpl.setVerbs(verbs);
	}

	public List<Verb> readCsv(String fileName) {
		List<Verb> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				String baseVerb = values[1].replace("\"", "");
				String preterit = values[2].replace("\"", "");
				String pastParticiple = values[3].replace("\"", "");
				String translate = values[4].replace("\"", "");
				Verb verb = new Verb(baseVerb, preterit, pastParticiple, translate);
				records.add(verb);
			}
			return records;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return records;
	}

	public static List<Verb> getVerbs() {
		return verbs;
	}

	public static void setVerbs(List<Verb> verbs) {
		VerbServiceImpl.verbs = verbs;
	}
}
