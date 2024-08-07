package fr.hb.verbes_irreguliers.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.hb.verbes_irreguliers.business.Verb;

public interface VerbService {
	
	
	public void initVerbsWithCsv();
	
	public List<Verb> readCsv(String fileName);
}
