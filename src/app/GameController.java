package app;

import io.ConsolePrinter;
import io.DataReader;
import model.Board;

public class GameController {
	private ConsolePrinter printer = new ConsolePrinter();
	private static final int STEPS = 100;
	private DataReader dataReader = new DataReader();
	private Board board;
	public static final int TIME_BETWEEN_ITERATIONS_MS = 150;
	public void mainLoop() throws InterruptedException {
		int counter = 0;

//		printer.print("Witaj w Game of Life");

		// 1. wczytaj dane od u¿ytkownika
		 board = createBoard();

		// 2. stwórz pierwsz¹ generacjê
		 board.createFirstGeneration();
		 
		 
		// 3. zapêtl
		while (true) {
			counter++;
//			printer.print("Generacja " + counter);
//			System.out.println("___________________________________");
			board.print();
			Thread.sleep(TIME_BETWEEN_ITERATIONS_MS);
//			try {
			board.update();
//			} catch(ArrayIndexOutOfBoundsException e) {
//				sys
//			}
		}


	}

	private Board createBoard() {
		int rows = 0;
		int cols = 0;
		boolean readingComplete = false;

		while (!readingComplete) {

//			try {
//				printer.print("Podaj liczbê wierszy: ");
//				rows = dataReader.readInt();
//				printer.print("Podaj liczbê kolumn: ");
//				cols = dataReader.readInt();
//				board = new Board(rows, cols);
//				readingComplete = true;
//
//				// osobny wyj¹tek dla liczb ujemnych dopisaæ
//			} catch (NumberFormatException e) {
//				System.err.println("nieprawid³owa liczba");
//			}
			
			board = new Board();
			readingComplete = true;
		}
		return board;
	}


}
