package it.unibo.es2;

/**
 * Interface for the Logics part 2.
 */
public interface Logics {

    /**
     * Check if the program need to finish.
     * 
     * @return the state of the program
     */
    boolean isWinReached();

    /**
     * Change the state of the singular cell.
     * 
     * @param position the cell to change.
     * @return the state as String.
     */
    String changeState(int position);

}
