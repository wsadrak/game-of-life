package io;

import model.Cell;

public class ConsolePrinter {
	public void print(String message) {
		System.out.println(message);
	}
	
	public void printCell(Cell cell) {
		System.out.print(cell.getSymbol() + " ");
	}
}
