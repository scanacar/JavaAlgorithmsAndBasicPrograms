import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintStream;

public class MyHashTable2 {
    private Node[] hashTable2;
    private int TABLE_SIZE;

    MyHashTable2(int size){
        TABLE_SIZE = size;
        hashTable2 = new Node[TABLE_SIZE];
    }

    public void display2(BufferedWriter bWriter) throws IOException {
        int j=0;
        bWriter.write("Hashtable for Double Hashing"+"\n");
        for (int i =0;i<TABLE_SIZE;i++){
            if (hashTable2[i] != null){
                bWriter.write("["+j+"]"+"--->"+hashTable2[i].getKey()+"\n");
                j++;
            }
            else{
                bWriter.write("["+j+"]"+"--->"+"null"+"\n");
                j++;
            }
        }
    }
    public int hash1(int key){
        return key % TABLE_SIZE;
    }
    public int hash2(int key){
        return 1 + (key % (TABLE_SIZE - 1));
    }
    public void put (int key, Node item){
        int hashVal = hash1(key);
        int stepSize = hash2(key);

        while (hashVal<TABLE_SIZE){
            if (hashTable2[hashVal] == null){
                Node temp = new Node();
                temp.setKey(key);
                hashTable2[hashVal] = temp;
                break;
            }
            hashVal += stepSize;
            hashVal %= TABLE_SIZE;
        }
    }
    public Node get(int key, BufferedWriter bWriter) throws IOException {
        int hashVal = hash1(key);
        int stepSize = hash2(key);
        int count2=1;
        while (hashTable2[hashVal] != null){
            if(hashTable2[hashVal].getKey() == key){
                bWriter.write("DOUBLE HASHING:"+"\n"+
                        "Key found with "+ count2 +" comparisons"+"\n"+
                        "CPU time taken to search = ");
                return hashTable2[hashVal];
            }
            count2++;
            hashVal += stepSize;
            hashVal %= TABLE_SIZE;
        }
        bWriter.write("DOUBLE HASHING:"+"\n"+
                "Key found with "+count2 +" comparisons"+"\n"+
                "CPU time taken to search = ");
        return null;
    }

}
