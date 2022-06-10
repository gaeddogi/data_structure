package list;

import java.util.Arrays;

public class ArrayList {
    //capacity(배열 크기)
    //배열
    //size(실제 저장된 크기)

    final static int MAX_SIZE = 100;
    private int[] arr;
    int size;

    // 기본생성자
    public ArrayList() {
        super(); // 알아봐
        this.size = 0;
        arr = new int[MAX_SIZE];
    }

    // 매개변수 있는 생성자
    public ArrayList(int capacity) {
        this.size = 0;
        arr = new int[capacity];
    }

    /**
     * 데이터 추가 (맨 뒤)
     */
    public void add(int data) {
        int capacity = this.arr.length; //배열크기
        // 배열 크기와 실제 저장된 크기가 같다면 새배열 생성 & 복사
        if (capacity == this.size) {
            expandArray(capacity);
        }

        this.arr[this.size] = data;
        this.size++;//항상 size는 마지막으로 저장되어 있는 인덱스에 +1이다


    }

    /**
     * 데이터 추가 (중간)
     */
    public void add(int index, int data) {
        int capacity = this.arr.length;

        if (capacity == this.size) {
            expandArray(capacity);
        }

        // 마지막 데이터부터 한칸씩 뒤로 밀어
        for (int i = size; i > index; i--) {
            arr[i] = arr[i -1];
        }

        // 추가
        arr[index] = data;
        // 저장된 크기 늘어남
        size++;
    }

    /**
     * 데이터 추가 (맨 앞)
     *
     */
    public void addFirst(int data) {
        add(0, data);
    }


    /**
     *  데이터 삭제 (맨 뒤)
     */
    public void remove() {
        arr[size - 1] = 0;
        size--;
    }

    /**
     *  데이터 삭제 (중간)
     */
    public void remove(int index) {

        arr[index] = 0;
        size--;

        for (int i = index; i < size ; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size] = 0;

    }

    /**
     * 조회
     */
    public int get(int index) {
//        //존재하지 않는 인덱스이다?
//        if (index >= size) {
//            throw new ArrayIndexOutOfBoundsException();
//        }
        return arr[index];
    }

    /**
     * 배열 확장
     */
    public void expandArray(int capacity) {
        int[] newArr = new int[capacity + 1];

        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }

        //arr = newArr; // 왜 이렇게 안하는거지? 얕은복사 하면 안되나? 상관없지 않나?
        arr = new int[capacity + 1];
        for (int i = 0; i < newArr.length; i++) {
            arr[i] = newArr[i];
        }
    }


    /**
     * toString override
     */
    @Override
    public String toString() {

        return "ArrayList{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                '}';
    }

}
