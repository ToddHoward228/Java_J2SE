package DnD.Character;

import DnD.Dice;

import java.util.ArrayList;
import java.util.Scanner;

public class Stats {

    public Stats() {
        generate();
    }

    String stats;
    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;


    public Stats generate() {
        ArrayList<Integer> values = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int index;
        final String[] ATTRIBUTE = {"STRENGTH", "DEXTERITY", "CONSTITUTION", "INTELLIGENCE", "WISDOM", "CHARISMA"};

        for (int i = 0; i < 6; i++)
            values.add(Dice.rollStat());


        for (int i = 0; i < 6; i++) {
            System.out.println("\tYour values for distribution");
            for (int j = 0; j < values.size(); j++)
                System.out.print("[#" + j + "-(" + values.get(j) + ")]");

            do {
                System.out.print("\nEnter index of attribute for " + ATTRIBUTE[i] + ": ");
                index = sc.nextInt();
            } while (index < 0 || index >= values.size());

            switch (ATTRIBUTE[i]) {
                case "STRENGTH":
                    strength = values.get(index);
                    break;
                case "DEXTERITY":
                    dexterity = values.get(index);
                    break;
                case "CONSTITUTION":
                    constitution = values.get(index);
                    break;
                case "INTELLIGENCE":
                    intelligence = values.get(index);
                    break;
                case "WISDOM":
                    wisdom = values.get(index);
                    break;
                case "CHARISMA":
                    charisma = values.get(index);
                    break;
            }
            values.remove(index);
        }

        return this;
    }

    public void print() {
        System.out.println("\n\tYour stats");
        System.out.println("Strength: " + strength);
        System.out.println("Dexterity: " + dexterity);
        System.out.println("Constitution: " + constitution);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("Wisdom: " + wisdom);
        System.out.println("Charisma: " + charisma);
    }
}