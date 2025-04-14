package DnD;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame;
    private JPanel panel;
    private JPanel charAttributesPanel;

    private JTextField charNameBox;
    private JComboBox charGenderBox;
    private JComboBox charAlignmentBox;
    private JComboBox charClassBox;
    private JComboBox charRaceBox;

    JComboBox<String>[] attributesBoxes = new JComboBox[6];

    private JButton undoStatsButton;
    private JButton generateButton;
    private JButton acceptButton;

    private GridBagConstraints gbc;
    private GridBagConstraints gbcStats;

    public View() {
        frame = new JFrame("Character creator");
        frame.setSize(340, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Panel
        panel = new JPanel();
        frame.add(panel);
        panel.setBackground(new Color(53, 56, 66));
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;

        // Name
        charNameBox = new JTextField(10);
        addUIComponent(charNameBox,"Enter character name", panel, gbc, 0);

        // Gender
        String [] items = {"Male", "Female"};
        charGenderBox = new JComboBox(items);
        addUIComponent(charGenderBox,"Enter character name", panel, gbc, 1);

        // Alignment
        items = new String[]{
        "Lawful Good", "Lawful Neutral", "Lawful Evil",
        "Neutral Good", "Neutral Neutral", "Neutral Evil",
        "Chaotic Good", "Chaotic Neutral", "Chaotic Evil"};
        charAlignmentBox = new JComboBox(items);
        addUIComponent(charAlignmentBox,"Chose character alignment", panel, gbc, 2);

        // Race
        items = new String[]{"Wood Elf", "Mountain Dwarf"};
        charRaceBox = new JComboBox(items);
        addUIComponent(charRaceBox,"Chose character race", panel, gbc, 3);

        // Class
        items = new String[]{"Fighter", "Sourcerer"};
        charClassBox = new JComboBox(items);
        addUIComponent(charClassBox,"Chose character class", panel, gbc, 4);

        // Stats
        JLabel statsLabel = new JLabel("Stats");
        statsLabel.setForeground(Color.WHITE);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 5;
        gbc.gridx = 0;
        panel.add(statsLabel, gbc);

        charAttributesPanel = new JPanel();
        charAttributesPanel.setBackground(new Color(69, 75, 91));
        charAttributesPanel.setLayout(new GridBagLayout());

        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(charAttributesPanel, gbc);

        gbcStats = new GridBagConstraints();
        gbcStats.insets = new Insets(5, 5, 5, 5);
        gbcStats.fill = GridBagConstraints.BOTH;
        gbcStats.weightx = 1.0;

        for (int i = 0; i < 6; i++) {
            attributesBoxes[i] = new JComboBox();
            attributesBoxes[i].addItem("-");
        }

        addUIComponent(attributesBoxes[0], "Strength", charAttributesPanel, gbcStats, 0);
        addUIComponent(attributesBoxes[1], "Dexterity", charAttributesPanel, gbcStats, 1);
        addUIComponent(attributesBoxes[2], "Constitution", charAttributesPanel, gbcStats, 2);
        addUIComponent(attributesBoxes[3], "Intelligence", charAttributesPanel, gbcStats, 3);
        addUIComponent(attributesBoxes[4], "Wisdom", charAttributesPanel, gbcStats, 4);
        addUIComponent(attributesBoxes[5], "Charisma", charAttributesPanel, gbcStats, 5);

        // Buttons
        generateButton = new JButton("Generate");
        undoStatsButton = new JButton("Undo");
        undoStatsButton.setEnabled(false);

        gbcStats.gridy = 7;
        gbcStats.gridx = 0;
        charAttributesPanel.add(undoStatsButton, gbcStats);
        gbcStats.gridx = 1;
        charAttributesPanel.add(generateButton, gbcStats);

        acceptButton = new JButton("Accept");

        gbc.gridy = 7;
        panel.add(acceptButton, gbc);
    }

    public JTextField getCharNameBox() {
        return charNameBox;
    }

    public JComboBox getCharGenderBox() {
        return charGenderBox;
    }

    public JComboBox getCharAlignmentBox() {
        return charAlignmentBox;
    }

    public JComboBox getCharClassBox() {
        return charClassBox;
    }

    public JComboBox getCharRaceBox() {
        return charRaceBox;
    }

    public JButton getUndoStatsButton() {
        return undoStatsButton;
    }

    public JButton getGenerateButton() {
        return generateButton;
    }

    public JButton getAcceptButton() {
        return acceptButton;
    }

    private void addUIComponent(JComponent component, String labelText, JPanel panel, GridBagConstraints gbc, int row) {

        JLabel label = new JLabel(labelText);
        label.setForeground(Color.WHITE);

        gbc.gridy = row;
        gbc.gridx = 0;
        panel.add(label, gbc);
        gbc.gridx = 1;
        panel.add(component, gbc);
    }

    public void Show(){
        frame.setVisible(true);
    }
}
