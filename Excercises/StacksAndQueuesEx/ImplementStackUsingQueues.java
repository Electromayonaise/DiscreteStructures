package DiscreteStructures.Excercises.StacksAndQueuesEx;
/**
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 

Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False
 */

import java.util.Queue;
import java.util.LinkedList;

public class ImplementStackUsingQueues {
    
    private Queue<Integer> queue;
    private Queue<Integer> temp;
    
    public ImplementStackUsingQueues() {
        queue = new LinkedList<>();
        temp = new LinkedList<>();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues stack = new ImplementStackUsingQueues();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
    
    public void push(int num) {
        queue.add(num);
    }

    public int top() {
        while (queue.size() > 1) {
            temp.add(queue.remove());
        }
        int item = queue.remove();
        temp.add(item);
        while (!temp.isEmpty()) {
            queue.add(temp.remove());
        }
        return item;
    }

    public int pop() {
        while (queue.size() > 1) {
            temp.add(queue.remove());
        }
        int item = queue.remove();
        while (!temp.isEmpty()) {
            queue.add(temp.remove());
        }
        return item;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}
