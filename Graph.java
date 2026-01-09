import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Graph {

    int[][] adjMatrix;
    int vertices;
    ArrayList<String> cityNames;

    Graph() {
        this.vertices = 0;
        adjMatrix = new int[0][0];
        cityNames = new ArrayList<>();
    }

    // ================== VERTEX FUNCTIONS ==================
    // Add city
    // Time: O(V^2), Space: O(1)
    public void addCity(String city) {
        cityNames.add(city);
        addVertex();
        System.out.println("City added: " + city);
    }

    // Internal method to expand matrix
    // Time: O(V^2), Space: O(V^2)
    private void addVertex() {
        int[][] newMatrix = new int[vertices + 1][vertices + 1];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                newMatrix[i][j] = adjMatrix[i][j];
            }
        }
        adjMatrix = newMatrix;
        vertices++;
    }

    // Delete city
    // Time: O(V^2), Space: O(V^2)
    public void deleteCity(int index) {
        if (index < 0 || index >= vertices) {
            System.out.println("Invalid vertex index!");
            return;
        }
        System.out.println("City deleted: " + cityNames.get(index));
        cityNames.remove(index);

        int[][] newMatrix = new int[vertices - 1][vertices - 1];
        for (int i = 0, ni = 0; i < vertices; i++) {
            if (i == index) continue;
            for (int j = 0, nj = 0; j < vertices; j++) {
                if (j == index) continue;
                newMatrix[ni][nj++] = adjMatrix[i][j];
            }
            ni++;
        }
        adjMatrix = newMatrix;
        vertices--;
    }

    // ================== EDGE FUNCTIONS ==================
    // Add undirected edge
    // Time: O(1), Space: O(1)
    public void addEdge(int src, int des) {
        if (src < 0 || des < 0 || src >= vertices || des >= vertices) {
            System.out.println("Invalid edge!");
            return;
        }
        adjMatrix[src][des] = 1;
        adjMatrix[des][src] = 1;
        System.out.println("Added undirected edge: " + cityNames.get(src) + " ↔ " + cityNames.get(des));
    }

    // Add directed edge
    // Time: O(1), Space: O(1)
    public void addDirectedEdge(int src, int des) {
        if (src < 0 || des < 0 || src >= vertices || des >= vertices) {
            System.out.println("Invalid edge!");
            return;
        }
        adjMatrix[src][des] = 1;
        System.out.println("Added directed edge: " + cityNames.get(src) + " → " + cityNames.get(des));
    }

    // Remove edge
    // Time: O(1), Space: O(1)
    public void removeEdge(int src, int des) {
        if (src < 0 || des < 0 || src >= vertices || des >= vertices) {
            System.out.println("Invalid edge!");
            return;
        }
        adjMatrix[src][des] = 0;
        adjMatrix[des][src] = 0;
        System.out.println("Removed edge between: " + cityNames.get(src) + " ↔ " + cityNames.get(des));
    }

    // ================== TRAVERSALS ==================
    // DFS
    // Time: O(V^2), Space: O(V)
    public void DFS(int start) {
        if (start < 0 || start >= vertices) {
            System.out.println("Invalid start index for DFS.");
            return;
        }
        boolean[] visited = new boolean[vertices];
        System.out.println("\nDFS Traversal:");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(cityNames.get(start) + " -> ");
        for (int i = 0; i < vertices; i++) {
            if (adjMatrix[start][i] == 1 && !visited[i]) {
                dfsHelper(i, visited);
            }
        }
    }

    // BFS
    // Time: O(V^2), Space: O(V)
    public void BFS(int start) {
        if (start < 0 || start >= vertices) {
            System.out.println("Invalid start index for BFS.");
            return;
        }
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        System.out.println("\nBFS Traversal:");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(cityNames.get(node) + " -> ");
            for (int i = 0; i < vertices; i++) {
                if (!visited[i] && adjMatrix[node][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    // ================== PRINT ADJACENCY MATRIX ==================
    // Time: O(V^2), Space: O(1)
    public void printMatrix() {
        System.out.println("\nAdjacency Matrix:");
        System.out.print("      ");
        for (String name : cityNames) {
            System.out.printf("%10s", name);
        }
        System.out.println();

        for (int i = 0; i < vertices; i++) {
            System.out.printf("%10s", cityNames.get(i));
            for (int j = 0; j < vertices; j++) {
                System.out.printf("%10d", adjMatrix[i][j]);
            }
            System.out.println();
        }
    }
}

// ================== MAIN ==================
class Main {
    public static void main(String[] args) {

        Graph g = new Graph();

        g.addCity("Karachi");
        g.addCity("Lahore");
        g.addCity("Islamabad");
        g.addCity("Quetta");

        // ADD EDGES
        g.addEdge(0, 1);            // undirected
        g.addEdge(0, 2);            // undirected
        g.addDirectedEdge(1, 3);    // directed Lahore → Quetta

        // SHOW MATRIX
        g.printMatrix();

        // DFS + BFS
        g.DFS(0);
        g.BFS(0);

        // DELETE A CITY
        g.deleteCity(1); // delete Lahore

        // SHOW UPDATED MATRIX
        g.printMatrix();

        // DFS + BFS again after deletion
        g.DFS(0);
        g.BFS(0);
    }
}
