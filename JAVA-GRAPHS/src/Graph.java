import java.util.*;

class Graph<T> {

    private Map<T, List<T>> hashMap = new HashMap<>();  // Hashmap holds vertices

    public Map<T, List<T>> getHashMap() {
        return hashMap;
    }

    public void setHashMap(Map<T, List<T>> hashMap) {
        this.hashMap = hashMap;
    }

    // Edge adding function
    public void addEdge(T from,T to,boolean check){

        if (!hashMap.containsKey(from))
            addVertex(from);  // adding start vertex
        if(!hashMap.containsKey(to))
            addVertex(to);  // adding end vertex
        if (check == true) // if edges are bidirectional
            hashMap.get(to).add(from);

        hashMap.get(from).add(to);  // connect the vertices
    }
    // Vertex adding function
    public void addVertex(T vertex){
        hashMap.put(vertex,new LinkedList<T>());
    }
    // printing Graph structure
    public String printGraph(ArrayList<Vertex> vertices){

        StringBuilder sBuilder = new StringBuilder();
        int i =0;
        for (T vertex : hashMap.keySet()) {
            sBuilder.append(vertex.toString()+"("+vertices.get(i).getCapacity()+")"+ "-->");
            for (T adjacency : hashMap.get(vertex)) {
                sBuilder.append(adjacency.toString() +" ");
            }
            i++;
            sBuilder.append("\n");
        }

        return (sBuilder.toString());
    }
}
