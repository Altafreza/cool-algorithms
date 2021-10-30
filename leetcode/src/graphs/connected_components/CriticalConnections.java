package graphs.connected_components;

import java.util.*;

// Connected Components on Undirected graphs
// find edge on articulation point
public class CriticalConnections {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, Set<Integer>> graph = buildGraph(connections);
        List<List<Integer>> criticalConnections = new LinkedList<>();
        dfs(0, 0, new int[n], new int[n], new int[n], graph, new HashSet<>(), criticalConnections);
        return criticalConnections;
    }


    // edge list -> adjacency list
    private Map<Integer, Set<Integer>> buildGraph(List<List<Integer>> connections) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (List<Integer> edge : connections) {
            int from = edge.get(0);
            int to = edge.get(1);
            if (!graph.containsKey(from)) {
                graph.put(from, new HashSet<>());
            }
            graph.get(from).add(to);
            if (!graph.containsKey(to)) {
                graph.put(to, new HashSet<>());
            }
            graph.get(to).add(from);
        }

        return graph;
    }

    private void dfs(int id, int start, int[] times, int[] low, int[] parents, Map<Integer, Set<Integer>> graph, Set<Integer> visited, List<List<Integer>> criticalConnections) {
        times[id] = start;
        low[id] = start;

        visited.add(id);

        for (int neighbor : graph.get(id)) {
            if (!visited.contains(neighbor)) {
                parents[neighbor] = id;
                dfs(neighbor, start + 1, times, low, parents, graph, visited, criticalConnections);
                // visit and came back
                //and low and times are updated at least for the subgraph starting at neigh
                low[id] = Math.min(low[id], low[neighbor]);
                if (low[neighbor] > times[id]) { // neighbor cannot be reached from my ancestor
                    addEdge(id, neighbor, criticalConnections); //bridge
                }
            } else {
                if (neighbor == parents[id]) {
                    continue;
                }
                // for back edge
                low[id] = Math.min(low[id], times[neighbor]);
            }
        }
    }

    private void addEdge(int from, int to, List<List<Integer>> criticalConnections) {
        List<Integer> edge = new ArrayList<>();
        edge.add(from);
        edge.add(to);
        criticalConnections.add(edge);
    }

    public static void main(String[] args) {
        CriticalConnections cc = new CriticalConnections();
        List<List<Integer>> lists = cc.criticalConnections(4, Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2)
                , Arrays.asList(2, 0), Arrays.asList(1, 3)));
        int a =1;
    }
}
