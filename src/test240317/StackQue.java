package test240317;

import java.util.*;

public class StackQue {
    public static void main(String[] args) {
        // 스택 후입선출 push(추가) pop(제거)
        Stack<Integer> stack = new Stack<>();

        // 스택에 요소 추가 (push)
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // 스택에서 요소 제거 (pop)
        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);

        // 스택의 맨 위 요소 확인 (peek)
        int topElement = stack.peek();
        System.out.println("Top element: " + topElement);

        // 스택이 비어있는지 확인
        boolean isEmpty = stack.isEmpty();
        System.out.println("Is stack empty? " + isEmpty);


        // 큐 선입선출 offer(추가) poll(제거)
        Queue<String> queue = new LinkedList<>();

        // 큐에 요소 추가 (enqueue)
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");

        // 큐에서 요소 제거 (dequeue)
        String removedElement = queue.poll();
        System.out.println("Removed element: " + removedElement);

        // 큐의 맨 앞 요소 확인 (peek)
        String frontElement = queue.peek();
        System.out.println("Front element: " + frontElement);

        // 큐가 비어있는지 확인
        isEmpty = queue.isEmpty();
        System.out.println("Is queue empty? " + isEmpty);

    }
}
