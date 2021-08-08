package TickTockToe;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Saurabh Vaish
 * @Date 06-06-2021
 */
public class Board {

    static int BOARDSIZE=3;
    static Set<Integer> availableMoves= new CopyOnWriteArraySet<>();

    static void init(){
        for (int i = 1; i <= BOARDSIZE*BOARDSIZE; i++) {
            availableMoves.add(i);
        }
    }
}
