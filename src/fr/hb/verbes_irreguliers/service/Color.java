package fr.hb.verbes_irreguliers.service;

public enum Color {
	RESET("\u001B[0m"),
	BLACK("\u001B[30m"),
	RED("\u001B[31m"),
	GREEN("\u001B[32m"),
	YELLOW("\u001B[33m"),
	BLUE("\u001B[34m"),
	PURPLE("\u001B[35m"),
	CYAN("\u001B[36m"),
	WHITE("\u001B[37m"),
	
	BACKGROUND_BLACK("\u001B[40m"),
	BACKGROUND_RED("\u001B[41m"),
	BACKGROUND_GREEN("\u001B[42m"),
	BACKGROUND_YELLOW("\u001B[43m"),
	BACKGROUND_BLUE("\u001B[44m"),
	BACKGROUND_PURPLE("\u001B[45m"),
	BACKGROUND_CYAN("\u001B[46m"),
	BACKGROUND_WHITE("\u001B[47m");
    
    public final String label;

    private Color(String label) {
        this.label = label;
    }
}
