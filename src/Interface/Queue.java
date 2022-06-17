package Interface;

public interface Queue<E> {


    /**
     * 큐의 가장 마지막에 요소를 추가합니다.
     *
     * @param e
     * @return 큐에 정상적으로 요소가 추가되면 true 반환
     */
    boolean offer(E e);


    /**
     * 큐의 첫번째 요소를 제거하고, 제거된 요소를 반환합니다.
     *
     * @return 제거된 요소 반환
환    */
    E poll();


    /**
     * 큐의 첫번째 요소를 반환합니다.
     *
     * @return 첫번째 요소 반환
     */
    E peek();
}
