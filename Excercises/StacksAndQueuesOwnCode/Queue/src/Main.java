import exception.QueueException;
import model.Queue;

public class Main {
    public static void main(String[] args) {

        // *****************************************************

        // Queue = FIFO data structure. First-In First-Out
        //		   A collection designed for holding elements prior to processing
        //		   Linear data structure

        //         enqueue = offer()
        //         dequeue = poll()

        // Where are queues useful?

        // 1. Keyboard Buffer (letters should appear on the screen in the order they're pressed)
        // 2. Printer Queue (Print jobs should be completed in order)
        // 3. Used in LinkedLists, PriorityQueues, Breadth-first search

        // *****************************************************

        Queue<String> queue = new Queue<>();

        try {
            queue.enqueue("str1");
            queue.enqueue("str2");
            queue.enqueue("str3");
            queue.enqueue("str4");
            System.out.println(queue);

            System.out.println(queue.isEmpty());

            System.out.println(queue.front());
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
        }catch (QueueException e){
            System.err.println(e.getMessage());
        }
        System.out.println(queue);
    }
}