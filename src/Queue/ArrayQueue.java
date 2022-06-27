package Queue;

import Interface.Queue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {

    private static final int DEFAULT_CAPACITY = 64; // 상수라 static final
    private int size; // 요소의 크기(front 안 침)
    private int front; // 시작 인덱스
    private int rear; // 끝 인덱스
    private Object[] arr;

    public ArrayQueue() {
        size = 0;
        front = 0;
        rear = 0;
        arr = new Object[DEFAULT_CAPACITY];
    }

    public ArrayQueue(int capacity) {
        size = 0;
        front = 0;
        rear = 0;
        arr = new Object[capacity];
    }

    public void resize(int capacity) {
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
    public boolean offer(Object o) {

        if ((rear + 1) % arr.length == front) { // size + 1== arr.length - 1보다 직관적이라서?
            resize(arr.length * 2);
        }

        rear = (rear + 1) % arr.length;

        arr[rear] = o;
        size++;

        return true;
    }

    @Override
    public E poll() {
        if (size <= 0) {
            System.out.println("빈 큐다");
            return null;
        }

        front = (front+ 1) % arr.length;

        E e = (E) arr[front];

        arr[front] = null;
        size--;

        if (arr.length > DEFAULT_CAPACITY && size < arr.length / 4) {
            resize(Math.max(DEFAULT_CAPACITY, arr.length / 2));
        }

        return e;
    }

    // poll() 과 remove() 는 둘 다 삭제하는 메소드인데,
    // 삭제할 요소가 없을 경우 반환값이 다르다.
    // poll -> null 반환
    // remove -> noSuchElementException 반환
    public E remove() {
        E e = poll();

        if (e == null) {
            throw new NoSuchElementException();
        }

        return e;
    }

    @Override
    public E peek() {

        if (size <= 0) {
            System.out.println("빈 큐다");
            return null;
        }

        return (E) arr[(front + 1) % arr.length];

    }

    public E element() {
        E e = peek();

        if (e == null) {
            throw new NoSuchElementException();
        }

        return e;
    }


}
