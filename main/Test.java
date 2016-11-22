package main;

import java.util.Random;
import java.util.Scanner;

public class Test
{

	public static void main(String[] args)
	{
		String in;
		Scanner scan = new Scanner(System.in);
		boolean run = false;

		Random rand = new Random();

		System.out.println((rand.nextInt(8) + 1) - (rand.nextInt(4) + 1));
		/*
		 * do{ System.out.println(getRandomDescription()); in = scan.next();
		 * switch (in){ case "done": run = true; break; } }while (!run);
		 */
	}

	public static int test()
	{
		Random rand = new Random();

		int test = rand.nextInt(2) + 1;

		return test;
	}

	public static String getRandomDescription()
	{
		Random rand = new Random();
		String description = null;

		switch (rand.nextInt(4) + 1)
		{
		case 1:
			description = "A normal skeleton, nothing to worry about";
			break;
		case 2:
			description = "A brittle looking skeleton";
			break;
		case 3:
			description = "The skeleton is using his arm as a sword";
			break;
		case 4:
			description = "A skeleton with dark bones. Better use caution";
			break;
		}
		return description;
	}
}
