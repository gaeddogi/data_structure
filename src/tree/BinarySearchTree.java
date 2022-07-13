package tree;

public class BinarySearchTree {
    // 정렬되어 있는 정수 배열을 이진 검색 트리로 바꾸기
    // 이진 검색 트리는 검색 시 시간복잡도가 O(logn)

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static Node root;

    public static void makeBST(int[] a) {
        root = makeNode(a, 0, a.length-1);
    }

    public static Node makeNode(int[] a, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;

        Node node = new Node(a[mid]);
        node.left = makeNode(a, start, mid - 1 );
        node.right = makeNode(a, mid + 1, end);

        return node;
    }

    public static void searchNode(Node node, int target) {
        if (node == null) {
            System.out.println("없어");
            return;
        }
        if (node.data > target) {
            System.out.println(node.data + "보다 작음");
            searchNode(node.left, target);
        }
        else if (node.data < target) {
            System.out.println(node.data + "보다 큼");
            searchNode(node.right, target);
        }
        else {
            System.out.println(target + "찾음");
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        makeBST(a);
        searchNode(root, 10);
    }

}
