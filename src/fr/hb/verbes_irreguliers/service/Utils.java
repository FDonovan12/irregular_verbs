package fr.hb.verbes_irreguliers.service;


import fr.hb.verbes_irreguliers.App;

public class Utils {

	public static String questionScanner(String question) {
		System.out.println(question);
		return App.getScanner().nextLine();
	}
	
	public static int questionScannerInt(String question) {
		System.out.println(question);
		String input = App.getScanner().nextLine();
		return Integer.parseInt(input);
	}
	
}
