package DnD;

import DnD.Character.*;
import DnD.Character.Character;

public class Main {
    public static void main(String[] args) {

        Stats stats = new Stats();

        stats.print();

        CareTaker mainHeroCareTaker = new CareTaker();

        mainHeroCareTaker.add(stats.saveStateToMemento());




        Character mainHero = new Character("Aeredil", "Drow", "male", "Haotig-Good", "Fighter", stats);

    }
}