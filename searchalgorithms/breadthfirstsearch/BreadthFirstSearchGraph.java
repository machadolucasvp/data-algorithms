package searchalgorithms.breadthfirstsearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearchGraph<T> {

    private Map<T, Vertex> adjacentList = new HashMap<>();
    private boolean bidirectional=false;

    public BreadthFirstSearchGraph() {
    }

    public BreadthFirstSearchGraph(T vertex) {
        addVertex(vertex);
    }

    private class Vertex {
        private List<Vertex> adjacent;
        private T data;

        public Vertex(T data) {
            this.data = data;
        }
    }

    private Vertex getVertex(T vertex) {
        return adjacentList.get(vertex);
    }

    private void addVertex(T vertex) {
        this.adjacentList.put(vertex, new Vertex(vertex));

    }

    private void addEdge(T src, T dest) {
        Vertex source = getVertex(src);
        Vertex destination = getVertex(dest);
        if(!bidirectional){
            source.adjacent.add(destination);
        }else{
            source.adjacent.add(destination);
            destination.adjacent.add(source);
        }
    }

    public boolean hasPathBFS(Vertex src, Vertex dest) {
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<Vertex>();
        queue.add(src);
        while(!queue.isEmpty()){
            Vertex current = queue.poll();
            if(current==dest){
                return true;
            }
            if(!visited.add(current)){
                for(Vertex children : current.adjacent){
                    queue.add(children);
                }
            }
        } 
        return false;
    }

    public void setBidirectional(boolean bool){
        this.bidirectional=bool;
    }

}