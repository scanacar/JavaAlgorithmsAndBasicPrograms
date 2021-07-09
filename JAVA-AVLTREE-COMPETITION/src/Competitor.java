
public class Competitor {
    private String id;
    private String name;
    private String surname;
    private String subbranch;
    private int time;
    private int height;
    private Competitor left,right;

    public Competitor(String id, String name, String surname, String subbranch, int time, int height, Competitor left, Competitor right) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.subbranch = subbranch;
        this.time = time;
        this.height = height;
        this.left = left;
        this.right = right;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Competitor getLeft() {
        return left;
    }

    public void setLeft(Competitor left) {
        this.left = left;
    }

    public Competitor getRight() {
        return right;
    }

    public void setRight(Competitor right) {
        this.right = right;
    }
    @Override
    public String toString() {
        return "Competitor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", subbranch='" + subbranch + '\'' +
                ", time=" + time +
                ", height=" + height +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

}
