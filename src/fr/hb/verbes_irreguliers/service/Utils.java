package fr.hb.verbes_irreguliers.service;


import java.text.Normalizer;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Utils {
	private static Scanner scanner = new Scanner(System.in);

	public static String questionScanner(String question) {
		System.out.println(question);
		return scanner.nextLine();
	}
	
	public static int questionScannerInt(String question) {
		int result = 0;
		boolean isCorrectInput = false;
		do {
			try {
				System.out.println(question);
				String input = scanner.nextLine();
				result = Integer.parseInt(input);
				isCorrectInput = true;
			} catch (Exception e) {
				System.err.println(" Cette valeur n'est pas recevable");
			}
		} while (!isCorrectInput);
		return result;
	}
	
	public static String addColorToContent(String content, Color color) {
		return color.label + content + Color.RESET.label;
	}
	
	public static void printColor(String content, Color color) {
		System.out.println(addColorToContent(content, color));
	}

    public static String slugify(String input) {
    	Pattern NONLATIN = Pattern.compile("[^\\w-]");
    	Pattern WHITESPACE = Pattern.compile("[\\s]");

        String noWhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(noWhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("").replace("--", "-").replaceAll("(^-|-$)", "");
        return slug.toLowerCase(Locale.FRANCE);
    }
}
