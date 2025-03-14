package DnD.Character;


import DnD.Character.Class.CharacterClass;
import DnD.Character.Class.ClassFactory;
import DnD.Character.Class.Fighter;

import java.util.Random;

public class DwarfMountainFighterFactory implements RaceAbstractFactory{

    String[] dwarfNames = {
            "Adrik", "Alberich", "Baern", "Barendd", "Brottor", "Bruenor", "Dain", "Darrak",
            "Delg", "Eberk", "Einkil", "Fargrim", "Flint", "Gardain", "Harbek", "Kildrak",
            "Morgran", "Orsik", "Oskar", "Rangrim", "Rurik", "Taklinn", "Thoradin", "Thorin",
            "Tordek", "Traubon", "Travok", "Ulfgar", "Veit", "Vondal"
    };

    Random rand = new Random();


    public Character create() {
        Stats stats = new Stats(16,14,16,10,8,10);

        CharacterRace characterRace = new DwarfMountain();
        CharacterClass characterClass = ClassFactory.getClass("Fighter");

        return new Character(dwarfNames[rand.nextInt(dwarfNames.length)], "male", "lawful-good", characterRace, characterClass, stats);
    }
}
