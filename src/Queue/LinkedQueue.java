package Queue;

import Interface.Queue;
import list.LinkedList_doubly;

public class LinkedQueue<E> implements Queue<E> {
    private static class Node<E> {
        E data;
        Node next;

        Node() {
            this.data = null;
            this.next = null;
        }

        Node(E data) {
            this.data = data;
            this.next = null;
        }

    }

    private int size;
    private Node<E> head;
    private Node<E> tail;

    public LinkedQueue() {
        this.size = 0;
        this.head = null; //큐 선언시에 미리 head를 할당하는게 좋은가? 아님 null? 일단 큐를 선언한 거니까 할당하는게 좋은거 같다.
                            // 근데 할당해도 마지막 요소까지 모두 삭제하면 결국 head null 됌
                            //아니지 다 개소리고 new 선언하면 힙에 당연히 할당되는거잖아
        this.tail = null;
    }

    //삽입
    @Override
    public boolean offer(E e) {
        Node newNode = new Node<>(e);

        if (head == null) {
            head = newNode;
            tail = head;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;

        return true;
    }

    //삭제
    @Override
    public E poll() {
        if (size <= 0) {
            System.out.println("빈 큐");
            return null;
        }

        E e = head.data;

        head = head.next;
        size--;

        return e;
    }

    //조회
    @Override
    public E peek() {
        if (size <= 0) {
            System.out.println("빈 큐");
            return null;
        }

        return head.data;
    }

    @Override
    public String toString() {
        Node curr = head;
        if (curr == null) {
            return "빈 배열";
        }
        String str = "";
        while (curr.next != null) {
            str += curr.data + ", ";
            curr = curr.next;
        }
        str += curr.data;

        return str + ", size:" + size;
    }
}
