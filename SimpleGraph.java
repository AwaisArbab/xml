
import java.util.LinkedList;
import java.util.Queue;

public class SimpleGraph {
    int[][] adjMatrix;
    int vertices;

    // Constructor
    // Time: O(V^2), Space: O(V^2)
    SimpleGraph(int vertices){
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    // Add a vertex
    // Time: O(V^2), Space: O(V^2)
    public void addVertex(){
        int[][] newMatrix = new int[vertices+1][vertices+1];

        for(int i = 0 ; i < vertices; i++){
            for(int j = 0 ; j < vertices; j++){
                newMatrix[i][j] = adjMatrix[i][j];
            }
        }
        adjMatrix = newMatrix;
        vertices++;
    }

    // Delete a vertex
    // Time: O(V^2), Space: O(V^2)
    public void deleteVertex(int vertex){
        int[][] newMatrix = new int[vertices-1][vertices-1];

        for(int i = 0, ni = 0; i < vertices; i++){
            if(i == vertex) continue;
            for(int j = 0, nj = 0; j < vertices; j++){
                if(j == vertex) continue;
                newMatrix[ni][nj++] = adjMatrix[i][j];
            }
            ni++;
        }
        vertices--;
        adjMatrix = newMatrix;
    }

    // Add an undirected edge
    // Time: O(1), Space: O(1)
    public void addEdge(int src , int des){
        if(src < 0 || des < 0 || src >= vertices || des >= vertices){
            System.out.println("Invalid index");
            return;
        }
        adjMatrix[src][des] = 1;
        adjMatrix[des][src] = 1;
    }

    // Remove an undirected edge
    // Time: O(1), Space: O(1)
    public void removeEdge(int src , int des){
        if(src < 0 || des < 0 || src >= vertices || des >= vertices){
            System.out.println("Invalid index");
            return;
        }
        adjMatrix[src][des] = 0;
        adjMatrix[des][src] = 0;
    }

    // DFS traversal
    // Time: O(V^2), Space: O(V) for visited array + recursion stack
    public void DFS(int start){
        if(start < 0 || start >= vertices) return;
        boolean[] visited = new boolean[vertices];
        visited[start] = true;
        dfshelper(start, visited);
        System.out.println();
    }

    // DFS helper
    // Time: O(V^2), Space: O(V) recursion stack
    private void dfshelper(int start, boolean[] visited){
        System.out.print(start + "---"); // print node
        for(int i = 0; i < vertices; i++){
            if(adjMatrix[start][i] == 1 && !visited[i]){
                visited[i] = true;
                dfshelper(i, visited);
            }
        }
    }

    // BFS traversal
    // Time: O(V^2), Space: O(V) for visited array + queue
    public void BFS(int start){
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(start);
        boolean[] visited = new boolean[vertices];
        int i;

        while(!bfsQueue.isEmpty()){
            i = bfsQueue.poll();
            System.out.print(i + "---");
            visited[i] = true;
            for(int j = 0; j < vertices; j++){
                if(adjMatrix[i][j] == 1 && !visited[j]){
                    bfsQueue.add(j);
                    visited[j] = true;
                }
            }

        }

    }

    public static void main(String[] args) {
        SimpleGraph graph = new SimpleGraph(4);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.BFS(0);
    }

}
