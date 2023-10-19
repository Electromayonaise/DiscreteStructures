package model;

// This imports are only for the tree structure method (getTreeStructure)
import java.util.ArrayList;
import java.util.List;

public class  AVL {
    
    private static  Node root;


    public void add(int key) {
        root = add(key, root);
    }

    private Node add(int key, Node current) {
        if (current == null) {
            return new Node(key);
        }

        if (key < current.getKey()) {
            current.setLeft(add(key, current.getLeft()));
        } else if (key > current.getKey()) {
            current.setRight(add(key, current.getRight()));
        } else {
            // If the key is equal, do not add it again (optional)
            return current;
        }

        // Update height of the current node
        current.setDepth(1 + Math.max(getHeight(current.getLeft()), getHeight(current.getRight())));

        // Perform rotations to balance the tree
        int balance = getBalance(current);

        // Left-Left case
        if (balance > 1 && key < current.getLeft().getKey()) {
            return rightRotate(current);
        }
        // Right-Right case
        if (balance < -1 && key > current.getRight().getKey()) {
            return leftRotate(current);
        }
        // Left-Right case
        if (balance > 1 && key > current.getLeft().getKey()) {
            current.setLeft(leftRotate(current.getLeft()));
            return rightRotate(current);
        }
        // Right-Left case
        if (balance < -1 && key < current.getRight().getKey()) {
            current.setRight(rightRotate(current.getRight()));
            return leftRotate(current);
        }

        return current;
    }



    public void delete(int key) {
        root = delete(key, root);
    }

    private Node delete(int key, Node current) {
        if (current == null) {
            return current;
        }

        if (key < current.getKey()) {
            current.setLeft(delete(key, current.getLeft()));
        } else if (key > current.getKey()) {
            current.setRight(delete(key, current.getRight()));
        } else {
            if ((current.getLeft() == null) || (current.getRight() == null)) {
                Node temp = (current.getLeft() != null) ? current.getLeft() : current.getRight();
                if (temp == null) {
                    current = null;
                } else {
                    current = temp;
                }
            } else {
                Node temp = getMin(current.getRight());
                current.setKey(temp.getKey());
                current.setRight(delete(temp.getKey(), current.getRight()));
            }
        }

        if (current == null) {
            return current;
        }

        current.setDepth(1 + Math.max(getHeight(current.getLeft()), getHeight(current.getRight())));

        int balance = getBalance(current);

        if (balance > 1) {
            int balanceLeft = getBalance(current.getLeft());
            // Left-Left case
            if (balanceLeft >= 0) {
                return rightRotate(current);
            }
            // Left-Right case
            if (balanceLeft < 0) {
                current.setLeft(leftRotate(current.getLeft()));
                return rightRotate(current);
            }
        }

        if (balance < -1) {
            int balanceRight = getBalance(current.getRight());
            // Right-Right case
            if (balanceRight <= 0) {
                return leftRotate(current);
            }
            // Right-Left case
            if (balanceRight > 0) {
                current.setRight(rightRotate(current.getRight()));
                return leftRotate(current);
            }
        }

        return current;
    }


    private Node leftRotate(Node current) {
        Node newRoot = current.getRight();
        Node temp = newRoot.getLeft();

        newRoot.setLeft(current);
        current.setRight(temp);

        current.setDepth(1 + Math.max(getHeight(current.getLeft()), getHeight(current.getRight())));
        newRoot.setDepth(1 + Math.max(getHeight(newRoot.getLeft()), getHeight(newRoot.getRight())));

        return newRoot;
    }

    private Node rightRotate(Node current) {
        Node newRoot = current.getLeft();
        Node temp = newRoot.getRight();

        newRoot.setRight(current);
        current.setLeft(temp);

        current.setDepth(1 + Math.max(getHeight(current.getLeft()), getHeight(current.getRight())));
        newRoot.setDepth(1 + Math.max(getHeight(newRoot.getLeft()), getHeight(newRoot.getRight())));

        return newRoot;
    }

    // Helper methods for AVL balance factor and height calculation
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getDepth();
    }

    public int getBalanceFactorofRoot(){
        return getBalance(root);
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.getLeft()) - getHeight(node.getRight());
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

    public static String getTreeStructure() {
        List<List<String>> lines = new ArrayList<>();
        List<Node> level = new ArrayList<>();
        List<Node> next = new ArrayList<>();

        level.add(root);
        int nn = 1;
        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<>();
            nn = 0;

            for (Node n : level) {
                if (n == null) {
                    line.add(null);
                    next.add(null);
                    next.add(null);
                } else {
                    String aa = String.valueOf(n.getKey());
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();
                    next.add(n.getLeft());
                    next.add(n.getRight());
                    if (n.getLeft() != null) nn++;
                    if (n.getRight() != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);
            List<Node> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    result.append(c);
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            result.append(" ");
                        }
                    } else {
                        for (int k = 0; k < hpw; k++) {
                            result.append(j % 2 == 0 ? " " : "─");
                        }
                        result.append(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            result.append(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                result.append("\n");
            }

            for (int j = 0; j < line.size(); j++) {
                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);
                for (int k = 0; k < gap1; k++) {
                    result.append(" ");
                }
                result.append(f);
                for (int k = 0; k < gap2; k++) {
                    result.append(" ");
                }
            }
            result.append("\n");
            perpiece /= 2;
        }

        return result.toString();
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
