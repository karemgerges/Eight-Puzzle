package eightPuzzle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AStar {
    public SolutionDetails AStarSearchEuclid(Node root) {
        SolutionDetails solution = new SolutionDetails();
        PriorityQueue<Pair> frontier = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return new Double(o1.cost).compareTo(new Double(o2.cost));
            }
        });

        ArrayList<Node> visited = new ArrayList<>();
        frontier.add(new Pair(root, 0));

        while (!frontier.isEmpty()) {
            Pair current = frontier.poll();
            visited.add(current.node);

            if (OperationsOnNode.goalTest(current.node.puzzle)) {
                solution.setSolutionSteps(OperationsOnNode.pathToParent(current.node));
                solution.setVisitedNodes(visited);
                solution.setSolutionCost(current.cost);
                break;
            }

            OperationsOnNode.expandNode(current.node);
            for (Node child : current.node.children) {
                int euclidDistance = Heuristic.calculateEuclideanDistance(child.puzzle);

                Pair heapContains = OperationsOnNode.heapContains(frontier, child);
                if (!OperationsOnNode.listContains(visited, child) && heapContains == null) {
                    Pair newPair = new Pair(child, child.level + euclidDistance);
                    frontier.add(newPair);
                    visited.add(child);
                } else if (heapContains != null) {
                    if (heapContains.cost > heapContains.node.level + euclidDistance) {
                        OperationsOnNode.updateHeap(frontier, heapContains, heapContains.node.level + euclidDistance);
                    }
                }
            }
        }

        return solution;
    }

    public SolutionDetails AStarSearchManhattan(Node root) {
        SolutionDetails solution = new SolutionDetails();
        PriorityQueue<Pair> frontier = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return new Double(o1.cost).compareTo(new Double(o2.cost));
            }
        });

        ArrayList<Node> visited = new ArrayList<>();
        frontier.add(new Pair(root, 0));

        while (!frontier.isEmpty()) {
            Pair current = frontier.poll();
            visited.add(current.node);

            if (OperationsOnNode.goalTest(current.node.puzzle)) {
                solution.setSolutionSteps(OperationsOnNode.pathToParent(current.node));
                solution.setVisitedNodes(visited);
                solution.setSolutionCost(current.cost);
                break;
            }

            OperationsOnNode.expandNode(current.node);
            for (Node child : current.node.children) {
                int manhattanDistance = Heuristic.calculateManhattanDistance(child.puzzle);

                Pair heapContains = OperationsOnNode.heapContains(frontier, child);
                if (!OperationsOnNode.listContains(visited, child) && heapContains == null) {
                    Pair newPair = new Pair(child, child.level + manhattanDistance);
                    frontier.add(newPair);
                    visited.add(child);
                } else if (heapContains != null) {
                    if (heapContains.cost > heapContains.node.level + manhattanDistance) {
                        OperationsOnNode.updateHeap(frontier, heapContains, heapContains.node.level + manhattanDistance);
                    }
                }
            }
        }

        return solution;
    }

}
