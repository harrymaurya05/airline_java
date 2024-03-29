import java.util.HashMap;
import java.util.Scanner;

class Graph
{
    // number of vertices
    private int n;
    private  String[] airports = new String[27];
    private HashMap<String,Integer> airportToVertex = new HashMap<>();
    // adjacency matrix
    private int[][] g = new int[10][10];

    // constructor
    Graph(int x)
    {
        this.n = x;
        int i, j;

        // initializing each element of
        // the adjacency matrix to zero
        for (i = 0; i < n; ++i)
        {
            for (j = 0; j < n; ++j)
            {
                g[i][j] = 0;
            }
        }
    }
    public void displayEdge(){
        System.out.println("\nConnected Edges:");
         if(n == 0){
            System.out.print("\nGraph is Empty.!!\n");
        }
        boolean flag = true;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if(g[i][j] > 0){
                    flag = false;
                    System.out.print(airports[i]+"->"+airports[j]);
                    System.out.println();
                }

            }
        }
        if(flag){
            System.out.print("\nNo Edge present in graph.!!\n");
        }
        //System.out.println();
    }
    public void displayAdjacencyMatrix() {
        System.out.print("\nAdjacency Matrix: \n");
        if(n == 0){
            System.out.print("\nGraph is Empty.!!\n");
        }
        boolean flag = true;
        for(int i=0; i<n; i++){
            if(flag){
                System.out.print("   ");
                flag = false;
            }

            System.out.print(airports[i]+"  ");
        }
        // displaying the 2D array
        for (int i = 0; i < n; ++i) {
            System.out.println();
            System.out.print(airports[i]);
            for (int j = 0; j < n; ++j) {
                System.out.print("  " + g[i][j]);
            }
        }
    }
    public void flightAvailable(String source,String dest) {
        if(airportToVertex.get(source) == null || airportToVertex.get(dest) == null){
            System.out.println("Invalid Source "+source+" and destination:"+dest);
            return;
        }
        int x = airportToVertex.get(source);
        int y = airportToVertex.get(dest);
        if ((x >= n) || (y > n))
        {
            System.out.println("Vertex does not exists!");
        }
        if (x == y)
        {
            System.out.println("Same Vertex!");
        }
        if(g[x][y] == 0){
            System.out.println("There is no Flight Between Airport "+source+" and "+dest);
            return;
        }
        System.out.println("Flight Price is "+g[x][y]);
    }

    public void addEdge(String source, String dest,int weight) {
        if(airportToVertex.get(source) == null || airportToVertex.get(dest) == null){
            System.out.println("Invalid Source "+source+" and destination:"+dest);
            return;
        }
        int x = airportToVertex.get(source);
        int y = airportToVertex.get(dest);
        // checks if the vertex exists in the Graph
        //System.out.println("x:"+x+" y:"+y+" n:"+n);
        if ((x >= n) || (y >= n))
        {
            System.out.println("Vertex does not exists!");
        }

        // checks if the vertex is connecting to itself
        if (x == y)
        {
            System.out.println("Same Vertex!");
        }
        else
        {
            // connecting the vertices
            g[y][x] = weight;
            g[x][y] = weight;
        }
    }
    public void removeEdge(String source, String dest) {
        if(airportToVertex.get(source) == null || airportToVertex.get(dest) == null){
            System.out.println("Invalid Source "+source+" and destination:"+dest);
            return;
        }
        int x = airportToVertex.get(source);
        int y = airportToVertex.get(dest);
        // checks if the vertex exists in the Graph
        if ((x >= n) || (y > n))
        {
            System.out.println("Vertex does not exists!");
        }

        // checks if the vertex is connecting to itself
        if (x == y)
        {
            System.out.println("Same Vertex!");
        }
        else
        {
            // connecting the vertices
            g[y][x] = 0;
            g[x][y] = 0;
        }
    }

    public void addVertex(String airport) {
        // increasing the number of vertices(this)
        this.airports[n] = airport;
        if(airportToVertex.get(airport) != null) {
            System.out.println("vertex is already present : "+airport);
            return;
        }
        airportToVertex.put(airport,n);
        n++;
        int i;

        // initializing the new elements to 0
        for (i = 0; i < n; ++i)
        {
            g[i][n - 1] = 0;
            g[n - 1][i] = 0;
        }
    }

    public void removeVertex(int x) {
        // checking if the vertex is present
        if (x > n)
        {
            System.out.println("Vertex not present!");
            return;
        }
        // decreasing the number of vertices
        n--;
    }
    public void bfs(String source) {
        if(airportToVertex.get(source) == null){
            System.out.println("Invalid Source :"+source);
            return;
        }
        System.out.println("Breath First Search for the given source :"+source);
        int vertex = airportToVertex.get(source);
        Queue queue = new Queue(n);
        queue.enqueue(vertex);
        boolean visited[] = new boolean[n];
        while(!queue.isEmpty()) {
            int current = queue.dequeue();
            visited[current] = true;
            System.out.print(airports[current] + " ");
            for (int i = 0; i < n; i++) {
                if (visited[i] == false && g[current][i] > 0) {
                    queue.enqueue(i);
                    visited[i] = true;
                }
            }
        }
    }

    public void dfs(String source) {
        if(airportToVertex.get(source) == null){
            System.out.println("Invalid Source :"+source);
            return;
        }
        System.out.println("Depth First Search for the given source :"+source);
        int vertex = airportToVertex.get(source);
        Stack<Integer> stack = new Stack<>(n);
        stack.push(vertex);
        boolean visited[] = new boolean[n];
        while(!stack.isEmpty()) {
            int current = stack.pop();
            visited[current] = true;
            System.out.print(airports[current] + " ");
            for (int i = 0; i < n; i++) {
                if (visited[i] == false && g[current][i] > 0) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }
}

