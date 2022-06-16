package list;

public class Stack_linkedList<T> {
    //연결리스트는 맨 앞에 삽입/삭제할 경우 시간복잡도는 O(1)이다.
    //이것을 이용하여 구현할 것이다.
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private int size;
    private Node head;

    public Stack_linkedList() {
        this.size = 0;
        this.head = null;
    }

    public void push(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

        size++;
    }

    public T pop() {
        if (head == null) {
            System.out.println("비어있음");
            return null;
        }

        T data = (T) head.data;

        Node curr = head.next;
        head.next = null;
        head = curr;


        size--;

        return data;
    }

    public T peek() {
        if (head == null) {
            System.out.println("비어있음");
            return null;
        }

        return (T)head.data;
    }

    @Override
    public String toString() {
        String str = "";
        Node curr = head;

        while (curr.next != null) {
            str += curr.data + ",";
            curr = curr.next;
        }

        str += curr.data;

        return str;
    }

}
