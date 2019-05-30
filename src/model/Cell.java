package model;

public enum Cell {
	DEAD(" "), ALIVE("o");
	private String symbol;

	public String getSymbol() {
		return symbol;
	}

	Cell(String symbol) {
		this.symbol = symbol;
	}

}
