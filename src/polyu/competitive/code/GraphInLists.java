package polyu.competitive.code;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public class GraphInLists extends Graph{
    private int order;  // the number of vertices
    private List[] aLists;

    //O(n^2)
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

    //O(n^3)
    // check whether the graph contains a triangle
    // i.e., three vertices pairwise adjacent
    public boolean triangle() {
    	//
        for(int i=0;i<order;i++){
            int[] adjancent = aLists[i].toArray();
            for(int j=0;j<adjancent.length;j++){
                for(int k=i+1;k<order;k++){
                    if(isAdjacent(i,k)&&isAdjacent(adjancent[j],k)){
                        return true;
                    }
                }
            }
        }
    	return false;
    }

    //O(n+m)
    public void bfs() { bfs(0); }

    //todo!!!! parent is the index of its parent node but not the number!!!!
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
//        int[] distance = new int[order];
        int[] number = new int[order];
        int[] parent = new int[order];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<parent.length;i++){
            parent[i] = -1;
        }
//        distance[a] = 0;
//        parent[a]=-1;
        int par = -1;
        stack.push(a);
        while (!stack.isEmpty()){
            int cur = stack.pop();
//                distance[cur] = 0;
//                parent[cur] = par;
            if(parent[cur]==-2){
                number[cur] = index++;
                parent[cur] = par;
            }
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
        System.out.println(graph1.triangle());
        
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

        GraphInLists graph2 = new GraphInLists(m2);
        System.out.println(graph2.triangle());

        System.out.println("Breadth-first search: ");

        GraphInLists graph = new GraphInLists(8);
        System.out.println("The degree of vertex " + 2 + " is "
        		+ graph.degree(2) + ".");
        System.out.println("Vertices " + 2 + " and " + 4 + " are"
        		+ (graph.isAdjacent(2,4)?"":" not") + " adjacent.");
        graph.addEdge(0, 3); graph.addEdge(1, 3); graph.addEdge(1, 4);
        graph.addEdge(2, 4); graph.addEdge(3, 5); graph.addEdge(4, 6);
        graph.addEdge(5, 6); graph.addEdge(5, 7); graph.addEdge(6, 7);
        graph.display();
        graph.bfs();
        System.out.println("Vertices " + 2 + " and " + 4 + " are"
        		+ (graph.isAdjacent(2,4)?"":" not") + " adjacent.");
        System.out.println("The degree of vertex " + 2 + " is "
        		+ graph.degree(2) + ".");
        System.out.println("The graph has " + graph.size() + " edges.");
//        System.out.println(graph.draw());
    }
}
