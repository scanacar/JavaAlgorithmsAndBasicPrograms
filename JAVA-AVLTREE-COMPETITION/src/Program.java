import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Program {
    //HashMap where AVLTrees are kept
    private static HashMap<String,AVLTree> avlTrees = new HashMap<String,AVLTree>();

    //Creating AVLTrees from branches.txt and reading branches.txt
    public static void createAvlTrees(String fileName){
        try{
            ArrayList<String[]> read = File.read(fileName,"\t");
            for(String[] avlTree: read){
                if (!avlTrees.containsKey(avlTree[1])){
                    AVLTree newAvlTree = new AVLTree(avlTree[0],avlTree[1],null);
                    avlTrees.put(avlTree[1],newAvlTree);
                }
            }
        }catch (Exception e){

        }
    }
    //Placing competitors to AVLTrees
    public static void createCompetitors(String fileName){

        try{
            ArrayList<String[]> read = File.read(fileName,"\t");
            for(String[] competitor: read){
                try {
                    AVLTree avlTree = avlTrees.get(competitor[3]);
                    //Creating object of competitor
                    Competitor newCompetitor = new Competitor(competitor[0], competitor[1], competitor[2],
                            competitor[3], Integer.parseInt(competitor[4]), 1,
                            null, null);
                    //Setting competitor to avltree
                    avlTree.setRoot(avlTree.insert(avlTree.getRoot(), newCompetitor, null));
                }catch (Exception e){

                }
            }
        }catch (Exception e){

        }
    }
    //ADD and DISQ operations
    public static void runningTimeOperations(String fileName,String outputFileName){

        try{
            ArrayList<String[]> read = File.read(fileName,"\t");
            File.of(outputFileName);
            for(String[] operation: read){
                try {
                    switch (operation[0]){
                        //its not working
                        case "DISQ":
                            for (AVLTree avlTree : avlTrees.values()){
                                avlTree.removeNode(avlTree.getRoot(),operation[1]);
                            }
                            break;
                        case "ADD":
                            AVLTree avlTree = avlTrees.get(operation[4]);
                            //Creating object of competitor
                            Competitor newCompetitor = new Competitor(operation[1], operation[2], operation[3],
                                    operation[4], Integer.parseInt(operation[5]), 1,
                                    null, null);
                            File.write("1\tstart\troot");
                            //Setting competitor to avltree
                            avlTree.setRoot(avlTree.insert(avlTree.getRoot(), newCompetitor, new AtomicInteger(1)));
                            File.newLine();
                            File.newLine();
                            break;
                        default:
                    }

                }catch (Exception e){

                }
            }
        }catch (Exception e){

        }

        File.close();
    }
    //Displaying results
    public static void display(String outputFileName){

        File.of(outputFileName);
        File.write("OLYMPIC GAMES\n" +
                "--------------\n" +
                "\n" +
                "Sport Branches and Their Sub-branches\n" +
                "-----------------------------------------");
        File.newLine();
        for(AVLTree avlTree : avlTrees.values()){
            File.newLine();
            File.write(avlTree.getMainBranch()+"\t"+avlTree.getSubBranch());
        }

        for (AVLTree avlTree: avlTrees.values()){
            File.newLine();
            File.newLine();
            File.newLine();
            File.write(avlTree.getMainBranch()+"\t"+avlTree.getSubBranch()+" Results\n--------------------------------------------");
            if (avlTree.getMainBranch().equals("Archery")){ //if tree is Archery do postorder
                avlTree.postOrder(avlTree.getRoot(), new AtomicInteger(1));
            }
            else{ //if tree is swimming or athletics do inorder
                avlTree.inOrder(avlTree.getRoot(), new AtomicInteger(1));
            }
        }
        File.close();
    }

}
