// 이번 실습은 Graph 를 상속하여 Tree 구현하세요.
// Graph 에서 추가 수정이 필요한 경우 추가하기 바랍니다.
public class SpanningTree extends Graph {
    // size 는 정점의 개수
    int root;
    
    // Tree의 표현은 자유롭게 구성하기
    public SpanningTree(int size) {
        super(size);
    }
    
    public void setRoot(int root) {
        this.root = root;
    }
    
    public int getRoot() {
        return this.root;
    }
    
    // 간선의 weight 합 추가
    public int weight() {
        int result = 0;
        for(Edge edge: getEdges()) { 
            result += edge.getWeight(); 
        }
        return result;
    }

    public void print() {   // 인접 행렬 출력
        System.out.println("COST = " + this.weight());
        for(Edge edge: getEdges()) {
            System.out.println(edge);
        }
    }
}
