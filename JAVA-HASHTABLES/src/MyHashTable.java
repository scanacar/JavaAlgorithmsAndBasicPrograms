import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintStream;

public class MyHashTable {
    private Node[] hashTable;
    private int TABLE_SIZE;

    public MyHashTable(int size){
        TABLE_SIZE = size;
        hashTable = new Node[TABLE_SIZE];
    }
    public void display(BufferedWriter bWriter) throws IOException {
        int j=0;
        bWriter.write("PART2"+"\n"+"Hashtable for Linear Probing"+"\n");
        for (int i =0;i<TABLE_SIZE;i++){
            if (hashTable[i] != null){

                bWriter.write("["+j+"]"+"--->"+hashTable[i].getKey()+"\n");
                j++;
            }
            else{
                bWriter.write("[" + j + "]" + "--->" + "null"+"\n");
                j++;
            }
        }
    }
    public int hash(int key){
        return key % TABLE_SIZE;
    }
    public void put(Node item){
        int key = item.getKey();
        int hash = hash(key);
        while (hash<TABLE_SIZE){
            if (hashTable[hash] == null){
                Node temp = new Node();
                temp.setKey(key);
                hashTable[hash] = temp;
                break;
            }
            hash++;
        }
    }
    public Node get(int key,BufferedWriter bWriter) throws IOException {
        int hash = hash(key);
        int count = 1;
        while (hashTable[hash] != null){
            if(hashTable[hash].getKey() == key){
                bWriter.write("LINEAR PROBING:"+"\n"+
                        "Key found with "+ count +" comparisons"+"\n"+
                        "CPU time taken to search = ");
                return hashTable[hash];

            }
            count++;
            hash++;
            hash %= TABLE_SIZE;
        }
        bWriter.write("LINEAR PROBING:"+"\n"+
                "Key found with "+ count +" comparisons"+"\n"+
                "CPU time taken to search = ");

        return null;
    }
}
