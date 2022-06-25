package Set;

import Interface.Set;

public class HashSet<E> implements Set<E> {

    private static class Node<E> {
        private int hash;
        private E key;
        private Node next;

        public Node(int hash, E key, Node next) {
            this.hash = hash;
            this.key = key;
            this.next = next;
        }
    }

    private static final int DEFAULT_CAPACITY = 1 << 4;
    private static final float LOAD_FACTOR = 0.75f;

    private int size;
    private Node<E>[] table;

    public HashSet() {
        this.size = 0;
        this.table = new Node[DEFAULT_CAPACITY];
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

        if (table[idx] == null) { // 중복값 체크 할 필요 x
            table[idx] = new Node<E>(hash, key, null);
        }
        else { // 중복값 체크해서 없으면 맨 끝 노드에 삽입
            Node<E> curr = table[idx];
            Node<E> prev = null;

            while (curr != null) {
                if ((curr.hash == hash) && (curr.key == key || curr.key.equals(key))) {
                    return key;
                }
                prev = curr;
                curr = curr.next;
            }

            //prev는 null일 수 없음
            prev.next = new Node<E>(hash, key, null);
        }

        size++;

        if (size >= LOAD_FACTOR * table.length) {
            resize();
        }

        return null;
    }

    private void resize() {
        int newCapacity = table.length * 2;

        Node<E>[] newTable = new Node[newCapacity];

        for (int i = 0; i < table.length; i++) {

            if (table[i] == null) { // 배열 해당 인덱스에 값이 없으면 다음 인덱스로
                continue;
            }

            Node<E> curr = table[i];
            Node<E> next = null;

            while (curr != null) {
                int idx = curr.hash % newCapacity;

                Node<E> tail = newTable[idx];

                if (tail == null) { // 새로운 배열의 해당 인덱스가 비어 있을 경우

                    next = curr.next;
                    curr.next = null;
                    newTable[idx] = curr;

                }
                else { // 새로운 배열의 해당 인덱스가 있을 경우 마지막 노드에 연결

                    while (tail.next != null) {
                        tail = tail.next;
                    }

                    next = curr.next;
                    curr.next = null;
                    tail.next = curr;

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

        if (table[idx] == null) { // 배열의 해당 인덱스가 비어있으면
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
                    //curr = null; gc
                }
                else {
                    prev.next = curr.next;
                    //curr = null; gc
                }
                size--;
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        return (E) removeNode;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }
}
