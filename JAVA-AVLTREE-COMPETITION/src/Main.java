public class Main{

    public static void main (String[] args){

        Program.createAvlTrees(args[0]);  //Creating avltrees from branches.txt
        Program.createCompetitors(args[1]); //Adding competitors to avltrees from competitors.txt
        Program.runningTimeOperations(args[2],args[4]); //Executing ADD and DISQ operations and showing steps
        Program.display(args[3]); //Displaying results
    }
}
