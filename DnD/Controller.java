package DnD;

import DnD.Model.*;
import DnD.Model.Character;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import javax.swing.*;

public class Controller {

    private View view;

    private int generations = 0;

    private Memento memento = new Memento();

    public DnD.Model.Character character = null;

    ArrayList<String> generatedAttributes = new ArrayList<>();

    public Controller(View view) {
        this.view = view;

        for (JComboBox<String> cb : view.attributesBoxes)
            cb.addPopupMenuListener(new ComboPopupListener());

        view.getGenerateButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                generations++;
                if (generations == 2)
                    memento.add(generatedAttributes);

                generatedAttributes.clear();

                for (int i = 0; i < 6; i++)
                    generatedAttributes.add("#" + (i + 1) + ' ' + Dice.rollStat());

                for (JComboBox<String> cb : view.attributesBoxes) {
                    cb.setSelectedItem("-");
                }

                if (generations == 2){
                    view.getGenerateButton().setEnabled(false);
                    view.getUndoStatsButton().setEnabled(true);
                }
            }
        });

        view.getUndoStatsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatedAttributes = memento.undo();

                for (JComboBox<String> cb : view.attributesBoxes) {
                    cb.setSelectedItem("-");
                }
                view.getUndoStatsButton().setEnabled(false);
            }
        });

        // Button Accept
        view.getAcceptButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Data validation

                if (view.getCharNameBox() == null || view.getCharGenderBox() == null ||
                        view.getCharAlignmentBox() == null || view.getCharRaceBox() == null || view.getCharClassBox() == null) {

                    JOptionPane.showMessageDialog(view.getCharNameBox(),
                            "Name cannot be null", "Empty value", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (view.getCharNameBox().getText().isBlank()){
                    JOptionPane.showMessageDialog(view.getCharNameBox(),
                            "Name cannot be blank", "Non valid value", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                for (JComboBox<String> cb : view.attributesBoxes) {
                    if (cb.getSelectedItem() == null || cb.getSelectedItem().equals("-")) {
                        JOptionPane.showMessageDialog(cb,
                                "Stat field empty", "Non valid value", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }

                CharacterRace characterRace =
                switch ((String) view.getCharRaceBox().getSelectedItem()){
                    case "Wood Elf" -> new RaceWoodElf();
                    case "Mountain Dwarf" -> new RaceDwarfMountain();
                    default -> null;
                };

                if (characterRace == null){
                    JOptionPane.showMessageDialog(view.getCharRaceBox(),
                            "Race cannot be null", "Non valid value", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                CharacterClass characterClass =
                        switch ((String) view.getCharClassBox().getSelectedItem()){
                            case "Fighter" -> new ClassFighter();
                            case "Sourcerer" -> new ClassSorcerer();
                            default -> null;
                        };

                if (characterClass == null){
                    JOptionPane.showMessageDialog(view.getCharClassBox(),
                            "Class cannot be null", "Non valid value", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Gender gender = switch ((String) view.getCharGenderBox().getSelectedItem()){
                    case "Male" -> Gender.MALE;
                    case "Female" -> Gender.FEMALE;
                    default -> null;
                };

                if (gender == null){
                    JOptionPane.showMessageDialog(view.getCharGenderBox(),
                            "Gender invalid", "Non valid value", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Alignment alignment = switch ((String) view.getCharAlignmentBox().getSelectedItem()){
                    case ("Lawful Good") -> Alignment.LAWFUL_GOOD;
                    case ("Lawful Neutral") -> Alignment.LAWFUL_NEUTRAL;
                    case ("Lawful Evil") -> Alignment.LAWFUL_EVIL;
                    case ("Neutral Good") -> Alignment.NEUTRAL_GOOD;
                    case ("Neutral Neutral") -> Alignment.NEUTRAL_NEUTRAL;
                    case ("Neutral Evil") -> Alignment.NEUTRAL_EVIL;
                    case ("Chaotic Good") -> Alignment.CHAOTIC_GOOD;
                    case ("Chaotic Neutral") -> Alignment.CHAOTIC_NEUTRAL;
                    case ("Chaotic Evil") -> Alignment.CHAOTIC_EVIL;
                    default -> null;
                };

                if (alignment == null){
                    JOptionPane.showMessageDialog(view.getCharAlignmentBox(),
                            "Aligment invalid", "Non valid value", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Stats stats = null;
                try{
                    stats = new Stats(
                            Integer.parseInt(((String) view.attributesBoxes[0].getSelectedItem()).split(" ")[1]),
                            Integer.parseInt(((String) view.attributesBoxes[1].getSelectedItem()).split(" ")[1]),
                            Integer.parseInt(((String) view.attributesBoxes[2].getSelectedItem()).split(" ")[1]),
                            Integer.parseInt(((String) view.attributesBoxes[3].getSelectedItem()).split(" ")[1]),
                            Integer.parseInt(((String) view.attributesBoxes[4].getSelectedItem()).split(" ")[1]),
                            Integer.parseInt(((String) view.attributesBoxes[5].getSelectedItem()).split(" ")[1])
                    );
                }
                catch (Exception exception)
                {
                    JOptionPane.showMessageDialog(view.getCharClassBox(),
                            "Stats invalid", "Non valid value", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Create character
                character = new Character(view.getCharNameBox().getText(), gender, alignment, characterRace, characterClass, stats );

                System.out.println("Character created: " + character);

                view.getAcceptButton().setEnabled(false);
            }
        });
    }

    private void updateAllComboBoxes() {
        List<String> selectedValues = new ArrayList<>();
        for (JComboBox<String> cb : view.attributesBoxes) {
            if (cb.getSelectedItem() != null) {
                selectedValues.add((String) cb.getSelectedItem());
            }
        }

        for (JComboBox<String> cb : view.attributesBoxes) {
            String currentSelection = (String) cb.getSelectedItem();
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

            if (currentSelection != null){
                model.addElement(currentSelection);
                if (!currentSelection.equals("-"))
                    model.addElement("-");
            }

            for (String value : generatedAttributes) {
                if (!selectedValues.contains(value)) {
                    model.addElement(value);
                }
            }

            cb.setModel(model);

            if (currentSelection != null && model.getIndexOf(currentSelection) >= 0)
                cb.setSelectedItem(currentSelection);
        }
    }

    class ComboPopupListener implements PopupMenuListener {
        @Override
        public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            updateAllComboBoxes();
        }

        @Override
        public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
        }

        @Override
        public void popupMenuCanceled(PopupMenuEvent e) {
        }
    }
}
