package it.unibo.es3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * GUI for the game.
 */
public final class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final List<JButton> cells = new ArrayList<>();
    private final transient Logics logics;
    private final int size;

    /**
     * Constructor.
     *
     * @param width the size of the grid
     */
    public GUI(final int width) {
        this.size = width;
        logics = new LogicsImpl(width);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Create a panel with a grid layout
        this.setLayout(new BorderLayout());
        final JPanel buttonPanel = new JPanel(new GridLayout(width, width));
        final JPanel progressPanel = new JPanel();
        this.getContentPane().add(buttonPanel, BorderLayout.CENTER);
        this.getContentPane().add(progressPanel, BorderLayout.SOUTH);
        // Create buttons and add them to the panel
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                final var pos = new Pair<>(j, i);
                final JButton button = new JButton(logics.getButtonState(pos));
                this.cells.add(button);
                button.setFocusable(false);
                buttonPanel.add(button);
            }
        }
        final JButton progress = new JButton(">");
        progress.addActionListener(e -> {
            this.logics.updateMatrix();
            this.renderFrame();
            if (this.logics.toQuit()) {
                this.dispose();
            }
        });
        progressPanel.add(progress);

        pack();
        this.setVisible(true);
    }

    private void renderFrame() {
        IntStream.range(0, size).forEach(
            y -> IntStream.range(0, size).forEach(
                x -> this.cells.get(x + size * y).setText(this.logics.getButtonState(new Pair<>(x, y)))
            )
        );
    }
}
