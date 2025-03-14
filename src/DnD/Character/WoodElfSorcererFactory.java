package DnD.Character;

import DnD.Character.Class.CharacterClass;
import DnD.Character.Class.ClassFactory;

import java.util.Random;

public class WoodElfSorcererFactory implements RaceAbstractFactory {
    String[] elvenNames = {
            "Faelar", "Laeroth", "Melwasul", "Rolen", "Thalassor", "Urian", "Vaeril", "Zoren", "Caladrel", "Firael",
            "Orist", "Phaeril", "Thamior", "Varis", "Aelar", "Belanor", "Erevan", "Galinndan", "Immeral", "Quarion",
            "Soveliss", "Tarron", "Arannis", "Horith", "Lamlis", "Mythanar", "Neldor", "Saelar"
    };

    Random rand = new Random();


    public Character create() {
        Stats stats = new Stats(8, 14, 15, 12, 10, 16);

        CharacterRace characterRace = new WoodElf();
        CharacterClass characterClass = ClassFactory.getClass("Sorcerer");

        return new Character(elvenNames[rand.nextInt(elvenNames.length)], "male", "lawful-good", characterRace, characterClass, stats);
    }
}
