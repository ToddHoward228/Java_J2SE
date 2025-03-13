package DnD;

import DnD.Character.*;
import DnD.Character.Character;

public class Main {
    public static void main(String[] args) {


        Character mainHero = new Character("Aeredil", "Drow", "male", "Chaotic-Good", "Fighter", new Stats());

        System.out.println("Повернуто перше значення");
        mainHero.printSheet();
        mainHero.printFeatures();


        Character stranger = new Character("Oldric", "Human", "male", "True-Neutral", "Sorcerer", new Stats());

        System.out.println("Повернуто перше значення");
        stranger.printSheet();
        stranger.printFeatures();
    }
}