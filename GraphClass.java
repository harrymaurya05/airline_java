import java.util.Scanner;

class GraphClass {
    public static void main(String[] args) {
        // creating objects of class Graph
        Graph graph = new Graph(0);
        String [] vertexTest = {"A","B","C","D"};
        for(String str : vertexTest) {
            graph.addVertex(str);
        }
        // connecting that vertex to other existing vertices
        graph.addEdge("A", "C",9);
        graph.addEdge("A","B",5);
        graph.addEdge("A","D",7);
        graph.addEdge("C","D",8);
        graph.addEdge("B","D",6);
        int choice = 10;
        while(choice != 0){
            System.out.println("********** AIRLINE APPLICATION ************");
            System.out.println("\n\n 1. AddVertex\n" + " 2. RemoveVertex\n" + " 3. AddEdge\n"
                + " 4. RemoveEdge\n" + " 5. DisplayAdjacentMatrix\n" + " 6. DisplayEdges\n"
                + " 7. BFS\n" + " 8. DFS\n" + " 9. Check Flight availability\n"
                + " 0. Exit()");
            System.out.println("Enter your Choice.");
            Scanner scanner = new Scanner(System.in);
            try{
                choice = scanner.nextInt();
            }catch(Exception e){
                System.out.println("Please enter a valid input!!");
                continue;
            }
            switch (choice){
            case 1:{
                System.out.println("Enter Vertex.");
                String vertex = scanner.next();
                graph.addVertex(vertex);
                System.out.print("\n\n");
                
                break;
            }
            case 2:{
                System.out.println("Enter number of vertex to remove.");
                int no_edge_remove = scanner.nextInt();
                graph.removeVertex(no_edge_remove);
                System.out.print("\n\n");
                
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
                
                break;
            }
            case 4:{
                System.out.println("Enter the source vertex.");
                String source = scanner.next();
                System.out.println("Enter the destination vertex.");
                String dest = scanner.next();
                graph.removeEdge(source,dest);
                System.out.print("\n\n");
                
                break;
            }
            case 5:{
                graph.displayAdjacencyMatrix();
                System.out.print("\n\n");
                
                break;
            }
            case 6:{
                graph.displayEdge();
                System.out.print("\n\n");
                
                break;
            }
            case 7:{
                System.out.println("Enter the source vertex.");
                String source = scanner.next();
                graph.bfs(source);
                System.out.print("\n\n");
                
                break;
            }
            case 8:{
                System.out.println("Enter the source vertex.");
                String source = scanner.next();
                graph.dfs(source);
                System.out.print("\n\n");
                
                break;
            }
            case 9:{
                System.out.println("Enter the source vertex.");
                String source = scanner.next();
                System.out.println("Enter the destination vertex.");
                String dest = scanner.next();
                graph.flightAvailable(source,dest);
                System.out.print("\n\n");
                
                break;
            }
            case 0:{
                System.out.println("Thank you !!");
                break;
            }
            default:{
                System.out.println("Please Choose a valid input!!\n\n");
                
                break;
            }

            }
        }
    }
}