package test;

import java.util.ArrayDeque;
import java.util.Deque;

public class test03 {
    /**
     * push 加入栈顶
     * add  加入栈底
     * @param args
     */
    public static void main(String[] args) {
        Deque <Integer> deque=new ArrayDeque<>();
        Deque <Integer> deque2=new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);
        deque.add(5);
        deque.add(6);
        deque.add(7);
        System.out.println(deque.getLast());


    }
}
