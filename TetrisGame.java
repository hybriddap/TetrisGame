import javax.swing.*;
import java.awt.*;

public class TetrisGame extends JFrame {
    private JLabel statusBar;
    private JLabel scoreLabel;
    private TetrisBoard board;

    private int fieldWidth = 10;
    private int fieldHeight = 20;
    private int gameLevel = 1;
    private boolean musicOn = false;
    private boolean soundEffectOn = false;
    private boolean aiPlay = false;
    private boolean extendMode = false;

    public TetrisGame() {
        initUI();
    }

    private void initUI() {
        scoreLabel = new JLabel("Score: 0");
        showMainMenu();
    }

    public void startGame() {
        if (board != null) {
            remove(board);
        }
        board = new TetrisBoard(this, fieldWidth, fieldHeight, gameLevel, musicOn, soundEffectOn, aiPlay, extendMode);
        add(scoreLabel, BorderLayout.NORTH);
        add(board, BorderLayout.CENTER);

        setTitle("Tetris");
        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        board.startGame();
        board.setFocusable(true);
        board.requestFocusInWindow();
        revalidate();
        repaint();
    }

    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    public void updateSettings(int width, int height, int level, boolean music, boolean soundEffect, boolean ai, boolean extend) {
        this.fieldWidth = width;
        this.fieldHeight = height;
        this.gameLevel = level;
        this.musicOn = music;
        this.soundEffectOn = soundEffect;
        this.aiPlay = ai;
        this.extendMode = extend;
    }

    public void showConfigPanel() {
        getContentPane().removeAll();
        ConfigPanel configPanel = new ConfigPanel(this);
        getContentPane().add(configPanel);
        revalidate();
        repaint();
    }

    public void showMainMenu() {
        getContentPane().removeAll();
        MainMenuPanel mainMenuPanel = new MainMenuPanel(this);
        getContentPane().add(mainMenuPanel);
        revalidate();
        repaint();
    }

    public void restartGame() {
        startGame();
    }

    public void gameOver() {
        int option = JOptionPane.showOptionDialog(this,
            "Game Over\nYour Score: " + board.getScore(),
            "Game Over",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new Object[] { "Restart", "Main Menu" },
            "Restart");

        if (option == JOptionPane.YES_OPTION) {
            restartGame();
        } else {
            showMainMenu();
        }
    }

    // Getter methods for settings
    public int getFieldWidth() {
        return fieldWidth;
    }

    public int getFieldHeight() {
        return fieldHeight;
    }

    public int getGameLevel() {
        return gameLevel;
    }

    public boolean isMusicOn() {
        return musicOn;
    }

    public boolean isSoundEffectOn() {
        return soundEffectOn;
    }

    public boolean isAiPlay() {
        return aiPlay;
    }

    public boolean isExtendMode() {
        return extendMode;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            TetrisGame game = new TetrisGame();
            game.setVisible(true);
        });
    }
}
