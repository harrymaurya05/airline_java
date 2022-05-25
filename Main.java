import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // creating objects of class Graph
        Graph obj = new Graph(0);

        // calling methods
        //        obj.addEdge(0, 1);
        //        obj.addEdge(0, 2);
        //        obj.addEdge(1, 2);
        //        obj.addEdge(2, 3);

        // the adjacency matrix created
        obj.displayAdjacencyMatrix();

        // adding a vertex to the Graph
        //Tesing
        String [] vertexTest = {"A","B","C","D","E","F","G"};
        for(String str : vertexTest) {
            obj.addVertex(str);
        }
        // connecting that vertex to other existing vertices
        obj.addEdge("A", "B",10);
        obj.addEdge("A","C",20);
        obj.addEdge("B","D",30);
        obj.addEdge("C","E",40);
        //obj.addEdge("D","F",40);
        obj.addEdge("E","F",50);
        obj.addEdge("F","G",60);
        //obj.addEdge("G","D",70);
        //obj.addEdge("B","C",50);
        //obj.addEdge(2, 1);

        // the adjacency matrix with a new vertex
        obj.displayAdjacencyMatrix();
        obj.displayEdge();
        obj.bfs("A");
        System.out.println();
        obj.dfs("A");
        obj.removeEdge("A","B");


        obj.displayAdjacencyMatrix();
        // removing an existing vertex in the Graph
        obj.removeVertex(1);

        // the adjacency matrix after removing a vertex
        obj.displayAdjacencyMatrix();
        instruction(obj);

    }
    public static void instruction(Graph graph){
        System.out.println("\n\n1.AddVertex\n" + "2.removeVertex\n" + "3.AddEdge\n"
                + "4.removeEdge\n" + "5.DisplayAdjacentMatrix\n" + "6.DisplayEdges\n"
                + "7.BFS\n" + "8.DFS\n" + "9.Check Flight availability\n"
                + "0.exit()");
        System.out.println("Enter your Choice.");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
        case 1:{
            System.out.println("Enter Vertex.");
            String vertex = scanner.next();
            graph.addVertex(vertex);
            System.out.print("\n\n");
            instruction(graph);
            break;
        }
        case 2:{
            System.out.println("Enter number of vertex to remove.");
            int no_edge_remove = scanner.nextInt();
            graph.removeVertex(no_edge_remove);
            System.out.print("\n\n");
            instruction(graph);
            break;
        }
        case 3:{
            System.out.println("Enter the source vertex.");
            String source = scanner.next();
            System.out.println("Enter the destination vertex.");
            String dest = scanner.next();
            System.out.println("Enter the weight of edge");
            int weight = scanner.nextInt();
            graph.addEdge(source,dest,weight);
            System.out.print("\n\n");
            instruction(graph);
            break;
        }
        case 4:{
            System.out.println("Enter the source vertex.");
            String source = scanner.next();
            System.out.println("Enter the destination vertex.");
            String dest = scanner.next();
            graph.removeEdge(source,dest);
            System.out.print("\n\n");
            instruction(graph);
            break;
        }
        case 5:{
            graph.displayAdjacencyMatrix();
            System.out.print("\n\n");
            instruction(graph);
            break;
        }
        case 6:{
            graph.displayEdge();
            System.out.print("\n\n");
            instruction(graph);
            break;
        }
        case 7:{
            System.out.println("Enter the source vertex.");
            String source = scanner.next();
            graph.bfs(source);
            System.out.print("\n\n");
            instruction(graph);
            break;
        }
        case 8:{
            System.out.println("Enter the source vertex.");
            String source = scanner.next();
            graph.dfs(source);
            System.out.print("\n\n");
            instruction(graph);
            break;
        }
        case 9:{
            System.out.println("Enter the source vertex.");
            String source = scanner.next();
            System.out.println("Enter the destination vertex.");
            String dest = scanner.next();
            graph.flightAvailable(source,dest);
            System.out.print("\n\n");
            instruction(graph);
            break;
        }
        case 0:{
            System.out.println("Thank you !!");
            return;
        }
        default:{
            System.out.println("Please Choose a valid input!!\n\n");
            instruction(graph);
            break;
        }

        }

    }
}