package io;

import java.util.Scanner;

public class DataReader {
	private Scanner input = new Scanner(System.in);
	
	public int readInt() {
		
		int result = Integer.parseInt(input.nextLine());

		if(result <= 0 || result > 100) {
			throw new NumberFormatException();
		}
		return result;
	}

}
