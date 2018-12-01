package eightPuzzle;

import java.util.*;

public class NonHeuristicAlgorithms {

    public static void main(String[] args) {

    }


    public SolutionDetails DFS(Node root) {
        SolutionDetails solution = new SolutionDetails();
        Stack<Node> frontier = new Stack<>();
        ArrayList<Node> visited = new ArrayList<>();

        frontier.add(root);

        while (!frontier.isEmpty()) {
            Node current = frontier.pop();
            visited.add(current);

            if (OperationsOnNode.goalTest(current.puzzle)) {
                solution.setSolutionSteps(OperationsOnNode.pathToParent(current));
                solution.setVisitedNodes(visited);
                solution.setSolutionCost(current.level);
                break;
            }

            OperationsOnNode.expandNode(current);

            ArrayList<Node> childrenOfCurrent = current.children;
            for (int i = 0; i < childrenOfCurrent.size(); i++) {
                Node child = childrenOfCurrent.get(i);
                if (!OperationsOnNode.listContains(visited, child) && !OperationsOnNode.listContains(frontier, child)) {
                    frontier.push(child);
                }
            }
        }
        return solution;
    }

    public SolutionDetails BFS(Node root) {
        SolutionDetails solution = new SolutionDetails();
        Queue<Node> frontier = new LinkedList<>();
        ArrayList<Node> visited = new ArrayList<>();

        frontier.add(root);

        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            visited.add(current);

            if (OperationsOnNode.goalTest(current.puzzle)) {
                solution.setSolutionSteps(OperationsOnNode.pathToParent(current));
                solution.setVisitedNodes(visited);
                solution.setSolutionCost(current.level);
                break;
            }

            OperationsOnNode.expandNode(current);

            ArrayList<Node> childrenOfCurrent = current.children;
            for (int i = 0; i < childrenOfCurrent.size(); i++) {
                Node child = childrenOfCurrent.get(i);
                if (!OperationsOnNode.listContains(visited, child) && !OperationsOnNode.listContains(frontier, child)) {
                    frontier.add(child);
                }
            }
        }
        return solution;
    }
}
