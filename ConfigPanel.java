import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    private final TetrisGame parentFrame;

    public ConfigPanel(TetrisGame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("Options");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;

        JLabel fieldWidthLabel = new JLabel("Field Width:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(fieldWidthLabel, gbc);

        // Initialize with current setting
        JSpinner fieldWidthSpinner = new JSpinner(new SpinnerNumberModel(parentFrame.getFieldWidth(), 6, 15, 1));
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(fieldWidthSpinner, gbc);

        JLabel fieldHeightLabel = new JLabel("Field Height:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(fieldHeightLabel, gbc);

        // Initialize with current setting
        JSpinner fieldHeightSpinner = new JSpinner(new SpinnerNumberModel(parentFrame.getFieldHeight(), 8, 30, 1));
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(fieldHeightSpinner, gbc);

        JLabel gameLevelLabel = new JLabel("Game Level:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(gameLevelLabel, gbc);

        // Initialize with current setting
        JSpinner gameLevelSpinner = new JSpinner(new SpinnerNumberModel(parentFrame.getGameLevel(), 1, 10, 1));
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(gameLevelSpinner, gbc);

        JCheckBox musicCheckBox = new JCheckBox("Music", parentFrame.isMusicOn());
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(musicCheckBox, gbc);

        JCheckBox soundEffectCheckBox = new JCheckBox("Sound Effect", parentFrame.isSoundEffectOn());
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(soundEffectCheckBox, gbc);

        JCheckBox aiPlayCheckBox = new JCheckBox("AI Play", parentFrame.isAiPlay());
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        add(aiPlayCheckBox, gbc);

        JCheckBox extendModeCheckBox = new JCheckBox("Extend Mode", parentFrame.isExtendMode());
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        add(extendModeCheckBox, gbc);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            int width = (int) fieldWidthSpinner.getValue();
            int height = (int) fieldHeightSpinner.getValue();
            int level = (int) gameLevelSpinner.getValue();
            boolean music = musicCheckBox.isSelected();
            boolean soundEffect = soundEffectCheckBox.isSelected();
            boolean aiPlay = aiPlayCheckBox.isSelected();
            boolean extendMode = extendModeCheckBox.isSelected();

            parentFrame.updateSettings(width, height, level, music, soundEffect, aiPlay, extendMode);
            parentFrame.showMainMenu();
        });
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        add(saveButton, gbc);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> parentFrame.showMainMenu());
        gbc.gridx = 1;
        gbc.gridy = 8;
        add(cancelButton, gbc);
    }
}
