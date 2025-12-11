package it.unibo.es3;

/**
 * Interface that models the logic of the program.
 */
public interface Logics {

    /**
     * Function that checks if a point is neighbor of another.
     * 
     * @param p1 the first point, order doesn't matter
     * @param p2 the second point, same as above
     * 
     * @return true if the point are neighbor, false otherwise
     */
    boolean isNeighbor(Pair<Integer,Integer> p1, Pair<Integer,Integer> p2);

    /**
     * The main function that updates the matrix of the game.
     */
    void updateMatrix();

    /**
     * Given a point, return the value that is inside based on condition.
     * 
     * @param p1 the point given from the GUI
     * 
     * @return the empty string " " if the point is not in the data structure and "*" otherwise
     */
    String getButtonState(Pair<Integer,Integer> p1);

    /**
     * Check if the game is finished.
     * 
     * @return true if the program needs to end, false otherwise
     */
    boolean toQuit();
}
