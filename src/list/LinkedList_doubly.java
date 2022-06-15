package list;

import java.util.Objects;

public class LinkedList_doubly<E> {
    private static class Node<E> {
        private E data;
        private Node next;
        private Node prev;

        public Node() {
            this.data = null;
            this.next = null;
            this.prev = null;
        }

        public Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public Node(E data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    private int size;
    private Node head;
    private Node tail;

    public LinkedList_doubly() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    //삽입 (처음)
    public void addFirst(E data) {
        Node newNode = new Node(data);

        if (size <= 0) {
            head = newNode;
            tail = head;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    public void add(E data) {
        Node newNode = new Node(data);

        if (size <= 0) {
            addFirst(data);
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;

        size++;

    }

    public void add(int index, E data) {
        if (index < 0 || index >= size) {
            System.out.println("인덱스 초과");
            return;
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);

        Node prev = get(index - 1);
        Node curr = prev.next;


        prev.next = newNode;
        newNode.prev = prev;

        curr.prev = newNode;
        newNode.next = curr;

        if (newNode.next == null) {
            tail = newNode;
        }

        size++;
    }

    //remove
    public void remove(int index) {
        Node node = get(index); //get 메소드가 index가 음수이거나, index가 초과하는 경우 에러처리 함(여기에 size가 0일 경우도 포함됨)

        System.out.println(node);
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        node.prev = null;
        node.next = null;

        if (next.next == null) {
            tail = next;
        }
        size--;

    }

    public void remove() {

        remove(size - 1);

    }


    public Node get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("인덱스 초과");
            return null;
        }

        int center = size / 2;

        Node curr = null;
        if (index + 1 <= center) {

            curr = head; // 시작점이 head
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }

        }
        else {
            curr = tail;
            for (int i = size -1 ; i > index; i--) {
                curr = curr.prev;
            }
        }

        return curr;
    }

    @Override
    public String toString() {
        Node curr = this.head;
        String str = "";
        while (curr.next != null) {
            str += curr.data + ",";
            curr = curr.next;
        }
        str += curr.data;
        return "LinkedList_doubly{" +
                "size=" + size +
                ", list=[" + str + "]" +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
    //삽입 (맨 뒤)
//    public void add(E data) {
////        Node curr = this.head; //헤더
////
////        while (curr.next != null) {
////            curr = curr.next; // 마지막 노드 찾기
////        }
////
////        curr.next = new Node(data); //마지막 노드에 새로운 노드 연결
////
////        this.tail = curr.next; // 꼬리는 새 노드
//        if (size <= 0) { // size == 0
//            Node newNode = new Node(data, this.head, null);
//
//            this.head.next = newNode;
//            this.tail = newNode;
//
//            size++;
//        }
//        else {
//            Node newNode = new Node(data, this.tail, null);
//
//            this.tail.next = newNode;
//
//            size++;
//        }
//    }

    //삽입 (중간)
//    public void add(int index, E data) {
//        if (index < 0 || index >= size) {
//            System.out.println("인덱스 초과");
//            return;
//        }
//
//        Node curr = this.head;
//
//        for (int i = 0; i < index; i++) {
//            curr = curr.next;
//        }
//
//        Node newNode = new Node(data, curr, curr.next);
//        curr.next = newNode;
//        newNode.next.prev = newNode;
//
//        size++;
//    }
}
