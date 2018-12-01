package eightPuzzle;
import java.util.*;

public class Main {
	
	void printPuzzle(int[] p)
	{
		int n =0;
		for(int i =0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				System.out.print(p[n] + "   ");
				n++;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		int[] p = {1,4,2,3,0,5,6,7,8};
		Node n = new Node(p);
		NonHeuristicAlgorithms non = new NonHeuristicAlgorithms();
//                DFS dfs = new DFS();
                
		SolutionDetails sol = new SolutionDetails();
                sol = non.DFS(n);
//                long startTime = System.nanoTime();
////		sol = ast.AStarSearchEuclid(n);
//		long endTime   = System.nanoTime();
//		long totalTime = endTime - startTime;
                ArrayList<Node> visited = sol.getVisitedNodes();
		//ArrayList<Node> steps = sol.getsolutionSteps();
                int Max = 0;
		for(int i=0;i < visited.size(); i++)
		{
                    if(visited.get(i).level > Max)
			{
				Max = visited.get(i).level;
			}
			m.printPuzzle(visited.get(i).puzzle);
                        System.out.println("");
		}
		          System.out.println("Max Depth is : " + Max);
//                          System.out.println("Running Time is : " + totalTime + "Nano Second");
	}
}
