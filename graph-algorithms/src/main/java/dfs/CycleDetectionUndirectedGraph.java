package dfs;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionUndirectedGraph {
    public static void main(String[] args) {

    }

    class Graph{
        List<Integer>[] adjList;
        Graph(int vertices){
            for(int i = 0; i < vertices;i++){
                adjList[i] = new ArrayList<Integer>();
            }
        }

        public void addEdge(int x, int y){
            adjList[x].add(y);

        }
    }
}
