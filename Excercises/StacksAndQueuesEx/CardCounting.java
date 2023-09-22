package DiscreteStructures.Excercises.StacksAndQueuesEx;

/**
 * Throwing cards away I
Given is an ordered deck of n cards numbered 1 to
n with card 1 at the top and card n at the bottom.
The following operation is performed as long as there
are at least two cards in the deck:
Throw away the top card and move the
card that is now on the top of the deck to
the bottom of the deck.
Your task is to find the sequence of discarded
cards and the last, remaining card.
Input
Each line of input (except the last) contains a number
n ≤ 50. The last line contains ‘0’ and this line should
not be processed.
Output
For each number from the input produce two lines of
output. The first line presents the sequence of discarded cards, the second line reports the last remaining card. No line will have leading or trailing spaces.
See the sample for the expected format.
Sample Input
7
19
10
6
0
Sample Output
Discarded cards: 1, 3, 5, 7, 4, 2
Remaining card: 6
Discarded cards: 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 4, 8, 12, 16, 2, 10, 18, 14
Remaining card: 6
Discarded cards: 1, 3, 5, 7, 9, 2, 6, 10, 8
Remaining card: 4
Discarded cards: 1, 3, 5, 2, 6
Remaining card: 4
 */

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class CardCounting {
    
    private static Scanner reader;

    public static void main(String[] args) {
        reader = new Scanner(System.in);
        cardsExercise();
    }


    public static void cardsExercise(){
        System.out.println("Enter the number of cards: ");
        int n = reader.nextInt();
        while(n!=0){
            Queue<Integer> q = new LinkedList<>();
            for(int j = 1; j <= n; j++){
                q.offer(j);
            }
            Queue<Integer> disCards = new LinkedList<>();
            while(q.size()!=1){
                disCards.offer(q.poll());
                q.offer(q.poll());
            }
            System.out.println("Discarded Cards: "+ printQueue(disCards));
            System.out.println("Remaining Cards: "+ printQueue(q));

            n = reader.nextInt();
        }
    }


    public static String printQueue(Queue<?> queue) {
        StringBuilder sb = new StringBuilder();

        for (Object item : queue) {
            sb.append(item.toString());
            sb.append(", ");
        }

        if (!queue.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }

        return sb.toString();
    }


}
