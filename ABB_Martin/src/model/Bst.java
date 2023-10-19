package model;

public class Bst {
    
    private Node root;


    public String add (int key){
        Node node = new Node(key);
        if (root == null) {
            root = node;
            return "The tree was empty, the node was added as the root";
        } else {
            return add(node, root);
        }
    }

     // Chage the existing add method so that the tree is balanced, that is, the number of nodes to the left and right of the root do not have a difference greater than 1

     private String add(Node node, Node current){
        String message = "The node was added";
        // Compare the keys, this case is where the key of the node to add is less than the key of the current node
        if (node.getKey()<current.getKey()) {
            // If the left child of the current node is null, then the node to add is added as the left child of the current node
            if (current.getLeft() == null) {
                current.setLeft(node);
            } else {
                // If the left child of the current node is not null, then the add method is called again, but this time the current node is the left child of the current node
                add(node, current.getLeft());
            }
        // Compare the keys, this case is where the key of the node to add is greater than the key of the current node
        } else if (node.getKey()>current.getKey()) {
            // If the right child of the current node is null, then the node to add is added as the right child of the current node
            if (current.getRight() == null) {
                current.setRight(node);
            } else {
                // If the right child of the current node is not null, then the add method is called again, but this time the current node is the right child of the current node
                add(node, current.getRight());
            }
        }
        else {
            // If the key of the node to add is equal to the key of the current node
            message = "The node is already in the tree";
        }
        return message;
    }

    public  String delete(Integer goal){
        return delete(null, root, goal);
    }

    private String delete(Node parent, Node current, Integer goal){
        String message = "The node was deleted";
        if(current == null){
            message = "The node was not found";
        }
        // Cuando encontramos el nodo
        if(goal.equals(current.getKey())){
            // El nodo es una hoja del árbol
            if(current.getLeft() == null && current.getRight() == null){
                if(current == this.root){
                    this.root = null;
                }
                // evaluar si el nodo es hijo izquierdo
                else if(parent.getLeft() == current){
                    parent.setLeft(null);
                }
                // evaluar si el nodo es hijo derecho
                else {
                    parent.setRight(null);
                }
            }
            // el nodo a eliminar tiene unicamente un hijo izquierdo
            else if (current.getLeft() != null && current.getRight() == null) {
                if(parent.getLeft() == current){
                    parent.setLeft(current.getLeft());
                } else {
                    parent.setRight(current.getLeft());
                }
            }
            // el nodo a eliminar tiene unicamente un hijo derecho
            else if (current.getLeft() == null && current.getRight() != null) {
                // el nodo es un hijo izquierdo
                if(parent.getLeft() == current){
                    parent.setLeft(current.getRight());
                }
                // el nodo es un hijo derecho
                else {
                    parent.setRight(current.getRight());
                }
            } else if (current.getLeft() != null && current.getRight() != null ) {
                // obtener el successor del nodo --> el menor nodo de los mayores
                Node successor = getMin(current.getRight());

                // un remplazo de los atributos
                current.setKey(successor.getKey());
                // current.setValue(successor.getValue());

                // eliminar el successor --> actualizar las conexiones
                delete(current, current.getRight(), successor.getKey());
            }
        }
        // cuando no lo encuentro
        else if (goal.compareTo(current.getKey()) < 0) {
           delete(current, current.getLeft(), goal);
        }
        else if(goal.compareTo(current.getKey()) > 0){
            delete(current, current.getRight(), goal);
        }
        return message;
    }

    private Node getMin(Node current){
        if(current.getLeft() == null){
            return current;
        }
        return getMin(current.getLeft());
    }
    

    public String inOrder(){
        if (root == null) {
            return "empty tree";
        } else {
            return inOrder(root);
        }
    }

    private String inOrder(Node current){
        if (current == null) {
            return "";
        } else {
            return inOrder(current.getLeft()) + current.getKey() + " " + inOrder(current.getRight());
        }
    }

    public String preOrder(){
        if (root == null) {
            return "empty tree";
        } else {
            return preOrder(root);
        }
    }

    private String preOrder(Node current){
        if (current == null) {
            return "";
        } else {
            return current.getKey() + " " + preOrder(current.getLeft()) + preOrder(current.getRight());
        }
    }

    public String postOrder(){
        if (root == null) {
            return "empty tree";
        } else {
            return postOrder(root);
        }
    }

    private String postOrder(Node current){
        if (current == null) {
            return "";
        } else {
            return postOrder(current.getLeft()) + postOrder(current.getRight()) + current.getKey() + " ";
        }
    }


   

    public int search(int key){
        if (root == null) {
            return -1;
        } else {
            return search(key, root,0);
        }
    }



    private int search(int key, Node current, int level){
       // method must return the level in which the node is found 
        if(key == current.getKey()){
            return level;
        } 
        if(key < current.getKey()){
            level++;
            return search(key, current.getLeft(), level++);
        } if (key > current.getKey()){
            level++;
            return search(key, current.getRight(), level++);
        }
        return level;
    }


    public int treeDepth() {
        if (root == null) {
            return 0;
        } else {
            return treeDepth(root);
        }
    }
    
    private int treeDepth(Node current) {
        if (current == null) {
            return -1; // Change this line to return -1 instead of 0
        } else {
            int leftDepth = treeDepth(current.getLeft());
            int rightDepth = treeDepth(current.getRight());
            if (leftDepth > rightDepth) {
                return leftDepth + 1;
            } else {
                return rightDepth + 1;
            }
        }
    }
    

    public int treeWidth() {
        if (root == null) {
            return 0;
        } else {
            return treeWidth(root);
        }
    }
    
    private int treeWidth(Node current) {
        if (current == null) {
            return 0;
        } else if (current.getLeft() == null && current.getRight() == null) {
            // If the current node is a leaf node, return 1
            return 1;
        } else {
            // Recursively calculate the width by summing the widths of the left and right subtrees
            return treeWidth(current.getLeft()) + treeWidth(current.getRight());
        }
    }
    


    public String successor(int key){
        if (root == null) {
            return "empty tree";
        } else {
            return successor(key, root);
        }
    }

    private String successor(int key, Node current){
        if (current == null) {
            return "The key is not in the tree";
        } else if (current.getKey() == key) {
            if (current.getRight() == null) {
                return "The key does not have a successor";
            } else {
                return "The successor of the key is: " + min(current.getRight());
            }
        } else if (key < current.getKey()) {
            return successor(key, current.getLeft());
        } else {
            return successor(key, current.getRight());
        }
    }

    private int min(Node current){
        if (current.getLeft() == null) {
            return current.getKey();
        } else {
            return min(current.getLeft());
        }
    }

    public String predecessor(int key) {
        if (root == null) {
            return "empty tree";
        } else {
            return predecessor(key, root);
        }
    }
    
    private String predecessor(int key, Node current) {
        if (current == null) {
            return "The key is not in the tree";
        } else if (key == current.getKey()) {
            // Check if there's a left subtree for the predecessor
            if (current.getLeft() != null) {
                return "The predecessor of the key is: " + max(current.getLeft());
            } else {
                return "The key does not have a predecessor";
            }
        } else if (key < current.getKey()) {
            return predecessor(key, current.getLeft());
        } else {
            return predecessor(key, current.getRight());
        }
    }
    
    private int max(Node current) {
        if (current.getRight() == null) {
            return current.getKey();
        } else {
            return max(current.getRight());
        }
    }
    
    
    


}
