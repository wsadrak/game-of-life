package model;

import java.util.Random;

import javax.swing.CellRendererPane;

import io.ConsolePrinter;

public class Generation {
	ConsolePrinter printer = new ConsolePrinter();
	private Cell[][] board;
	private int rows;
	private int columns;

	public Generation(int height, int width) {
		rows = height;
		columns = width;
		board = new Cell[rows][columns];
		filfullBoard();
	}

	private void filfullBoard() {
		Random random = new Random();
		boolean isAlive = false;

		for (int currentRow = 0; currentRow < rows; currentRow++) {
			for (int currentColumn = 0; currentColumn < columns; currentColumn++) {
				isAlive = random.nextBoolean();
				if (isAlive) {
					board[currentRow][currentColumn] = Cell.ALIVE;
				} else {
					board[currentRow][currentColumn] = Cell.DEAD;
				}
			}
		}
	}

	public void print() {
		for (int currentRow = 0; currentRow < rows; currentRow++) {
			for (int currentColumn = 0; currentColumn < columns; currentColumn++) {
				printer.printCell(board[currentRow][currentColumn]);
			}
			printer.print("\n");
		}
	}

	public void update() {
		for (int currentRow = 0; currentRow < rows; currentRow++) {
			for (int currentColumn = 0; currentColumn < columns; currentColumn++) {
				int neighbours = neighboursCountAt(currentRow, currentColumn);
				if (neighbours == 3 || (neighbours == 2 && board[currentRow][currentColumn] == Cell.ALIVE)) {
					board[currentRow][currentColumn] = Cell.ALIVE;
				} else {
					board[currentRow][currentColumn] = Cell.DEAD;
				}
			}
		}
	}

	private int neighboursCountAt(int currentRow, int currentColumn) {
		int neighbours = 0;

		if (currentRow != 0 && currentColumn != 0) { // 1
			if (board[currentRow - 1][currentColumn - 1] == Cell.ALIVE) {
				neighbours++;
			}
		}

		if (currentRow != 0) {
			if (board[currentRow - 1][currentColumn] == Cell.ALIVE) {
				neighbours++;
			}
		}

		if (currentRow != 0 && currentColumn != columns - 1) {// 3
			if (board[currentRow - 1][currentColumn + 1] == Cell.ALIVE) {
				neighbours++;
			}
		}
		if (currentColumn != 0) {
			if (board[currentRow][currentColumn - 1] == Cell.ALIVE) {
				neighbours++;
			}
		}
		if (currentColumn != columns - 1) {
			if (board[currentRow][currentColumn + 1] == Cell.ALIVE) {
				neighbours++;
			}
		}

		if (currentRow != rows - 1 && currentColumn != 0) {
			if (board[currentRow + 1][currentColumn - 1] == Cell.ALIVE) {
				neighbours++;
			}
		}

		if (currentRow != rows - 1) {
			if (board[currentRow + 1][currentColumn] == Cell.ALIVE) {
				neighbours++;
			}
		}

		if (currentRow != rows - 1 && currentColumn != columns - 1) {
			if (board[currentRow + 1][currentColumn + 1] == Cell.ALIVE) {
				neighbours++;
			}
		}
		return neighbours;
	}

}
