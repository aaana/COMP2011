package polyu.competitive.code;

import java.util.Arrays;
import java.util.stream.Collectors;

//import comp2011.lec4.IntQueue;
//import comp2011.lec4.IntStack;

public class GraphInMatrix extends Graph{
    private int order;  // the number of vertices
    private boolean[][] aMatrix;
    
    public GraphInMatrix(int order) {
        this.order = order;
        aMatrix = new boolean[order][order];
        // the following is not really necessary in Java.
        for (int i = 0; i < order; i++)
            for (int j = 0; j < order; j++)
                aMatrix[i][j] = false;
    }

    public GraphInMatrix(boolean[][] aMatrix) {
        order = aMatrix.length;
        // check the matrix is a square and symmetric
        this.aMatrix = aMatrix;
    }
    
    public void addEdge(int a, int b) {
        // usually we don't allow self-loop 
        // i.e., an edge with both ends on the same vertex
        if (a == b) return;
        aMatrix[a][b] = aMatrix[b][a] = true;
    }
    
    public boolean isAdjacent(int a, int b) {
        return aMatrix[a][b];
    }

    // return the degree of vertex a.
    public int degree(int a) {
    	int d = 0;
        for(int i = 0; i < order; i++)
        	d += aMatrix[a][i]?1:0;
    	return d;
    }

    // return the total number of edges in the graph.
    public int size() {
//    	int s = 0;
//        for(int i = 0; i < order; i++)
//        	s += degree(i);
//        return s / 2;
    	int s = 0;
        for(int i = 0; i < order; i++)
        	for(int j = 0; j < i; j++)
        		s += aMatrix[i][j]?1:0;
        return s;
    }

    // check whether the graph contains a triangle
    // i.e., three vertices pairwise adjacent
    public boolean triangle() {
        for(int i = 0; i < order; i++)
            for(int j = 0; j < i; j++) {
            	if (!aMatrix[i][j]) continue;
                for(int k = 0; k < j; k++)
                	if (aMatrix[i][k] && aMatrix[j][k]) return true;
            }
        return false;
    }
    
    public void bfs() { bfs(0); }

    // breadth-first search
    public void bfs(int a) {
//    	int index = 0;
//    	IntQueue q = new IntQueue();
//    	q.enqueue(a);
//
//    	int[] distance = new int[order];
//    	int[] number = new int[order];
//    	// boolean[] visited = new boolean[order];
//    	// visited[a] = true;
//    	number[a] = index++;
//    	int[] parent = new int[order];
//    	for (int i = 0; i < order; i++) parent[i] = -2;
//    	parent[a] = -1;
//
//    	while (!q.isEmpty()) {
//    		int u = q.dequeue();
//    		for (int i = 0; i < order; i++) {
//    			if (!aMatrix[u][i]) continue;
//    			if (parent[i] != -2) continue;
//    			// if (visited[i]) continue;
//    			// visited[i] = true;
//
//    			distance[i] = distance[u] + 1;
//    			parent[i] = u;
//    			number[i] = index++;
//    			q.enqueue(i);
//    		}
//    	}
//    	System.out.println("numbers: " + Arrays.stream(number).mapToObj(Integer::toString).collect(Collectors.joining(", ")));
//    	System.out.println("parents: " + Arrays.stream(parent).mapToObj(Integer::toString).collect(Collectors.joining(", ")));
    }
    
    // depth-first search
    // This version (I wrote in the class) doesn't work.
    // The first correction I received will be rewarded with the heart king.
    public void dfs(int a) {
//    	int[] parent = new int[order];
//		parent[a] = -1;
//    	boolean[] visited = new boolean[order];
//    	IntStack stack = new IntStack();
//    	stack.push(a);
//    	visited[a] = true;
//    	while (!stack.isEmpty()) {
//    		int u = stack.pop();
//    		for (int i = 0; i < order; i++) {
//    			if (!aMatrix[a][i]) continue;
//    			if (visited[i]) continue;
//    			visited[i] = true;
//    			stack.push(u);
//    			stack.push(i);
//    			parent[i] = u;
//    			break;
//    		}
//    	}
    }

    public static void main(String[] args) {
        boolean[][] m1 = {
                {false, false, false, true, false, false, false, false},
                {false, false, false, true, true, false, false, false}, 
                {false, false, false, false, true, false, false, false}, 
                {true, true, false, false, false, true, false, false}, 
                {false, true, true, false, false, false, true, false}, 
                {false, false, false, true, false, false, true, true}, 
                {false, false, false, false, true, true, false, true}, 
                {false, false, false, false, false, true, true, false}};
        GraphInMatrix graph1 = new GraphInMatrix(m1);
        
        boolean[][] m2 = new boolean[8][8];
        m2[0][3] = m2[3][0] = true;
        m2[1][3] = m2[3][1] = true;
        m2[1][4] = m2[4][1] = true;
        m2[2][4] = m2[4][2] = true;
        m2[3][5] = m2[5][3] = true;
        m2[4][6] = m2[6][4] = true;
        m2[5][6] = m2[6][5] = true;
        m2[5][7] = m2[7][5] = true;
        m2[6][7] = m2[7][6] = true;
        GraphInMatrix graph2 = new GraphInMatrix(m1);
        System.out.println("Breadth-first search: ");  
        graph2.bfs();

        GraphInMatrix graph = new GraphInMatrix(8);
        System.out.println("The degree of vertex " + 2 + " is "  
        		+ graph.degree(2) + ".");
        System.out.println("Vertices " + 2 + " and " + 4 + " are" 
        		+ (graph.isAdjacent(2,4)?"":" not") + " adjacent.");
        graph.addEdge(0, 3); graph.addEdge(1, 3); graph.addEdge(1, 4); 
        graph.addEdge(2, 4); graph.addEdge(3, 5); graph.addEdge(4, 6);
        graph.addEdge(5, 6); graph.addEdge(5, 7); graph.addEdge(6, 7);
        System.out.println("Vertices " + 2 + " and " + 4 + " are" 
        		+ (graph.isAdjacent(2,4)?"":" not") + " adjacent.");
        System.out.println("The degree of vertex " + 2 + " is "  
        		+ graph.degree(2) + ".");
        System.out.println("The graph has " + graph.size() + " edges.");
        //System.out.println(graph.draw());
    }
}
