package graph;

import queue.LinkedQueue;

import java.util.*;

class Graph {
    class Node {
        int data;
        LinkedList<Node> adjacency;
        boolean marked;

        Node(int data) {
            this.data = data;
            this.marked = false;
            this.adjacency = new LinkedList<>();
        }
    }
    Node[] nodes;

    /**
     * Graph 클래스의 생성자로,
     * 매개변수의 숫자만큼 노드배열 방을 생성하고,
     * 노드 값은 배열의 인덱스를 갖는다.
     */
    Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    /**
     * 그래프에 있는 노드들의 관계를 정의해주는 함수
     * 즉, 노드들간에 간선을 연결해준다.
     * 매개변수는 노드가 있는 배열의 인덱스 번호이다.
     */
    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        if (!n1.adjacency.contains(n2)) {
            n1.adjacency.add(n2);
        }
        if (!n2.adjacency.contains(n1)) {
            n2.adjacency.add(n1);
        }
    }

    /**
     * 깊이 우선 탐색
     * 매개변수가 없을 경우 그래프의 첫번째 인덱스에 있는 노드부터 시작한다.
     */
    void dfs() {
        dfs(0);
    }

    /** 매개변수로 들어온 인덱스 노드로부터 깊이 우선 탐색을 한다.
     * @param i 탐색을 시작할 노드의 인덱스 번호
     */
    void dfs(int i) {
        Node root = nodes[i];
        Stack<Node> stack = new Stack<>();

        root.marked = true;
        stack.push(root);

        while (!stack.isEmpty()) {
            Node r = stack.pop();

            for (Node n : r.adjacency) {
                if (n.marked == false) {
                    n.marked = true;
                    stack.push(n);
                }
            }

            System.out.println(r.data);

        }
    }

    /**
     * 너비우선탐색
     * 매개변수가 없으면 그래프의 첫번째 인덱스부터 탐색을 시작한다.
     */
    void bfs() {
        bfs(0);
    }

    /**
     * 재귀함수로 구현한 깊이 우선 탐색
     * 매개변수가 없으므로 그래프의 첫번째 노드부터 탐색을 시작한다.
     */
    void bfsR() {
        bfsR(nodes[0]);
    }

    /**
     * 매개변수로 들어온 노드로부터 깊이우선탐색을 시작한다.
     * @param root 탐색을 시작할 노드
     */
    void bfsR(Node root) {
        if (root == null) {
            return;
        }
        root.marked = true;
        System.out.println(root.data);

        for (Node n : root.adjacency) {
            if (n.marked == false) {
                bfsR(n);
            }
        }
    }

    void bfsR(int i) {
        Node node = nodes[i];
        bfsR(node);
    }


    /**
     * 매개변수로 들어온 수의 인덱스 번호 노드로부터 너비우선탐색을 시작한다.
     * @param i 탐색을 시작할 노드 인덱스 번호
     */
    void bfs(int i) {
        Node root = nodes[i];
        LinkedQueue<Node> queue = new LinkedQueue();

        root.marked = true;
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node r = queue.poll();

            for (Node n : r.adjacency) {
                if (n.marked == false) {
                    n.marked = true;
                    queue.offer(n);
                }
            }

            System.out.println(r.data);
        }
    }



}
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);

        graph.bfsR(3);
    }
}
