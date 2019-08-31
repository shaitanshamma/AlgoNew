package lesson7;

import java.util.*;

public class Graph {

    private final List<Vertex> vertexList;
    private final boolean[][] adjMat;

    private String startPoint;

    Stack<Vertex> stack = new Stack<>();

    private int size;

    public Graph(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
        this.size = 0;
    }

    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
        size++;
    }

    public int getSize() {
        return size;
    }

    public void addEdges(String startLabel, String secondLabel, String... others) {
        addEdge(startLabel, secondLabel);
        for (String anotherLabel : others) {
            addEdge(startLabel, anotherLabel);
        }
    }

    public void addEdge(String startLabel, String finishLabel) {
        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);

        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException(String.format("Invalid labels for vertexes: %s; %s",
                    startLabel, finishLabel));
        }

        adjMat[startIndex][finishIndex] = true;
        adjMat[finishIndex][startIndex] = true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }

        return -1;
    }

    private Vertex contains(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < size; j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    /**
     * англ. Depth-first search, DFS
     *
     * @param startLabel
     */
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();

        Vertex vertex = vertexList.get(startIndex);
        visitVertex(stack, vertex);

        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }

        resetVertexState();
    }


    /**
     * англ. breadth-first search, BFS
     *
     * @param startLabel
     */
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = vertexList.get(startIndex);
        visitVertex(queue, vertex);

        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }

        resetVertexState();
    }

    private void resetVertexState() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex peek) {
        int peekIndex = vertexList.indexOf(peek);
        for (int i = 0; i < size; i++) {
            if (adjMat[peekIndex][i] && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }

        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel());
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
      //  System.out.println(vertex.getLabel());
        queue.add(vertex);
        vertex.setVisited(true);
    }

    public void testPath(String startPoints, String endPoint) {
        this.startPoint = startPoints;
        int startPointIndex = indexOf(startPoint);
        int endPointIndex = indexOf(endPoint);

        if (startPointIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startPointIndex);
        }

        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = vertexList.get(startPointIndex);
        Vertex vertexEnd = vertexList.get(endPointIndex);
        visitVertex(queue, vertex);
        stack.push(vertexEnd);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null && !vertex.equals(vertexEnd)) {

                visitVertex(queue, vertex);

            } else {
                queue.remove();

            }
        }
        printPath(vertexEnd);

        System.out.println("------------------------");
        System.out.println("Кратчайший путь " + startPoint + " -> " + endPoint + ":");

        while (!stack.empty()) {
            System.out.print(stack.pop().getLabel()+ "  ");
        }
        resetVertexState();
    }

    public Vertex printPath(Vertex vertex) {

        int endPointIndex = vertexList.indexOf(vertex);

        if (!vertex.getLabel().equals(startPoint)) {
            for (int i = 0; i < size; i++) {
                if (adjMat[endPointIndex][i] && vertexList.get(i).isVisited()) {
                    stack.push(vertexList.get(i));
                    return printPath(vertexList.get(i));
                }
            }
        }
        return vertex;
    }
}
