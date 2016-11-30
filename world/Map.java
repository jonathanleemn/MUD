package world;

import java.util.Random;
import game.*;
import java.util.Scanner;

import entities.Player;
import game.Game;

public class Map
{
	int[][] map = new int[10][10];
	Location loc;
	Random rand = new Random();
	Scanner input = new Scanner(System.in);
	char direction;
	Player player;

	public Map(Player player)
	{
		this.player = player;
	}
	
	public void resetMap(){
		for (int row = 0; row < map.length; row++)
		{
			for (int col = 0; col < map[row].length; col++)
			{
				map[row][col] = 0;
			}
		}
	}

	public void fillMap()
	{
		for (int row = 0; row < map.length; row++)
		{
			for (int col = 0; col < map[row].length; col++)
			{
				if (map[row][col] != map[player.loc.getRow()][player.loc.getCol()])
					map[row][col] = 0;
			}
		}
	}

	public boolean isValidMove(int nextLoc)
	{
		return nextLoc<map.length && nextLoc > 0;
	}

	public void makeMove()
	{
		System.out.println("Which direction do you want to move in? (w = north, a = west, s = south, d = east) ");
		direction = input.next().charAt(0);
		int tempY = player.loc.getRow();
		int tempX = player.loc.getCol();
		
		try{
		switch(direction)
		{
		case 'w':
		case 'W':
			player.loc.setRow(player.loc.getRow()-1);
			
			break;
		case 'a':
		case 'A':
			player.loc.setCol(player.loc.getCol()-1);
			break;
		case 's':
		case 'S':
			player.loc.setRow(player.loc.getRow()+1);
			break;
		case 'd':
		case 'D':
			player.loc.setCol(player.loc.getCol()+1);
			break;
		}
		} catch (ArrayIndexOutOfBoundsException e){
			player.loc.setRow( tempY);
			player.loc.setCol(tempX);
			System.out.println("You've run into a wall, good job.");
		}
		
		fillMap();
	}

}