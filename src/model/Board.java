package model;

import java.util.Random;

import javax.swing.CellRendererPane;

public class Board {
//	private int rows;
//	private int cols;
	private final static int BOARD_HEIGHT = 25;
	private Cell[][] plansza;

	public Board() {
		plansza = new Cell[BOARD_HEIGHT][BOARD_HEIGHT];
	}

	public void createFirstGeneration() {

		for (int i = 0; i < BOARD_HEIGHT; i++) {
			for (int j = 0; j < BOARD_HEIGHT; j++) {
				Random rand = new Random();
				boolean value = rand.nextBoolean();
				if (value) {
					plansza[i][j] = Cell.ALIVE;
				} else {
					plansza[i][j] = Cell.DEAD;
				}
			}
		}
	}


	public void print() {
		for (int i = 0; i < BOARD_HEIGHT; i++) {
			for (int j = 0; j < BOARD_HEIGHT; j++) {
				System.out.print(plansza[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void update() {
//		for (int i = 0; i < BOARD_HEIGHT; i++) {
//			for (int j = 0; j < BOARD_HEIGHT; j++) {
//
//				bornOrDie(plansza[i][j]);
//			}
//		}
		
		for(int i = 0; i < BOARD_HEIGHT; i++) {
			for(int j =  0; j < BOARD_HEIGHT; j++) {
				int howMany = neighboursCountAt(i,j);
				
				if(howMany == 3 || (howMany == 2 && plansza[i][j] == Cell.ALIVE)) {
					plansza[i][j] = Cell.ALIVE;
				} else {
					plansza[i][j] = Cell.DEAD;
				}
			}
		}
		
	}

	
	private int neighboursCountAt(int row, int col) {
		int sum = 0;
		
		  if (row != 0 && col != 0){    //1
	            if(plansza[row-1][ col-1] == Cell.ALIVE) {
	            	sum++;
	            }
	        }
	        
	        if (row != 0){
//	            if(isAlive(row-1,col)){ //2
	            	if(plansza[row-1][ col] == Cell.ALIVE) {
	            sum++;
	            }
	        }
	        
	        if (row != 0 && col != BOARD_HEIGHT-1){//3
//	            if(isAlive(row-1,col+1)){
	            	if(plansza[row-1][ col+1] == Cell.ALIVE) {
	                sum++;
	            }
	        }
	        if (col != 0){
//	            if(isAlive(row,col-1)){ //4
	            	if(plansza[row][ col-1] == Cell.ALIVE) {
	            sum++;
	            }
	        }
	        //self
	        if (col != BOARD_HEIGHT-1){
//	            if(isAlive(row,col+1)){ //6
	        	if(plansza[row][ col+1] == Cell.ALIVE) {
	                sum++;
	            }
	        }

	        if (row != BOARD_HEIGHT-1 && col != 0){
	        	if(plansza[row+1][ col-1] == Cell.ALIVE) {
//	            if(isAlive(row+1,col-1)){ //7
	                sum++;
	            }
	        }

	        if (row != BOARD_HEIGHT-1){
//	            if(isAlive(row+1,col)){ //8
	            	if(plansza[row+1][ col] == Cell.ALIVE) {
	            sum++;
	            }
	        }

	        if (row != BOARD_HEIGHT-1 && col != BOARD_HEIGHT-1){
//	            if(isAlive(row+1,col+1)){ //9
	        	if(plansza[row+1][ col+1] == Cell.ALIVE) {
	                sum++;
	            }
	        }

	        return sum;
		
	}


	private void bornOrDie(Cell singleCell) throws ArrayIndexOutOfBoundsException {
		for (int i = 0; i < BOARD_HEIGHT; i++) {
			for (int j = 0; j < BOARD_HEIGHT; j++) {

//				int neigbours = calculateNeigbours();
//				int neigbours = 0;
//
//				if (singleCell.isValue()) {
//					if (neigbours < 2 || neigbours > 3) {
//						singleCell.setValue(false);
//					}
//				} else {
//					if (neigbours == 3) {
//						singleCell.setValue(true);
//					}
//				}
			}
		}
	}

}
