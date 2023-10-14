package data_structure;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    private static void test1() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(3, (i1, i2) -> i1 - i2);
        queue.add(3);
        queue.add(1);
        queue.add(2);
        queue.add(4);
        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    public static void main(String[] args) {
        test1();
    }
}
