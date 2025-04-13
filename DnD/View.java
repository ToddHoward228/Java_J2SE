package DnD;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame;
    private JPanel panel;

    private JTextField charNameBox;

    private JComboBox charGenderBox;

    private JComboBox charAlignmentBox;

    GridBagConstraints gbc;

    public View() {
        frame = new JFrame("Character creator");
        frame.setSize(340, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        frame.add(panel);
        panel.setBackground(new Color(53, 56, 66));
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        JLabel charNameLabel = new JLabel("Enter character name");
        charNameBox = new JTextField(10);
        charNameLabel.setForeground(Color.WHITE);

        gbc.gridy = 1;
        gbc.gridx = 0;
        panel.add(charNameLabel, gbc);
        gbc.gridx = 1;
        panel.add(charNameBox, gbc);

        String [] items = {"Male", "Female", "Combat Helicopter"};

        charGenderBox = new JComboBox(items);
        charGenderLabel.setForeground(Color.WHITE);

        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(charGenderLabel, gbc);
        gbc.gridx = 1;
        panel.add(charGenderBox, gbc);

        items = new String[]{
        "Lawful Good", "Lawful Neutral", "Lawful Evil",
        "Neutral Good", "Neutral Neutral", "Neutral Evil",
        "Chaotic Good", "Chaotic Neutral", "Chaotic Neutral"};
        JLabel charAlignmentLabel = new JLabel("Chose you alignment");
        charAlignmentBox = new JComboBox(items);
        charAlignmentLabel.setForeground(Color.WHITE);




    }

    private void addUIComponent(JComponent component, String labelText, GridBagConstraints gbc, int row) {

        JLabel charGenderLabel = new JLabel("Chose character gender");

        gbc.gridy = 3;
        gbc.gridx = 0;
        panel.add(charAlignmentLabel, gbc);
        gbc.gridx = 1;
        panel.add(charAlignmentBox, gbc);
    }


    public void Show(){
        frame.setVisible(true);
    }
}
