package eightPuzzle;

import java.util.ArrayList;

public class SolutionDetails {
    private ArrayList<Node> solutionSteps;
    private ArrayList<Node> visited;
    private double solutionCost;

    public void setSolutionCost(double cost) {
        this.solutionCost = cost;
    }

    public double getSolutionCost() {
        return this.solutionCost;
    }

    public void setSolutionSteps(ArrayList<Node> solutionSteps) {
        this.solutionSteps = solutionSteps;
    }

    public void setVisitedNodes(ArrayList<Node> visited) {
        this.visited = visited;
    }

    public ArrayList<Node> getsolutionSteps() {
        return this.solutionSteps;
    }

    public ArrayList<Node> getVisitedNodes() {
        return this.visited;
    }
}
