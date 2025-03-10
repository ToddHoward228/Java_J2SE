package DnD;

import DnD.Character.*;
import DnD.Character.Character;

public class Main {
    public static void main(String[] args) {

        Stats stats = new Stats();
        CareTaker mainHeroCareTaker = new CareTaker();

        Character mainHero = new Character("Aeredil", "Drow", "male", "Haotig-Good", "Fighter", stats);

        stats.print();
        mainHeroCareTaker.add(stats.saveStateToMemento());

        stats.generate();
        stats.print();

        mainHeroCareTaker.add(stats.saveStateToMemento());
        stats.getStateFromMemento(mainHeroCareTaker.get(0));

        System.out.println("Повернуто перше значення");
        mainHero.printSheet();

    }
}