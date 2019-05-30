package model;


public enum Cell {
	DEAD(" "), ALIVE("X");
	
	private String symbol;

	Cell(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}
	

	
	
}
