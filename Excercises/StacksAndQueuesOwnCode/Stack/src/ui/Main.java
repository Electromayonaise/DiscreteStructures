package ui;

import exception.StackException;
import model.Stack;

public class Main {
    public static void main(String[] args) {

        // *****************************************************

        // stack = LIFO data structure. Last-In First-Out
        //               stores objects into a sort of "vertical tower"
        //		  push() to add objects to the top
        //		  pop() to remove objects from the top

        // uses of stacks?
        // 1. undo/redo features in text editors
        // 2. moving back/forward through browser history
        // 3. backtracking algorithms (maze, file directories)
        // 4. calling functions (call stack)

        // *****************************************************

        Stack<String> stack = new Stack<String>();

        System.out.println("-----------------Before Pushes-----------------");
        System.out.println("Stack before pushes: "+stack);
        System.out.println("isEmpty: "+ stack.isEmpty()); // returns true

        System.out.println("------------------After Pushes-----------------");
        try {
            stack.push("Minecraft"); // pushes a String element
            stack.push("Skyrim");
            stack.push("DOOM");
            stack.push("Borderlands");
            stack.push("FFVII");
            System.out.println("Stack top: "+ stack.top()); // returns the first value on the stack

        }catch (StackException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Stack after pushes: "+stack); // prints the stack
        System.out.println("isEmpty: "+stack.isEmpty()); // returns false
    }
}