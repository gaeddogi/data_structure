package Set;

import Interface.Set;

public class LinkedHashSet<E> implements Set<E> {

    private static class Node<E> {
        E key;
        int hash;
        Node next;

        Node prevLink;
        Node nextLink;

        public Node(E key, int hash, Node next) {
            this.key = key;
            this.hash = hash;
            this.next = next;
            this.prevLink = null;
            this.nextLink = null;
        }
    }

    private static final int DEFAULT_CAPACITY = 1 << 4;
    private static final float LOAD_FACTOR = 0.75f;

    private int size;
    private Node<E>[] table;

    private Node<E> head;
    private Node<E> tail;

    public LinkedHashSet() {
        this.size = 0;
        this.table = new Node[DEFAULT_CAPACITY];
        this.head = null;
        this.tail = null;
    }

    private static int hash(Object o) {
        int hash;

        if (o == null) {
            return 0;
        }
        else {
            return Math.abs(hash = o.hashCode()) ^ (hash >>> 16);
        }
    }

    @Override
    public boolean add(E e) {
        return add(hash(e), e) == null;
    }

    private E add(int hash, E key) {
        int idx = hash % table.length;

        Node<E> newNode = new Node<E>(key, hash, null);



        if (table[idx] == null) {

            table[idx] = newNode;

        }
        else {
            Node<E> curr = table[idx];
            Node<E> prev = null;

            while (curr != null) {
                if ((curr.hash == hash) && (curr.key == key || curr.key.equals(key))) {
                    return key;
                }

                prev = curr;
                curr = curr.next;
            }

            prev.next = newNode;
        }

        size++;

        if (head == null) { // size == 0

            head = newNode;

        }
        else {
            newNode.prevLink = tail;
            tail.nextLink = newNode;

            tail = newNode;
        }

        return null;
    }

    private void resize() {
        int newCapacity = table.length * 2;

        Node<E> [] newTable = new Node[newCapacity];

        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                continue;
            }

            Node<E> curr = table[i];
            Node<E> next = null;

            while (curr != null) {
                int idx = curr.hash % newCapacity;

                Node<E> cTail = newTable[idx]; //chaning tail

                if (newTable[idx] == null) {
                    next = curr.next;
                    curr.next = null;
                    newTable[idx] = curr;
                }
                else {

                    while (cTail.next != null) {
                        cTail = cTail.next;
                    }

                    next = curr.next;
                    curr.next = null;
                    cTail = curr;

                }

                curr = next;
            }
        }

        table = newTable;
    }

    @Override
    public boolean remove(E e) {
        return remove(hash(e), e) != null;
    }

    private E remove(int hash, E key) {
        int idx = hash % table.length;

        // 인덱스가 같아도 (해시코드가 같고 내용이 동일한 객체 => 같은 객체)가 아닐 수 있으므로
        // 해당 인덱스에 체이닝 된 노드들 중 동일 노드를 찾아 삭제해라.

        if (table[idx] == null) {
            return null;
        }

        Node<E> curr = table[idx];
        Node<E> prev = null;
        Node<E> removeNode = null;

        while (curr != null) {
            if ((curr.hash == hash) && (curr.key == key || curr.key.equals(key))) {

                removeNode = curr;

                if (prev == null) {
                    table[idx] = curr.next;
                }
                else {
                    prev.next = curr.next;

                }

                // 순서를 위한 link를 바꿔준다.
                Node<E> prevLink = curr.prevLink;
                Node<E> nextLink = curr.nextLink;

                if (prevLink == null) { // head
                    head = nextLink;
                }
                else { // head x
                    prevLink.nextLink = nextLink;
                }

                if (nextLink == null) { // tail
                    tail = prevLink;
                }
                else { // tail x
                    nextLink.prevLink = prevLink;
                }


                size--;
                break;

            }

            prev = curr;
            curr = curr.next;
        }

        return (E) removeNode;
    }
}
