package Queue;

import Interface.Queue;

public class LinkedDeque<E> implements Queue<E> {
    // 양뱡향으로 삽입, 삭제가 가능한 큐, 연결리스트로 구현
    // 연결리스트(단방향)는 앞/뒤 삽입 시 시간복잡도 O(1)
    // 삭제는 앞 O(1) 뒤는 바로 전 노드를 찾아야 하므로 O(n)
    // 그러므로 양방향 LinkedList로 구현해야 하나?
    // 양방향 LinkedList는 단방향 LinkedList보다는 포인터를 한 개 더 저장해야 하므로 메모리를 더 많이 사용해야하지만
    // 양뱡향으로 이동해야 할 때 사용한다고 배웠는뎅..뎅뎅
    // 일단 양방향으로 하자

    private static class Node<E> {
        E data;
        Node prev;
        Node next;

        Node() {
            data = null;
            prev = null;
            next = null;

        }

        Node(E data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedDeque() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //offer, offerFirst, poll, pollLast, peek, peekLast

    public boolean offer(E e) {

        if (size <= 0) {
            return offerFirst(e);
        }

        Node<E> newNode = new Node<>(e);

        tail.next = newNode;
        newNode.prev = tail;

        tail = newNode;

        size++;

        return true;
    }

    public boolean offerFirst(E e) {
        Node newNode = new Node(e);

        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;

        if (head.next == null) {
            tail = head;
        }

        size++;

        return true;
    }

    public E poll() {
        if (size <= 0) {
            System.out.println("빈 덱");
            return null;
        }

        E e = (E) head.data;

        Node nextNode = head.next;

        head.data = null;
        head.next = null;


        if (nextNode != null) {
            nextNode.prev = null;
        }

        head = nextNode;

        size--;

        if (size <= 0) {
            tail = null;
        }

        return (E) e;
    }

    public E pollLast() {
        if (size <= 0) {
            System.out.println("빈 덱");
            return null;
        }

        E e = (E) tail.data;

        Node prevNode = tail.prev;

        tail.data = null;
        tail.prev = null;

        if (prevNode != null) {
            prevNode.next = null;
        }

        tail = prevNode;

        size--;

        if (size <= 0) {
            head = null;
        }

        return (E) e;

    }

    public E peek() {
        if (size <= 0) {
            System.out.println("빈 덱");
            return null;
        }

        return (E) head.data;
    }

    public E peekLast() {
        if (size <= 0) {
            System.out.println("빈 덱");
            return null;
        }

        return (E) tail.data;
    }
}
