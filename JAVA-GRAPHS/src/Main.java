import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

    public static void main (String[] args) throws FileNotFoundException {

        Graph<String> graph = new Graph<String>();    // creating graph object
        ArrayList<Vertex> vertices = new ArrayList<>();  // vertices arraylist holds vertices
        String[] input = readFile(args[0]);
        PrintStream output = new PrintStream(new File("output.txt"));

        int lineCount =0;
        String[] split;
        for (String line : input){  // to read first line
            if (lineCount == 0){
                split = line.split("\\s+");
                for (int i =0;i<split.length;i=i+2){
                    vertices.add(new Vertex(split[i],Integer.parseInt(split[i+1]))); // adding vertices and
                                                                                      // their capacities
                }
                lineCount++;
            }
        }
        int lineCount2= 0;
        String[] split2;
        for (String line : input){
            lineCount2++;
            if (lineCount2>2){  // to read after the second line
                split2 = line.split("\\s+");
                graph.addEdge(split2[0],split2[1],true);  // to create edge
            }
        }
        System.setOut(output);
        System.out.println("Graph structure:\n"+graph.printGraph(vertices));
    }
    // reading file function
    public static String[] readFile(String path) {

        try {
            int i = 0;
            int length = Files.readAllLines(Paths.get(path)).size();
            String[] result = new String[length];

            for(String line : Files.readAllLines(Paths.get(path))) {
                result[i++] = line;
            }
            return result;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
