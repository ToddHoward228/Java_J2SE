package DnD.Character;

import DnD.Dice;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Stats {

    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;

    public Stats() {
        generate();
    }

    public Stats(int str, int dex, int cons, int inte, int wis, int charis) {

        if (str < 0 || dex < 0 || cons < 0 || inte < 0 || wis < 0 || charis < 0)
            throw new IllegalArgumentException("Values cannot be less than 1");

        strength = str;
        dexterity = dex;
        constitution = cons;
        intelligence = inte;
        wisdom = wis;
        charisma = charis;
    }

    public Stats(Stats stats) {
        if (stats == null)
            throw new IllegalArgumentException("stats cannot be null");

        this.strength = stats.strength;
        this.dexterity = stats.dexterity;
        this.constitution = stats.constitution;
        this.intelligence = stats.intelligence;
        this.wisdom = stats.wisdom;
        this.charisma = stats.charisma;
    }

    public void generate() {
        ArrayList<Integer> values = new ArrayList<>();

        for (int i = 0; i < 6; i++)
            values.add(Dice.rollStat());

        choseStats(values);
    }

    public void generate(int str, int dex, int cons, int inte, int wis, int charis) {
        strength = str;
        dexterity = dex;
        constitution = cons;
        intelligence = inte;
        wisdom = wis;
        charisma = charis;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getStrengthModifier() {
        return (strength / 2) - 5;
    }

    public int getDexterityModifier() {
        return (dexterity / 2) - 5;
    }

    public int getConstitutionModifier() {
        return (constitution / 2) - 5;
    }

    public int getIntelligenceModifier() {
        return (intelligence / 2) - 5;
    }

    public int getWisdomModifier() {
        return (wisdom / 2) - 5;
    }

    public int getCharismaModifier() {
        return (charisma / 2) - 5;
    }

    public void choseStats(ArrayList<Integer> values){
        Scanner sc = new Scanner(System.in);
        int index;
        final String[] ABILITY = {"STRENGTH", "DEXTERITY", "CONSTITUTION", "INTELLIGENCE", "WISDOM", "CHARISMA"};

        for (int i = 0; i < 6; i++) {
            System.out.println("\tYour values for distribution");
            for (int j = 0; j < values.size(); j++)
                System.out.print("[#" + j + "-(" + values.get(j) + ")]");

            do {
                System.out.print("\nEnter index of attribute for " + ABILITY[i] + ": ");
                index = sc.nextInt();
            } while (index < 0 || index >= values.size());

            switch (ABILITY[i]) {
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
    }

    public String saveStateToMemento() {
        return String.format("str:%d;str|dex:%d;dex|con:%d;con|int:%d;int|wis:%d;wis|chr:%d;chr",
                strength, dexterity, constitution, intelligence, wisdom, charisma);
    }

    public void getStateFromMemento(String memento) {

        strength = Integer.parseInt(memento.substring(memento.indexOf("str:") + 4, memento.indexOf(";str")));
        dexterity = Integer.parseInt(memento.substring(memento.indexOf("dex:") + 4, memento.indexOf(";dex")));
        constitution = Integer.parseInt(memento.substring(memento.indexOf("con:") + 4, memento.indexOf(";con")));
        intelligence = Integer.parseInt(memento.substring(memento.indexOf("int:") + 4, memento.indexOf(";int")));
        wisdom = Integer.parseInt(memento.substring(memento.indexOf("wis:") + 4, memento.indexOf(";wis")));
        charisma = Integer.parseInt(memento.substring(memento.indexOf("chr:") + 4, memento.indexOf(";chr")));
    }

    @Override
    public String toString() {
        return "Stats{" +
                "strength=" + strength +
                ", dexterity=" + dexterity +
                ", constitution=" + constitution +
                ", intelligence=" + intelligence +
                ", wisdom=" + wisdom +
                ", charisma=" + charisma +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Stats stats = (Stats) o;
        return strength == stats.strength && dexterity == stats.dexterity && constitution == stats.constitution && intelligence == stats.intelligence && wisdom == stats.wisdom && charisma == stats.charisma;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strength, dexterity, constitution, intelligence, wisdom, charisma);
    }
}