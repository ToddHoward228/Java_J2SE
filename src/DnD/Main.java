package DnD;

import DnD.Character.*;
import DnD.Character.Character;

public class Main {
    public static void main(String[] args) {

        RaceAbstractFactory factory = new DwarfMountainFighterFactory();

        Character dwarfGuardian1 = factory.create();
        Character dwarfGuardian2 = factory.create();

        dwarfGuardian1.printSheet();

        dwarfGuardian2.printSheet();

        System.out.println("\nDwarf Guardian 1 says:");
        dwarfGuardian1.getCharacterRace().saySMTH();

        factory = new WoodElfSorcererFactory();

        Character elvenStranger = factory.create();

        elvenStranger.printSheet();

        System.out.println("\nElven Stranger says:");
        elvenStranger.getCharacterRace().saySMTH();

    }
}