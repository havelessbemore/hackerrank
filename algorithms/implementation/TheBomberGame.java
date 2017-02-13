//https://www.hackerrank.com/challenges/bomber-man

import java.util.Scanner;

class TheBomberGame {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int row = in.nextInt();
		int col = in.nextInt();
		char grid[][] = new char[row][col];
		long n = in.nextLong();
		String s;
		// Take Input
		for (int i = 0; i < row; i++) {
			s = in.next();
			for (int j = 0; j < col; j++) {
				grid[i][j] = s.charAt(j);
			}
		}
		if (n == 1) {
			printGrid(grid, row, col);
		} else if (n % 2 == 0) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					System.out.print('O');
				}
				System.out.println();
			}
		} else if ((n - 3) % 4 == 0) {
			manipulateGrid(grid, row, col);
			printGrid(grid, row, col);
		} else {
			manipulateGrid(grid, row, col);
			manipulateGrid(grid, row, col);
			printGrid(grid, row, col);
		}

	}

	// Make Changes to grid
	public static char[][] manipulateGrid(char[][] grid, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 'O') {
					grid[i][j] = '|';
					if (i + 1 < row && grid[i + 1][j] != 'O')
						grid[i + 1][j] = '|';
					if (j + 1 < col && grid[i][j + 1] != 'O')
						grid[i][j + 1] = '|';
					if (i - 1 >= 0 && grid[i - 1][j] != 'O')
						grid[i - 1][j] = '|';
					if (j - 1 >= 0 && grid[i][j - 1] != 'O')
						grid[i][j - 1] = '|';
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '|') {
					grid[i][j] = '.';
				} else if (grid[i][j] == '.') {
					grid[i][j] = 'O';
				}
			}
		}
		return grid;
	}

	// Print Grid
	private static void printGrid(char[][] grid, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
}
