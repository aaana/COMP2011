package polyu.comp.datastructure.assign4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;


public class GraphInLists extends Graph{
    private int order;  // the number of vertices
    private List[] aLists;
    private boolean[][] aMatrix;
    
    public GraphInLists(int order) {
        this.order = order;
    	aLists = new List[order];
    	for (int i = 0; i < order; i++)
    		aLists[i] = new List();
    }

    public GraphInLists(boolean[][] aMatrix) {
    	//
        this(aMatrix.length);
        for(int i=0;i<order;i++){
            for(int j=0;j<i;j++){
                if(aMatrix[i][j]){
                    addEdge(i,j);
                }
            }
        }
        this.aMatrix = aMatrix;
    }
    
    // This version doesn't check whether the edge is arealdy there.
    // It's not a problem for matrix version. Why?
    public void addEdge(int a, int b) {
        // usually we don't allow self-loop 
        // i.e., an edge with both ends on the same vertex
        if (a == b) return;
        if(aLists[a].search(b)!=null){
            return;
        }
        aLists[a].insertAtFront(b);
        aLists[b].insertAtFront(a);
    }

    public boolean isAdjacent(int a, int b) {
    	List list = aLists[a];
    	return (list.search(b) != null);
    }

    // return the degree of vertex a.
    public int degree(int a) {
    	return aLists[a].length();
    }

    // return the total number of edges in the graph.
    public int size() {
    	int s = 0;
        for(int i = 0; i < order; i++)
        	s += degree(i);
        return s / 2;
    }

    // check whether the graph contains a triangle
    // i.e., three vertices pairwise adjacent
    public boolean triangle() {
    	//
        for(int i=0;i<order;i++){
            int[] adjancent = aLists[i].toArray();
            for(int j=0;j<adjancent.length;j++){
                for(int k=i+1;k<order;k++){
                    if (aMatrix[i][k] && aMatrix[adjancent[j]][k]) return true;
                }
            }
        }
        return false;
    }
    
    public void bfs() { bfs(0); }

    // breadth-first search
    public void bfs(int a) {
    	//
        int index = 0;
        int[] distance = new int[order];
        int[] number = new int[order];
        int[] parent = new int[order];
        number[a] = index++;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(a);
        for(int i=0;i<parent.length;i++){
            parent[i] = -2;
        }
        parent[a] = -1;
        distance[a] = 0;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            int[] neighbours = aLists[cur].toArray();
            for(int i=0;i<neighbours.length;i++){
                if(parent[neighbours[i]]!=-2)continue;
                number[neighbours[i]]=index++;
                parent[neighbours[i]] = cur;
                distance[neighbours[i]] = distance[cur]+1;
                queue.offer(neighbours[i]);
            }
        }
    }
    
    // depth-first search
    public void dfs(int a) {
        int index = 0;
        int[] number = new int[order];
        int[] parent = new int[order];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<order;i++){
            parent[i] = -2;
        }
        int par = -1;
        stack.push(a);
        while (!stack.isEmpty()){
            int cur = stack.pop();
            if(parent[cur]!=-2)
                continue;
            number[cur] = index++;
            parent[cur] = par;
            par = cur;
            int[] neighbours = aLists[cur].toArray();
            for(int i=0;i<neighbours.length;i++){
                if(parent[neighbours[i]]==-2){
                    stack.push(neighbours[i]);
                }
            }
        }
    }

    // print out the adjacency list
    public void display() {
    	for (int i = 0; i < order; i++) {
    		System.out.println(aLists[i]);
    	}
    }

    public GraphInLists square() {
        boolean[][] squareGraphMatrix = new boolean[order][order];
        for(int i=0;i<order;i++){
            int[] adjancent = aLists[i].toArray();
            for(int j=0;j<adjancent.length;j++){
                squareGraphMatrix[i][adjancent[j]] = true;
                int[] temp = aLists[adjancent[j]].toArray();
                for(int k=0;k<temp.length;k++){
                    if(i!=temp[k]){
                        squareGraphMatrix[i][temp[k]]=true;
                    }
                }
            }
        }
        return new GraphInLists(squareGraphMatrix);
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
        GraphInLists graph1 = new GraphInLists(m1);
        GraphInLists graph2 = graph1.square();
        graph1.display();
        System.out.println();
        graph2.display();
//        System.out.println(graph2.aLists);
    }
}
