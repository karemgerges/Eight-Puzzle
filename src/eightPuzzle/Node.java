package eightPuzzle;

import java.util.*;

public class Node {

    public ArrayList<Node> children = new ArrayList<>();
    public Node parent;
    public int[] puzzle;
    public int level = 0;

    public Node(int[] p) {
        this.puzzle = p;
    }
}