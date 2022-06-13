package list;

public class LinkedList_simply<T> {
    private int size;
    private Node head;

    private class Node<T> {

        private T data;
        private Node next;

        public Node() {
            this.data = null;
        }

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
    public LinkedList_simply() {
        this.size = 0;
        this.head = new Node(null); // dummy
    }

    //add 맨 뒤
    public void add(T t) {
        Node curr = this.head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(t);
        System.out.println(curr.next);
        size++;
    }
    //add 중간
    public void add(int index, T t) {
        if (index > size) {
            System.out.println("오류 : 인덱스 큼");
            return;
        }
        if (index == size) {
            add(t);
            return;
        }

        Node prev = this.head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node curr = prev.next;
        prev.next = new Node(t, curr);
        size++;

    }

    //remove 맨 뒤
    public void remove() {
        if (size <= 0) {
            System.out.println("빈 리스트 임");
            return;
        }

        Node prev = this.head;
        Node curr = prev.next;
        while (curr.next != null) {
            prev = prev.next;
            curr = curr.next;
        }

        prev.next = null;
        size--;
    }

    //remove 중간
    public void remove(int index) {
        if (size <= 0) {
            System.out.println("빈 리스트 임");
            return;
        }

        Node prev = this.head;
        Node curr = prev.next;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
            curr = prev.next;
        }

        prev.next = curr.next;
        curr.next = null;

        size--;

    }
    //get(index)
    public T get(int index) {
        if (index >= size) {
            System.out.println("인덱스 초과");
            return null;
        }

        Node prev = this.head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        return (T)prev.next.data;
    }

    @Override
    public String toString() {
        return "LinkedList_simply{" +
                "size=" + size +
                ", head=" + head +
                '}';
    }
}
