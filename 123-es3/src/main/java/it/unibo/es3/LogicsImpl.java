package it.unibo.es3;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private static final int RANDOMBUTTONVALUE = 3;
    private final Set<Pair<Integer,Integer>> changedButtons;
    private final int size;

    LogicsImpl(final int size) {
        this.size = size;
        this.changedButtons = new HashSet<>();

        Random randomValue = new Random();
        IntStream.range(0, RANDOMBUTTONVALUE)
            .forEach(elem -> changedButtons
                .add(new Pair<>(randomValue.nextInt(size), randomValue.nextInt(size)))
            );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isNeighbor(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
        return !p1.equals(p2) && Math.abs(p1.x() - p2.x()) <= 1 && Math.abs(p1.y() - p2.y()) <= 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateMatrix() {
        Set<Pair<Integer,Integer>> tempButton = Set.copyOf(this.changedButtons);
        IntStream.range(0, this.size).forEach(
             y -> IntStream.range(0, this.size).forEach(
                 x -> {
                     final Pair<Integer, Integer> point = new Pair<>(x, y);
                     if (tempButton.stream().anyMatch(elem -> this.isNeighbor(elem, point))) {
                         this.changedButtons.add(point);
                     }
                 }   
             )
        );       
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getButtonState(Pair<Integer, Integer> p1) {
        return this.changedButtons.contains(p1) ? "*" : " ";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        return this.changedButtons.size() == size * size;
    }
    
}
