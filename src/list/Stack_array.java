package list;

import java.util.Arrays;

public class Stack_array { // 배열로 구현한 Stack은 데이터가 많아지면 배열을 복사할 때 버거울거 같다.
    private int capacity;
    private int size;
    private Object arr[];

    public Stack_array() {
        this.size = 0;
        this.capacity = 1;
        this.arr = new Object[capacity];
    }

    public Stack_array(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.arr = new Object[capacity];
    }

    //push / pop / peek
    //push
    public void push(Object o) {
        if (size >= capacity) {
            expandArray();
        }

        arr[size] = o;
        size++;
    }

    public Object pop() {
        if (size <= 0) {
            System.out.println("비어있음");
            return null;
        }

        Object o = arr[size - 1];
        arr[size - 1] = null;
        size--;

        return o;

    }

    public Object peek() {
        if (size <= 0) {
            System.out.println("비어있음");
            return null;
        }

        return arr[size - 1];
    }


    //expandArray
    public void expandArray() {
        this.capacity = this.capacity * 2;
        Object newArr[] = new Object[this.capacity];

        for (int i= 0 ; i < size; i++) {
            newArr[i] = this.arr[i];
        }

        this.arr = newArr;
        System.out.println("배열 늘어남, capacity: " + this.capacity);
    }

    @Override
    public String toString() {
        return "Stack{" +
                "capacity=" + capacity +
                ", size=" + size +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }
}

