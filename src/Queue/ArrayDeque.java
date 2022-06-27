package Queue;

import Interface.Queue;

public class ArrayDeque<E> implements Queue<E> {

    private static final int DEFAULT_CAPACITY = 64;
    private int size;
    private int front;
    private int rear;
    private Object[] arr;

    public ArrayDeque() {
        this.size = 0;
        this.front = 0;
        this.rear = 0;
        this.arr = new Object[DEFAULT_CAPACITY];
    }

    public ArrayDeque(int capacity) {
        this.size = 0;
        this.front = 0;
        this.rear = 0;
        this.arr = new Object[capacity];
    }

    private void resize(int capacity) {
        int currCapacity = arr.length;

        Object[] newArr = new Object[capacity];

        for (int i = 1, j = front + 1; i <= size; i++, j++) {
            newArr[i] = arr[j % currCapacity];
        }

        front = 0;
        rear = size;

        arr = newArr;
    }


    @Override
    public boolean offer(E e) {
        if ((rear + 1) % arr.length == front) {
            resize(arr.length * 2);
        }

        rear = (rear + 1) % arr.length;

        arr[rear] = e;

        size++;

        return true;
    }

    public boolean offerFirst(E e) {

        if ((rear + 1) % arr.length == front) {
            resize(arr.length * 2);
        }

        arr[front] = e;
        front = (front -1 + arr.length) % arr.length; // front-1은 음수일수도 있으므로

        size++;

        return true;
    }

    @Override
    public E poll() {
        if (front == rear) {
            System.out.println("빈 덱");
            return null;
        }

        front = (front + 1) % arr.length;

        E e = (E) arr[front];
        arr[front] = null;

        size--;

        if (size > 64 && size < (arr.length / 4)) {
            resize(Math.max(DEFAULT_CAPACITY, arr.length / 2));
        }

        return e;
    }

    public E pollLast() {
        if (rear == front) {
            System.out.println("빈 덱");
            return null;
        }
        E e = (E) arr[rear];

        arr[rear] = null;
        rear = (rear -1 + arr.length) % arr.length;
        size--;

        if (size > 64 && size < (arr.length / 4)) {
            resize(Math.max(DEFAULT_CAPACITY, arr.length / 2));
        }

        return e;
    }

    @Override
    public E peek() {
        if (rear == front) {
            System.out.println("빈 덱");
            return null;
        }

        return (E)arr[(front + 1) % arr.length];
    }

    public E peakLast() {
        if (rear == front) {
            System.out.println("빈 덱");
        }

        return (E)arr[rear];
    }
}
