package Tree;

public class Tree {

    private Node root;

    public Tree() {
        this.root = null;
    }

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node node) {
        this.root = node;
    }

//    public Node makeTree(int e, Node leftNode, Node rightNode) {
//        Node newNode = new Node(e, leftNode, rightNode);
//
//        return newNode;
//    }

    // preOrder(전위순회) root-l-r
    public void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
    }

    // InOrder(중위순회) l-root-r
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.leftNode);
            System.out.println(node.data);
            inOrder(node.rightNode);
        }
    }

    //PostOrder(후위순회) l-r-root
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.leftNode);
            postOrder(node.rightNode);
            System.out.println(node.data);
        }
    }


//    public void add(int e) {
//        Node newNode = new Node(e, null, null);
//
//        if (root == null) {
//            root = newNode;
//        }
//        else {
//            Node node = root;
//
//            while (node != null) {
//
//
//            }
//        }

//    }

}

class Node {
    int data;
    Node leftNode;
    Node rightNode;

    public Node(int data, Node leftNode, Node rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

}



