import java.util.concurrent.atomic.AtomicInteger;

public class AVLTree {
    // Attributes of AVLTree
    private String mainBranch;
    private String subBranch;
    private Competitor root;
    // Constructor
    public AVLTree(String mainBranch, String subBranch, Competitor root) {
        this.mainBranch = mainBranch;
        this.subBranch = subBranch;
        this.root = root;
    }
    // Getter and Setters
    public String getMainBranch() {
        return mainBranch;
    }

    public void setMainBranch(String mainBranch) {
        this.mainBranch = mainBranch;
    }

    public String getSubBranch() {
        return subBranch;
    }

    public void setSubBranch(String subBranch) {
        this.subBranch = subBranch;
    }

    public Competitor getRoot() {
        return root;
    }

    public void setRoot(Competitor root) {
        this.root = root;
    }

    int max (int a, int b){
        return (a>b) ? a: b;
    } // For calculating height of a node
    // Inserting competitors to AVLTree according to the times
    public Competitor insert(Competitor root, Competitor competitor, AtomicInteger x){

        if (root == null) return competitor;
        //If competitors time less than roots time set left
        if (competitor.getTime() < root.getTime()){
            if (x != null){
                x.set(x.get()+1); // Atomic integer +1
                File.newLine();
                File.write(String.valueOf(x)+"\t"+"go_to_node\t"+"left"); //write operation to steps.txt
            }
            root.setLeft(insert(root.getLeft(),competitor, x)); //Inserting to left of root
        }
        //If roots time less than competitors time set right
        else if (competitor.getTime() > root.getTime()){
            if (x != null){
                x.set(x.get()+1); // Atomic integer +1
                File.newLine();
                File.write(String.valueOf(x)+"\t"+"go_to_node\t"+"right"); //write operation to steps.txt
            }
            root.setRight(insert(root.getRight(),competitor, x)); //Inserting to right of root
        }

        else{
            return root;
        }

        root.setHeight(1+ max(height(root.getLeft()),height(root.getRight()))); //calculating height

        Integer balance = getBalance(root);
        //LL-LR-RR-RL operations
        if (balance.compareTo(Integer.valueOf(1))==1 &&
                competitor.getTime() < root.getLeft().getTime())
            return rightRotate(root);
        if (balance.compareTo(Integer.valueOf(-1))==-1 &&
            competitor.getTime() > root.getRight().getTime())
            return leftRotate(root);
        if (balance.compareTo(Integer.valueOf(1))==1 &&
            competitor.getTime() > root.getLeft().getTime()){
            root.setLeft(leftRotate(root.getLeft()));
            return rightRotate(root);
        }
        if (balance.compareTo(Integer.valueOf(-1))==-1 &&
            competitor.getTime() < root.getRight().getTime()){
            root.setRight(rightRotate(root.getRight()));
            return leftRotate(root);
        }
         return root;
    }
    // RightRotate operation
    public Competitor rightRotate(Competitor rotatedCompetitor){
        Competitor x = rotatedCompetitor.getLeft();
        Competitor T2 = x.getRight();

        x.setRight(rotatedCompetitor);
        rotatedCompetitor.setLeft(T2);

        rotatedCompetitor.setHeight(
                max(
                        height(rotatedCompetitor.getLeft()),
                        height(rotatedCompetitor.getRight()))+1);
        x.setHeight(
                max(
                        height(x.getLeft()),
                        height(x.getRight()))+1);
        return x;
    }
    //LeftRotate operation
    public Competitor leftRotate(Competitor rotatedCompetitor){
        Competitor y = rotatedCompetitor.getRight();
        Competitor T2 = y.getLeft();

        y.setLeft(rotatedCompetitor);
        rotatedCompetitor.setRight(T2);

        rotatedCompetitor.setHeight(
                max(
                        height(rotatedCompetitor.getLeft()),
                        height(rotatedCompetitor.getRight()))+1);
        y.setHeight(
                max(
                        height(y.getLeft()),
                        height(y.getRight()))+1);
        return y;
    }
    //For balancing the tree
    public Integer getBalance(Competitor balancedCompetitor){
        return balancedCompetitor == null ?
                Integer.valueOf(0) :
                Integer.valueOf(height(balancedCompetitor.getLeft()) - height(balancedCompetitor.getRight()));
    }
    //Calculating height
    public Integer height(Competitor competitor){
        return competitor == null ?
                Integer.valueOf(0) :
                Integer.valueOf(competitor.getHeight());
    }
    //For sorting athletics and swimming ranks
    public void inOrder(Competitor competitor, AtomicInteger x){
        if (competitor != null){
            inOrder(competitor.getLeft(),x);
            File.newLine();
            File.write(String.valueOf(x.get())+"-\t"+competitor.getId()+"\t"
            +competitor.getName()+"\t"+competitor.getSurname()+"\t"+competitor.getTime());
            x.set(x.get()+1);
            inOrder(competitor.getRight(),x);
        }
    }
    //For sorting archery ranks
    public void postOrder(Competitor competitor, AtomicInteger x){
        if (competitor != null){
            postOrder(competitor.getRight(),x);
            File.newLine();
            File.write(String.valueOf(x.get())+"-\t"+competitor.getId()+"\t"
                    +competitor.getName()+"\t"+competitor.getSurname()+"\t"+competitor.getTime());
            x.set(x.get()+1);
            postOrder(competitor.getLeft(),x);

        }
    }
    //Given a non-empty binary search tree, return the node with minimum key value found in that tree
    private Competitor minValueCompetitor(Competitor competitor){
        Competitor current = competitor;

        while(current.getLeft() != null){
            current = current.getLeft();
        }
        return current;
    }
    //For removing node but its not working
    public Competitor removeNode(Competitor root,String id){
        if (root == null) return root;

        if (Integer.parseInt(id) < Integer.parseInt(root.getId())){
            root.setLeft(removeNode(root.getLeft(),id));
        }
        else if (Integer.parseInt(id) > Integer.parseInt(root.getId())){
            root.setRight(removeNode(root.getRight(),id));
        }
        else{
            if ((root.getLeft() == null) || (root.getRight() == null)){
                Competitor temp = null;
                if (temp == root.getLeft()) temp = root.getRight();
                else temp = root.getLeft();

                if (temp == null){
                    temp = root;
                    root = null;
                }
                else root = temp;
            }
            else{
                Competitor temp = minValueCompetitor(root.getRight());
                root.setId(temp.getId());
                root.setRight(removeNode(root.getRight(),temp.getId()));
            }
        }

        if(root == null) return root;

        root.setHeight(max(height(root.getLeft()),height(root.getRight()))+1);
        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.getLeft())>= 0) return rightRotate(root);
        if (balance > 1 && getBalance(root.getLeft()) <0){
            root.setLeft(leftRotate(root.getLeft()));
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.getRight()) <= 0) return leftRotate(root);
        if (balance < -1 && getBalance(root.getRight()) >0 ){
            root.setRight(rightRotate(root.getRight()));
            return leftRotate(root);
        }
        //Second way bot its not working too

        /*if (root == null) return root;

        if (id.equals(root.getId())){
            if ((root.getLeft() == null) || (root.getRight() == null)){
                Competitor temp = null;
                if (temp == root.getLeft())
                    temp = root.getRight();
                else
                    temp = root.getLeft();

                if (temp == null){
                    temp = root;
                    root = null;
                }
                else{
                    root = temp;
                }
            }
            else{
                Competitor temp = minValueCompetitor(root.getRight());
                root.setId(temp.getId());
                root.setRight(removeNode(root.getRight(),temp.getId()));
            }
        }
        else{
            root.setLeft(removeNode(root.getLeft(),id));
            root.setRight(removeNode(root.getRight(),id));
        }

        if (root == null)  return root;
        root.setHeight(max(height(root.getLeft()),height(root.getRight()))+1);
        int balance = getBalance(root);*/

        return root;
    }

    @Override
    public String toString() {
        return "AVLTree{" +
                "mainBranch='" + mainBranch + '\'' +
                ", subBranch='" + subBranch + '\'' +
                ", root=" + root +
                '}';
    }
}
