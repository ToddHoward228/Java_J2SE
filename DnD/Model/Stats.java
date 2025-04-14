package DnD.Model;

import java.util.Objects;

public class Stats {

    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;

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