class Solution {
   static class Node {
        String target;
        double weight;

        Node(String target, double weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Node(v, val));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Node(u, 1.0 / val));
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                result[i] = -1.0;
            } else if (src.equals(dest)) {
                result[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(graph, src, dest, visited);
            }
        }

        return result;
    }

    private double dfs(Map<String, List<Node>> graph, String src, String dest, Set<String> visited) {
        if (src.equals(dest)) {
            return 1.0;
        }

        visited.add(src);

        for (Node neighbor : graph.get(src)) {
            if (!visited.contains(neighbor.target)) {
                double weight = dfs(graph, neighbor.target, dest, visited);
                if (weight != -1.0) {
                    return neighbor.weight * weight;
                }
            }
        }

        return -1.0;
    }
}