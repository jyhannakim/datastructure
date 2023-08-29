import java.util.PriorityQueue;
import java.util.Arrays;

public class SpanningTreeBuilder {
    public SpanningTree build(Graph graph, int source) {
        SpanningTree tree = new SpanningTree(graph.size);
        boolean[] visited = new boolean[graph.size];
        Arrays.fill(visited, false);
        
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for (Edge edge : graph.getEdges(source)) {
            queue.add(edge);
        }
        visited[source] = true;
        
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            if (visited[edge.getEnd()]) {
                continue;
            }
            tree.add(edge.getStart(), edge.getEnd(), edge.getWeight());
            visited[edge.getEnd()] = true;
            for (Edge e : graph.getEdges(edge.getEnd())) {
                if (!visited[e.getEnd()]) {
                    queue.add(e);
                }
            }
        }
        
        tree.setRoot(source);
        
        return tree;
        // 구현하기
        // source 의 경우 시작점으로 시작하는 경우 사용
        // 그렇지 않은 경우, 첫 번째 SpanningTree의 속하는 정점 중에 선택
    }
}
