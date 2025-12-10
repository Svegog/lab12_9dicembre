package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    // private static final String ERROR_MESSAGE = "Unimplemented method";
    private final int numberOfButton;
    private final List<Integer> buttonNumbers;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.numberOfButton = size;
        this.buttonNumbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            buttonNumbers.add(0);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return this.numberOfButton;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> values() {
        return List.copyOf(this.buttonNumbers);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        final List<Boolean> listOfState = new ArrayList<>();
        for (final Integer elem : buttonNumbers) {
            listOfState.add(elem < numberOfButton);
        }
        return listOfState;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {

        int change = this.buttonNumbers.get(elem);
        change++;
        this.buttonNumbers.set(elem, change);

        return change;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {

        String result = "<<";
        for (int i = 0; i < this.buttonNumbers.size(); i++) {
            result = result.concat(Integer.toString(this.buttonNumbers.get(i)));
            if (i + 1 != this.buttonNumbers.size()) {
                result = result.concat("|");
            }
        }
        result = result.concat(">>");

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
      return buttonNumbers.stream().distinct().count() == 1;
    }
}
