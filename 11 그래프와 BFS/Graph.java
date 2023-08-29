import java.util.LinkedList;

public class Graph {
    int size;
    Node[] heads;

    
    public Graph(int size) {
        // 생성자를 구현하세요.
        this.size = size;
        this.heads = new Node[size];
        for(int i = 0; i < size; i++) {
            this.heads[i] = new Node(i, null);
        }
        // heads 초기화 주의 : 모든 정점은 시작 정점이 존재해야 함
    }
    
    public Graph add(int start, int end) {
        // 간선을 추가하는 함수를 구현하세요.
        Node newNode = new Node(end);
        Node current = this.heads[start];
        while(current.getLink() != null) {
            current = current.getLink();
        }
        current.setLink(newNode);

        Node newNode2 = new Node(start);
        Node current2 = this.heads[end];
        while(current2.getLink() != null) {
            current2 = current2.getLink();
        }
        current2.setLink(newNode2);
        return this;
    }
    
    
    // 정점을 탐색하세요.
    // 정점의 번호가 낮은 것부터 방문하도록 합니다.
    public void bfs(int v, Visitor visitor) {
        LinkedList<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[this.size];
    
        visited[v] = true;
        q.add(v);
    
        while (!q.isEmpty()) {
            int node = q.poll();
            visitor.visit(node);
    
            Node temp = this.heads[node].link;
            while (temp != null) {
                if (!visited[temp.data]) {
                    q.add(temp.data);
                    visited[temp.data] = true;
                }
                temp = temp.link;
            }
        }
    }
}

        
        
        