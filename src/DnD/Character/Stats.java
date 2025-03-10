package DnD.Character;

import DnD.Dice;

public class Stats {

    public Stats() {
        stats = new int[6];
        generate();
    }

    int[] stats;
    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;

    public int[] getStats() {
        return stats;
    }

    public Stats generate() {

        for (int i = 0; i < 6; i++) {
            stats[i] = Dice.rollStat();
        }

        return this;
    }

    public Memento saveStateToMemento() {
        return new Memento(stats);
    }

    public void getStateFromMemento(int[] mem) {
        stats = mem;
    }

    public void distribution(){

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