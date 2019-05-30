package app;

import io.ConsolePrinter;
import io.DataReader;
import model.Generation;

public class GameController {
	private ConsolePrinter printer = new ConsolePrinter();
	private DataReader dataReader = new DataReader();
	public static final int TIME_BETWEEN_ITERATIONS_MS = 250;

	public void mainLoop() {
		Generation generation = createGeneration();
		int moves = readMoves();
		playGameOfLife(moves, generation);
	}

	private Generation createGeneration() {
		int rows = 0;
		int cols = 0;
		boolean creatingComplete = false;

		while (!creatingComplete) {
			try {
				printer.print("Enter the number of rows (bigger than 0)");
				rows = dataReader.readInt();
				printer.print("Enter the number of colums (bigger than 0)");
				cols = dataReader.readInt();
				creatingComplete = true;
			} catch (NumberFormatException e) {
				System.err.println("Incorrect input, please try again\n");
			}
		}
		return new Generation(rows, cols);
	}

	private void playGameOfLife(int howManySteps, Generation generation) {
		int counter = 0;
		while (counter <= howManySteps) {
			draw(generation);
			stopTime();
			update(generation);
			counter++;
		}
	}

	private void draw(Generation generation) {
		printer.print("-------------------------------------------");
		generation.print();
	}

	private void update(Generation generation) {
		generation.update();
	}

	private void stopTime() {
		try {
			Thread.sleep(TIME_BETWEEN_ITERATIONS_MS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private int readMoves() {
		int steps = 0;
		boolean readingComplete = false;
		while (!readingComplete) {
			try {
				printer.print("Enter the number of generations: \n");
				steps = dataReader.readInt();
				readingComplete = true;
			} catch (NumberFormatException e) {
				System.err.println("Incorrect input, please try again\n");
			}
		}
		return steps;
	}

}
