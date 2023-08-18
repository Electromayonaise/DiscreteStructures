    import java.util.TreeSet;
    import java.util.Scanner;

public class AramicScriptEx {

    /* 
    In Aramic language words can only represent objects.

    Words in Aramic have special properties:

    A word is a root if it does not contain the same letter more than once.
    A root and all its permutations represent the same object.
    The root x of a word y is the word that contains all letters that appear in y in a way that each letter appears once. For example, the root of "aaaa", "aa", "aaa" is "a", the root of "aabb", "bab", "baabb", "ab" is "ab".
    Any word in Aramic represents the same object as its root.
    You have an ancient script in Aramic. What is the number of different objects mentioned in the script?
    
    */
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numWords = sc.nextInt();
        String[] words = new String[numWords];
        for (int i = 0; i < numWords; i++) {
            words[i] = sc.next();
        }
        System.out.println(numRoots(words));
        sc.close();
    }
    
    public static int numRoots(String[] words) {
        TreeSet<String> roots = new TreeSet<String>();
        for (int i = 0; i < words.length; i++) {
            roots.add(root(words[i]));
        }
        return roots.size();
    }

    public static String root(String word) {
        TreeSet<Character> letters = new TreeSet<Character>();
        for (int i = 0; i < word.length(); i++) {
            letters.add(word.charAt(i));
        }
        String root = "";
        for (Character letter : letters) {
            root += letter;
        }
        return root;
    }


}
