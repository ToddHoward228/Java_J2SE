package DnD.Character;

import DnD.Dice;

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
        strength = Dice.rollStat();
        dexterity = Dice.rollStat();
        constitution = Dice.rollStat();
        intelligence = Dice.rollStat();
        wisdom = Dice.rollStat();
        charisma = Dice.rollStat();

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