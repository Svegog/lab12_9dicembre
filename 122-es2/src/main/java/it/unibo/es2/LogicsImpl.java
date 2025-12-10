package it.unibo.es2;

/**
 * Basic implementation.
 */
public class LogicsImpl implements Logics {

    private final int[][] matrixOfButtons;
    private final int size;
    private final int dimensions;

    /**
     * Basic constructor.
     * 
     * @param size the dimension of the matrix.
     */
    public LogicsImpl(final int size) {
        this.size = size;
        this.dimensions = size * size;
        final int[][] matrix = new int[size][size];
        this.matrixOfButtons = matrix;

        for (int i = 0; i < dimensions; i++) {
            matrix[i / size][i % size] = 0;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isWinReached() {
        int countTrisColums = 0;
        int countTrisRows = 0;

        // check lines and colums
        for (int i = 0; i < dimensions; i++) {
            countTrisRows += matrixOfButtons[i / size][i % size];
            countTrisColums += matrixOfButtons[i % size][i / size];
            if (i % size == size - 1) {
                if (countTrisRows == size || countTrisColums == size) {
                    return true;
                }
                countTrisRows = 0;
                countTrisColums = 0;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String changeState(final int position) {
        final String result;
        if (matrixOfButtons[position / size][position % size] == 0) {
            result = "*";
            matrixOfButtons[position / size][position % size] = 1;
        } else {
            result = " ";
            matrixOfButtons[position / size][position % size] = 0;
        }
        return result;
    }
}
