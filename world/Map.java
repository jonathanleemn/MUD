package world;

import java.util.Random;
import java.util.Scanner;

public class Map
{
	int[][] map = new int[20][20];
	Location loc;
	Random rand = new Random();
	Scanner input = new Scanner(System.in);
	char direction;

	public Map(int locX, int locY)
	{
		loc = new Location(locX, locY);
	}

	public void fillMap()
	{
		for (int row = 0; row < map.length; row++)
		{
			for (int col = 0; col < map[row].length; col++)
			{
				map[row][col] = rand.nextInt(9);
			}
		}
	}

	public boolean isValidMove(int nextLoc)
	{
		return nextLoc<map.length && nextLoc > 0;
	}

	public void makeMove(char direction)
	{
		System.out.println("Which direction do you want to move in? (w = north, a = west, s = south, d = east) ");
		direction = input.next().charAt(0);
		
		switch(direction)
		{
		case 'w':
		case 'W':
			loc.setRow(loc.getRow()-1);
			break;
		case 'a':
		case 'A':
			loc.setCol(loc.getCol()-1);
			break;
		case 's':
		case 'S':
			loc.setRow(loc.getRow()+1);
			break;
		case 'd':
		case 'D':
			loc.setCol(loc.getCol()+1);
			break;
		
		}
	}

}
