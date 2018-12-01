package eightPuzzle;

public class Heuristic {
	
	public static int calculateEuclideanDistance(int[] puzzle)
	{
		int euclideanDist = 0;
		int xdistance;
		int ydistance;
		for(int i = 0; i < puzzle.length; i++)
		{
			xdistance = calculate_x_distance(i,puzzle[i]);
			ydistance = calculate_y_distance(i,puzzle[i]);
			euclideanDist += Math.sqrt(Math.pow(Math.abs(xdistance), 2) + Math.pow(Math.abs(ydistance),2));
		}
		return euclideanDist;
	}
	public static int calculateManhattanDistance(int[] puzzle)
	{
		int manhattanDist = 0;
		int xdistance;
		int ydistance;
		for(int i = 0; i < puzzle.length; i++)
		{
			xdistance = calculate_x_distance(i,puzzle[i]);
			ydistance = calculate_y_distance(i,puzzle[i]);
			manhattanDist += Math.abs(xdistance) + Math.abs(ydistance);
		}
		return manhattanDist;
	}
	
	private static int calculate_x_distance(int index , int number)
	{
		int xdistance = index % 3 - number%3;
		return xdistance;
	}

	private static int calculate_y_distance(int index , int number)
	{
		int ydistance = index / 3 - number / 3;
		return ydistance;
	}
	
	public static void main(String[] args) {
		int[] p = {0,1,2,3,7,8,4,5,6};
		Heuristic x = new Heuristic();
		System.out.println(x.calculateEuclideanDistance(p));
	}

}
