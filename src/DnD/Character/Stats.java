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
            System.out.println("Your values for distribution\n");
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

    public Memento saveStateToMemento() {
        return new Memento(String.format("str:%d;str|dex:%d;dex|con:%d;con|int:%d;int|wis:%d;wis|chr:%d;chr",
                strength, dexterity, constitution, intelligence, wisdom, charisma));
    }

    public void getStateFromMemento(String mem) {

        strength = Integer.parseInt(mem.substring(mem.indexOf("str:") + 4, mem.indexOf(";str")));
        dexterity = Integer.parseInt(mem.substring(mem.indexOf("dex:") + 4, mem.indexOf(";dex")));
        constitution = Integer.parseInt(mem.substring(mem.indexOf("con:") + 4, mem.indexOf(";con")));
        intelligence = Integer.parseInt(mem.substring(mem.indexOf("int:") + 4, mem.indexOf(";int")));
        wisdom = Integer.parseInt(mem.substring(mem.indexOf("wis:") + 4, mem.indexOf(";wis")));
        charisma = Integer.parseInt(mem.substring(mem.indexOf("chr:") + 4, mem.indexOf(";chr")));
    }

    public void print() {
        System.out.println("Strength: " + strength);
        System.out.println("Dexterity: " + dexterity);
        System.out.println("Constitution: " + constitution);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("Wisdom: " + wisdom);
        System.out.println("Charisma: " + charisma);
    }
}