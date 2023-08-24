public class App {
    // create() 를 구현하세요.
    public static TreeNode create() {
        // (1) Terminal Node
        TreeNode n25 = TreeNode.build(null, 25, null);
        TreeNode n45 = TreeNode.build(null, 45, null);
        
        // (2) Parent Node ~ Ancestors 구성
        TreeNode n43 = TreeNode.build(null, 43, n45);
        TreeNode n50 = TreeNode.build(n43, 50, null);
        TreeNode n30 = TreeNode.build(n25, 30, n50);

        // (3) Root 노드 반환
        return n30;
    }
    
    public static void main(String[] args) {
        TreeNode tree = create();
        
        Visitor visitor = (data) -> {
            System.out.print(" " + data + " ");
        };

        System.out.print("Higher than 40: ");
        tree.higher(40, visitor);
        System.out.println();
    }
}