package list;

import list.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(1);
        //맨 뒤 추가
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        //중간 추가
        list.add(1,4);
        System.out.println(list);

        list.add(4, 1);
        System.out.println(list);

        //맨 앞 추가
        list.addFirst(6);
        System.out.println(list);

        //삭제
        list.remove();
        System.out.println(list);

        //중간 삭제
        list.remove(1);
        System.out.println(list);

        //검색
        System.out.println(list.get(0));

    }
}
