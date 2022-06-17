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
        this.head = null;
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
