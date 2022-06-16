package list;

public class Stack_LinkedList_myFirst<T> {
    private static class Node<T> {
        private T data;
        private Node prev; // 없어도 될 것 같음 -> 삭제 때문에 있어야 해
        private Node next;

        public Node() {
            this.data = null;
            this.prev = null;
            this.next = null;
        }

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private int size;
    private Node head;
    private Node tail;

    public Stack_LinkedList_myFirst() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    // push / pop / peek

    //push
    public void push(T data) {
        Node node = new Node(data);

        if (size <= 0) {
            this.head = node;
            this.tail = head;
        }
        else {
            this.tail.next = node;
            node.prev = tail;
            this.tail = node;

        }

        size++;
    }

    //pop
    public T pop() {
        if (size <= 0) {
            System.out.println("비어있음");
            return null;
        }

        T data = (T) this.tail.data; // 왜 T로 안되지?

        Node tailPrev = this.tail.prev;
        tailPrev.next = null;
        this.tail.prev = null;
        this.tail = tailPrev;

        size--;

        return data;
    }

    //peek
    public T peek() {
        if (size <= 0) {
            System.out.println("비어있음");
        }

        return (T)tail.data;
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

        return str;
    }

    // 그 회사에서 일하는 사람들의 블로그에서 글을 찾아서 하는 일이 무엇인지 파악해라.
    // 회사에서 운영하는 개발블로그를 활용해라.
}
