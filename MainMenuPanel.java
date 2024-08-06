import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {
    private final TetrisGame parentFrame;

    public MainMenuPanel(TetrisGame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("Tetris");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;

        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(e -> parentFrame.startGame());
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(startButton, gbc);

        JButton optionsButton = new JButton("Options");
        optionsButton.addActionListener(e -> parentFrame.showConfigPanel());
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(optionsButton, gbc);

        JButton highScoresButton = new JButton("High Scores");
        highScoresButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "High Scores", "High Scores", JOptionPane.INFORMATION_MESSAGE));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(highScoresButton, gbc);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(exitButton, gbc);
    }
}
