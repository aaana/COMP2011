package polyu.comp.datastructure.assign4;

import java.util.Arrays;
import java.util.stream.Collectors;


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
    }
    
    public void dfs(int a) {
    }

    public GraphInMatrix square() {
        boolean[][] squareGraphMatrix = new boolean[order][order];
        for(int i=0;i<order;i++){
            for(int j=0;j<order;j++){
                if(!aMatrix[i][j])
                    continue;
                squareGraphMatrix[i][j] = true;
                for(int k=0;k<order;k++){
                    if(aMatrix[j][k]&&i!=k){
                        squareGraphMatrix[i][k]=true;
                    }
                }
            }
        }
        return new GraphInMatrix(squareGraphMatrix);
    }

    public void display() {
        for (int i = 0; i < order; i++) {
            for(int j=0;j<order;j++){
                System.out.print(aMatrix[i][j]?j+" ":"");
            }
            System.out.println();
        }
    }

    public String toString(){
        String result = "\n";
        for (int i = 0; i < order; i++) {
            for(int j=0;j<order;j++){
                result +=aMatrix[i][j]?1:0;
                if(j<order-1)
                    result+=",";
            }
            result+="\n";
        }
        return result;
    }

    public int[] eulerian(){
    	return null;	
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
        graph1.display();
        System.out.println(graph1);
        GraphInMatrix graph2 = graph1.square();
        graph2.display();
        System.out.println(graph2);
    }
}
