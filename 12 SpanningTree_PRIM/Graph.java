import java.util.List;
import java.util.ArrayList;

public class Graph {
    // 인접행렬 혹은 인접리스트로 구현하기
    // 무방향 그래프를 표현한다.
    boolean directed;
    // size 는 정점의 개수
    int size;
    final static int MAX = 999;
    public Graph(int size) {
        this.size = size;
    }
    
    public void add(int start, int end, int weight) {
        // 간선 추가 함수 구현하기
    }
    
    public int getWeight(int start, int end) {
        // 정점 start 와 정점 end 에 부속된 간선의 가중치 구하기
        
        return 0;
    }
    
    public List<Edge> getEdges(int start) {
        // start를 시작 정점으로 하는 Edge들의 목록을 반환한다.
        List<Edge> edges = new ArrayList<>();
        
        // 인접행렬의 경우, 종료정점을 0 ~ size 까지 방문하여 간선을 찾는다.
        //
        // for(int e=0;e<this.size;e++) {
        //    let weight = 간선 <start, e> 의 weight;
        //    if( weight is 유효함 ) {
        //        edges.add(new Edge(start, e, weight));
        //    }
        // }
        
        // 인접리스트의 경우, 시작정점에 해당하는 인접리스트를 찾아
        // 모든 end 정점들에 대한 간선을 찾는다.
        // 인접 리스트의 노드는 weight 와 end 정점의 쌍을 원소로 한다.
        //
        // let node = <start, *>
        // while(node 가 다음 노드가 있는 경우) {
        //     let node = node.next;
        //     edges.add(new Edge(start, node.end, node.weight));
        // }
        
        return edges;
    }
    
    public List<Edge> getEdges() {
        List<Edge> edges = new ArrayList<>();
        boolean visited[] = new boolean[this.size];

        for(int v=0;v<this.size;v++) {
            visited[v] = false;
        }

        for(int s=0;s<this.size;s++) {
            List<Edge> e = this.getEdges(s);
            for(Edge edge:e) {
                if( ! visited[edge.getEnd()] ) {
                    edges.add(edge);
                    visited[edge.getEnd()] = true;
                }
            }
            visited[s] = true;
        }
        return edges;
    }

    public void print() {   // 인접 행렬 출력
        System.out.println("SIZE = " + this.size);
        for(Edge edge: getEdges()) {
            System.out.println(edge);
        }
    }
}
