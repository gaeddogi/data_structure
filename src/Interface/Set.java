package Interface;

/**
 * 자바 Set Interface
 * @param <E>
 */
public interface Set<E> {


    /**
     * 해당 요소가 없으면 데이터를 추가합니다.
     *
     * @param e 추가할 요소
     * @return 정상적으로 추가되면 true, else false
     */
    boolean add(E e);


    /**
     * 해당 요소가 있으면 삭제합니다.
     *
     * @param e 삭제할 요소
     * @return 정상적으로 삭제되면 true, else false
     */
    boolean remove(E e);

    /**
     * 해당 요소가 있는지 여부를 반환합니다.
     *
     * @param e 확인할 요소
     * @return 있으면 true, else false
     */
    boolean contains(E e);

    /**
     * 해당 객체와 현재 집합이 같은지 여부를 반환합니다.
     *
     * @param e 비교할 객체
     * @return 같으면 true, else false
     */
//    boolean equals(E e);

    /**
     * 집합이 비어있는지 여부를 반환합니다.
     *
     * @return 비어있으면 true, else false
     */
    boolean isEmpty();

    /**
     * 집합 요소 개수를 반환합니다.
     * Integer.MAX_VALUE를 넘으면 Integer.MAX_VALUE 반환
     *
     * @return 집합 요소 개수 반환
     */
    int size();

    /**
     * 집합의 모든 요소를 제거합니다.
     */
    void clear();


}
