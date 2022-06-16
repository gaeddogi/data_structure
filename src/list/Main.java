package list;

public class Main {
    public static void main(String[] args) {
//        ArrayList list = new ArrayList(1);
////        //맨 뒤 추가
////        list.add(1);
////        list.add(2);
////        list.add(3);
////        System.out.println(list);
////
////        //중간 추가
////        list.add(1,4);
////        System.out.println(list);
////
////        list.add(4, 1);
////        System.out.println(list);
////
////        //맨 앞 추가
////        list.addFirst(6);
////        System.out.println(list);
////
////        //삭제
////        list.remove();
////        System.out.println(list);
////
////        //중간 삭제
////        list.remove(1);
////        System.out.println(list);
////
////        //검색
////        System.out.println(list.get(0));

//        ArrayList2 list2 = new ArrayList2();
//
//        list2.add(1);
//        System.out.println(list2);
//
//        list2.add(2);
//        System.out.println(list2);
//
//        list2.add(3);
//        System.out.println(list2);
//
//        list2.add(1, 8);
//        System.out.println(list2);
//
//        list2.remove();
//        System.out.println(list2);
//
//        list2.remove(1);
//        System.out.println(list2);
//
//        System.out.println(list2.get(0));
//        System.out.println(list2.get(1));
//        System.out.println(list2.get(4));
//
//        Node node = new Node();
//        System.out.println(node);

//        LinkedList_simply linkedList = new LinkedList_simply();
//
//        for (int i = 0; i < 5; i++) {
//            linkedList.add(i + 1);
//        }
//
//        System.out.println(linkedList);
//
//        linkedList.add(5, "gg");
//        System.out.println(linkedList);
//
//        linkedList.add(2, 6);
//        System.out.println(linkedList);
//
//        linkedList.remove();
//        System.out.println(linkedList);
//
//        linkedList.remove(4);
//        System.out.println(linkedList);
//
//        System.out.println(linkedList.get(4));
//
//        String a = new String("gg");



//        Stack_array stack = new Stack_array();
//
//        stack.push(4);
//        stack.push("zz");
//        stack.push("하이");
//        System.out.println(stack);
//
//        stack.pop();
//        System.out.println(stack);
//
//        stack.pop();
//        System.out.println(stack);
//
//        stack.pop();
//        stack.pop();
//        System.out.println(stack);
//
//        System.out.println(stack.peek());
//
//        for (int i = 31; i < 40; i++) {
//            stack.push(i);
//        }
//        System.out.println(stack);
//
//        System.out.println(stack.peek());


//        Stack_LinkedList_myFirst LStack = new Stack_LinkedList_myFirst();
//        for (int i = 0; i < 5; i++) {
//            LStack.push(i + 1);
//        }
//        System.out.println(LStack);
//
//        System.out.println(LStack.pop());
//        System.out.println(LStack);
//
//        System.out.println(LStack.peek());
//
//        System.out.println(LStack.pop());
//        System.out.println(LStack.pop());
//        System.out.println(LStack);


        Stack_linkedList LStack = new Stack_linkedList();
        for (int i = 0; i < 5; i++) {
            LStack.push(i + 1);
        }
        System.out.println(LStack);

        System.out.println(LStack.pop());
        System.out.println(LStack);

        System.out.println(LStack.peek());



    }


}
