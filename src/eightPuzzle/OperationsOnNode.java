package eightPuzzle;

import java.util.*;

public class OperationsOnNode {

    private static int NUM_OF_COL = 3;
    private static int LENGTH_OF_PUZZLE = 9;

    public static void moveToRight(Node n, int indexOfZero) {
        if (indexOfZero % NUM_OF_COL > 0) {
            int[] puzzleCopy = Arrays.copyOf(n.puzzle, n.puzzle.length);
            int temp = puzzleCopy[indexOfZero - 1];
            puzzleCopy[indexOfZero - 1] = puzzleCopy[indexOfZero];
            puzzleCopy[indexOfZero] = temp;
            Node child = new Node(puzzleCopy);
            n.children.add(child);
            child.parent = n;
            child.level = child.parent.level + 1;
        }
    }

    public static void moveToLeft(Node n, int indexOfZero) {
        if (indexOfZero % NUM_OF_COL < NUM_OF_COL - 1) {
            int[] puzzleCopy = Arrays.copyOf(n.puzzle, n.puzzle.length);
            int temp = puzzleCopy[indexOfZero + 1];
            puzzleCopy[indexOfZero + 1] = puzzleCopy[indexOfZero];
            puzzleCopy[indexOfZero] = temp;
            Node child = new Node(puzzleCopy);
            n.children.add(child);
            child.parent = n;
            child.level = child.parent.level + 1;
        }
    }

    public static void moveToUp(Node n, int indexOfZero) {
        if (indexOfZero < 6) {
            int[] puzzleCopy = Arrays.copyOf(n.puzzle, n.puzzle.length);
            int temp = puzzleCopy[indexOfZero + 3];
            puzzleCopy[indexOfZero + 3] = puzzleCopy[indexOfZero];
            puzzleCopy[indexOfZero] = temp;
            Node child = new Node(puzzleCopy);
            n.children.add(child);
            child.parent = n;
            child.level = child.parent.level + 1;
        }
    }

    public static void moveToDown(Node n, int indexOfZero) {
        if (indexOfZero > 2) {
            int[] puzzleCopy = Arrays.copyOf(n.puzzle, n.puzzle.length);
            int temp = puzzleCopy[indexOfZero - 3];
            puzzleCopy[indexOfZero - 3] = puzzleCopy[indexOfZero];
            puzzleCopy[indexOfZero] = temp;
            Node child = new Node(puzzleCopy);
            n.children.add(child);
            child.parent = n;
            child.level = child.parent.level + 1;
        }

    }

    public static void expandNode(Node n) {
        int indexOfZero = 0;
        for (int i = 0; i < n.puzzle.length; i++) {
            if (n.puzzle[i] == 0) {
                indexOfZero = i;
                break;
            }
        }
        moveToRight(n, indexOfZero);
        moveToLeft(n, indexOfZero);
        moveToUp(n, indexOfZero);
        moveToDown(n, indexOfZero);
    }

    public static boolean goalTest(int[] p) {
        boolean goalTest = true;
        for (int i = 0; i < p.length; i++) {
            if (i != p[i]) {
                goalTest = false;
                break;
            }
        }
        return goalTest;
    }

    public static boolean isSamePuzzle(int[] p1, int[] p2) {
        boolean sameTest = true;
        for (int i = 0; i < LENGTH_OF_PUZZLE; i++) {
            if (p1[i] != p2[i]) {
                sameTest = false;
            }
        }
        return sameTest;
    }

    public static boolean listContains(List<Node> list, Node node) {
        for (Node inList : list) {
            if (isSamePuzzle(inList.puzzle, node.puzzle)) {
                return true;
            }
        }
        return false;
    }

    public static boolean listContains(Queue<Node> queue, Node node) {
        return listContains(((List) queue), node);
    }

    public static boolean listContains(Stack<Node> stack, Node node) {
        return listContains((List) stack, node);
    }

    public static Pair heapContains(PriorityQueue<Pair> heap, Node node) {
        for (Pair inList : heap) {
            if (isSamePuzzle(inList.node.puzzle, node.puzzle)) {
                return inList;
            }
        }
        return null;
    }

    public static ArrayList<Node> pathToParent(Node currentNode) {
        ArrayList<Node> pathToParent = new ArrayList<>();
        while (currentNode.parent != null) {
            pathToParent.add(currentNode);
            currentNode = currentNode.parent;
        }
        return pathToParent;
    }

    public static void updateHeap(PriorityQueue<Pair> heap, Pair pair, double newCost) {
        heap.remove(pair);
        heap.add(new Pair(pair.node, newCost));
    }

    public static void printPuzzle(int[] puzzle) {
        for (int i = 0; i < puzzle.length; i++) {
            System.out.print(puzzle[i] + " ");
            if ((i + 1) % 3 == 0)
                System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public static void printSolution(SolutionDetails solutionDetails) {
        System.out.println("Solution cost = " + solutionDetails.getSolutionCost());
        for (int i = solutionDetails.getsolutionSteps().size() - 1; i >=0; i--) {
            OperationsOnNode.printPuzzle(solutionDetails.getsolutionSteps().get(i).puzzle);
        }
    }

    public static void printNodesVisited(SolutionDetails solutionDetails) {
        for (int i = solutionDetails.getVisitedNodes().size() - 1; i >=0; i--) {
            OperationsOnNode.printPuzzle(solutionDetails.getVisitedNodes().get(i).puzzle);
        }
    }
}