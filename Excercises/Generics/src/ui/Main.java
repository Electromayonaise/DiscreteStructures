package ui;

import model.DoubleLinkedList;
import model.Node;
import java.util.Scanner;
import java.util.InputMismatchException;

// Implemetation of generics with double linked list
public class Main {

    private Scanner sc;
    private DoubleLinkedList<Integer> listOfIntegers;
    private DoubleLinkedList<String> listOfStrings;
    private DoubleLinkedList<User> listOfUser;

    public Main() {

        listOfIntegers = new DoubleLinkedList<>();
        listOfStrings = new DoubleLinkedList<>();
        listOfUser = new DoubleLinkedList<>();
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Main m = new Main();
        int option = 0;
        while (option != 4) {
            m.menu();
            option = m.sc.nextInt();
            m.executeOperation(option);
        }
    }

    public void menu() {
        System.out.println("Select an option");
        System.out.println("1. Add elements menu");
        System.out.println("2. Delete elements menu");
        System.out.println("3. Show elements menu");
        System.out.println("4. Exit");
    }

    public void addElementsMenu() {
        System.out.println("Select an option");
        System.out.println("1. Add integer");
        System.out.println("2. Add string");
        System.out.println("3. Add user");
        System.out.println("4. Back");
    }

    public void deleteElementsMenu() {
        System.out.println("Select an option");
        System.out.println("1. Delete integer");
        System.out.println("2. Delete string");
        System.out.println("3. Back");
    }

    public void showElementsMenu() {
        System.out.println("Select an option");
        System.out.println("1. Show integer list");
        System.out.println("2. Show string list");
        System.out.println("3. Show user list");
        System.out.println("4. Back");
    }

    public void executeOperation(int option) {
        switch (option) {
            case 1:
                addElements();
                break;
            case 2:
                deleteElements();
                break;
            case 3:
                showElements();
                break;
            case 4:
                System.out.println("Bye");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public void addElements() {
        int option = 0;
        while (option != 4) {
            addElementsMenu();
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the integer");
                    try {
                        int integer = sc.nextInt();
                        Node<Integer> nodeInteger = new Node<>(integer);
                        listOfIntegers.addLastUser(nodeInteger);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input");
                    }
                    break;
                case 2:
                    System.out.println("Enter the string");
                    String string = sc.next();
                    Node<String> nodeString = new Node<>(string);
                    listOfStrings.addLastUser(nodeString);
                    break;
                case 3:
                    System.out.println("Enter the year");
                    try {
                        int year = sc.nextInt();
                        User user = new User(year);
                        Node<User> nodeUser = new Node<>(user);
                        listOfUser.addLastUser(nodeUser);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input");
                    }
                    break;
                case 4:
                    System.out.println("Back");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    public void deleteElements() {
        int option = 0;
        while (option != 3) {
            deleteElementsMenu();
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the integer");
                    try {
                        int integer = sc.nextInt();
                        System.out.println(listOfIntegers.delete(integer));
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input");
                    }
                    break;
                case 2:
                    System.out.println("Enter the string");
                    String string = sc.next();
                    System.out.println(listOfStrings.delete(string));
                    break;
                case 3:
                    System.out.println("Back");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    public void showElements() {
        int option = 0;
        while (option != 4) {
            showElementsMenu();
            option = sc.nextInt();
            switch (option) {
                case 1:
                    if (listOfIntegers.showList().equals("")) {
                        System.out.println("The integer list is empty");
                    } else {
                        System.out.println("Integer list: ");
                        System.out.println(listOfIntegers.showList());
                    }
                    break;
                case 2:
                    if (listOfStrings.showList().equals("")) {
                        System.out.println("The string list is empty");
                    } else {
                        System.out.println("String list: ");
                        System.out.println(listOfStrings.showList());
                    }
                    break;
                case 3:
                    if (listOfUser.showList().equals("")) {
                        System.out.println("The user list is empty");
                    } else {
                        System.out.println("User list: ");
                        System.out.println(listOfUser.showList());
                    }
                    break;
                case 4:
                    System.out.println("Back");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}

// clase anonimizada
class User implements Comparable<User> {

    private int year;

    public User(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(User o) {
        return this.year - o.getYear();
    }
}