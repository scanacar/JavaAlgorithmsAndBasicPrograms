import java.io.*;
import java.lang.reflect.Array;
import java.nio.BufferOverflowException;
import java.util.ArrayList;

public abstract class File {
    private static FileWriter fWriter;
    private static BufferedWriter bWriter;
    //Reading file
    public static ArrayList<String[]> read(String fileName, String splitVariable) {
        String information;
        ArrayList<String[]> rows = new ArrayList<String[]>();
        try {
            FileInputStream fStream = new FileInputStream(fileName);
            DataInputStream dStream = new DataInputStream(fStream);
            BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));

            while ((information = bReader.readLine()) != null) {
                if (information.length() != 0) {
                    rows.add(information.split(splitVariable));
                }
            }
            bReader.close();
        }
        catch (Exception e) {

        }

        return rows;
    }
    //For creating writers
    public static void of(String fileName){
        try {
            fWriter = new FileWriter(fileName);
            bWriter = new BufferedWriter(fWriter);
        }catch (Exception e){

        }
    }
    //For writing to file
    public static void write(String content){
        try {
            bWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //For closing file
    public static void close(){
        try{
            bWriter.close();
        }catch (Exception e){

        }
    }
    //For newlines
    public static void newLine(){
        try{
            bWriter.newLine();
        }catch (Exception e){

        }
    }
}
