package ui;
import model.Bst;
import java.util.Scanner;

public class Main {
    
    private Scanner sc;
    private Bst bst;

    public Main() {
        sc = new Scanner(System.in);
        bst = new Bst();
    }
    public static void main(String[] args) {
        Main main = new Main();

        main.menu();
        int option = main.sc.nextInt();
        while (option != 10) {
            switch (option) {
                case 1:
                    main.defaultAdd();
                    break;
                case 2:
                    System.out.println("Enter the key of the node you want to add");
                    int key = main.sc.nextInt();
                    System.out.println(main.bst.add(key));
                    break;
                case 3:
                    System.out.println("Enter the key of the node you want to delete");
                    int key2 = main.sc.nextInt();
                    System.out.println(main.bst.delete(key2));
                    break;
                case 4:
                    main.printOptions();
                    break;
                case 5:
                    main.search();
                    break;
                case 6:
                    main.successor();
                    break;
                case 7:
                    main.predecessor();
                    break;
                case 8:
                    main.depth();
                    break;
                case 9:
                    main.width();
                    break;
            
                default:
                    System.out.println("Invalid option");
                    break;
            }
            main.menu();
            option = main.sc.nextInt();
        }
        
    }

    public void menu(){
        System.out.println("1. Create tree with the given list ");
        System.out.println("2. Add a node to the tree manually");
        System.out.println("3. Delete a node from the tree");
        System.out.println("4. Print options");
        System.out.println("5. Search a node and its depth");
        System.out.println("6. Find the successor of a node");
        System.out.println("7. Find the predecessor of a node");
        System.out.println("8. Find the depth of the tree");
        System.out.println("9. Find the width of the tree");
        System.out.println("10. Exit");
    }

    public void defaultAdd(){
        int elements[]  = {0,1,2,3,4,5,6,7,8,9,10,11,12};
        bst.add(elements[6]);
        bst.add(elements[3]);
        bst.add(elements[9]);
        bst.add(elements[1]); 
        bst.add(elements[5]);
        bst.add(elements[7]);
        bst.add(elements[11]);
        bst.add(elements[0]);
        bst.add(elements[2]);
        bst.add(elements[4]);
        bst.add(elements[8]);
        bst.add(elements[10]);
        bst.add(elements[12]); 
        System.out.println("Tree created");
    }



    public void search(){
        System.out.println("Enter the node you want to search");
        int key = sc.nextInt();
        if (bst.search(key) == -1) {
            System.out.println("The node is not in the tree");
        } else
            System.out.println( "The node has the depth of: "+ bst.search(key));
    }

    public void successor(){
        System.out.println("Enter the node you want to search the successor of");
        int key = sc.nextInt();
        System.out.println(bst.successor(key));
    }

    public void predecessor(){
        System.out.println("Enter the node you want to search the predecessor of");
        int key = sc.nextInt();
        System.out.println(bst.predecessor(key));
    }

    public void depth(){
        System.out.println("The depth of the tree is: " + bst.treeDepth());
    }

    public void width(){
        System.out.println("The width of the tree is: " + bst.treeWidth());
    }

    public void printOptions(){
        System.out.println("1. Inorder");
        System.out.println("2. Postorder");
        System.out.println("3. Preorder");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.println(bst.inOrder());
                break;
            case 2:
                System.out.println(bst.postOrder());
                break;
            case 3:
                System.out.println(bst.preOrder());
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

}
