package Tree;

public class Main {
    public static void main(String[] args) {

        Tree tree = new Tree();

        Node node8 = new Node(8, null, null);
        Node node9 = new Node(9, null, null);
        Node node4 = new Node(4, node8, node9);
        Node node5 = new Node(5, null, null);
        Node node6 = new Node(6, null, null);
        Node node7 = new Node(7, null, null);
        Node node2 = new Node(2, node4, node5);
        Node node3 = new Node(3, node6, node7);
        Node node1 = new Node(1, node2, node3);

//        Node node4 = tree.makeTree(4, null, null);
//        Node node5 = tree.makeTree(5, null, null);
//        Node node2 = tree.makeTree(2, node4, node5);
//        Node node3 = tree.makeTree(3, null, null);
//        Node node1 = tree.makeTree(1, node2, node3);

        tree.setRoot(node1);

        tree.postOrder(tree.getRoot());





    }
}
