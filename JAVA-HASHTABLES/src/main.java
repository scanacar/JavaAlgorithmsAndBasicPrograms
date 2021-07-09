import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class main {

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
    public static void main(String[] args) throws IOException {
        int LF1 = Integer.parseInt(args[1]);
        int get = Integer.parseInt(args[3]);

        String[] array = readFile(args[0]);
        /////LINEAR PROBING//////
        String[] split;
        Node item;
        int key = 0;
        int x = 0;
        int TABLE_SIZE=0;

        for (String line : array){
            if (line.length()>0)
                TABLE_SIZE++;
        }
        float LF2 = Float.parseFloat(args[2]);
        int k = (int)((TABLE_SIZE-1)/LF2);
        MyHashTable hashTable = new MyHashTable(k);

        for (String line : array){
            x++;
            if(x>1 && line.length()>0){
                split = line.split(" ");
                key = Integer.parseInt(split[2]);
                item = new Node(key);
                hashTable.put(item);
            }
        }
        String filename = args[0];
        String[] name = filename.split(".txt");
        FileWriter fileWriter = new FileWriter(name[0]+",LF1="+args[1]+",LF2="+args[2]+","+args[3]+".txt",false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);

        hashTable.display(bWriter);

        /// DOUBLE HASHING////
        String[] split2;
        Node item2;

        int key2 = 0;
        int x2 = 0;
        int TABLE_SIZE2=0;

        for (String line : array){
            if (line.length()>0)
                TABLE_SIZE2++;
        }
        int t = (int)((TABLE_SIZE-1)/LF2);
        MyHashTable2 hashTable2 = new MyHashTable2(t);
        int z =0;
        for (String line : array){
            z++;
            if(z>1 && line.length()>0){
                split = line.split(" ");
                key2 = Integer.parseInt(split[2]);
                item2 = new Node(key2);
                hashTable2.put(key2,item2);
            }
        }
        hashTable2.display2(bWriter);

        //// EXECUTION TIMES
        long startTime = System.nanoTime();
        hashTable.get(Integer.parseInt(args[3]), bWriter);
        long elapsedTime = System.nanoTime() - startTime;
        bWriter.write((float)elapsedTime+" ns"+"\n");

        long startTime2 = System.nanoTime();
        hashTable2.get(Integer.parseInt(args[3]), bWriter);
        long elapsedTime2 = System.nanoTime() - startTime;
        bWriter.write((float) elapsedTime2 + " ns");

        bWriter.close();
    }
}
