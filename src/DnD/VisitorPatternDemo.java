package DnD;

import DnD.Character.*;
import DnD.Character.Character;
import DnD.Character.Visitor.ConsoleOutputVisitor;

public class VisitorPatternDemo {
    public static void main(String[] args) {

        Character mainHero;

        try{
            mainHero = new Character("Aeredil", Gender.MALE, Alignment.LAWFUL_NEUTRAL, new RaceDwarfMountain(),
                    new ClassFighter(), new Stats(16, 14, 14, 13, 10, 8));

            ConsoleOutputVisitor visitor = new ConsoleOutputVisitor();

            mainHero.accept(visitor);

        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}