package DnD;

import DnD.Character.*;
import DnD.Character.Character;

import DnD.Character.Visitor.IDataElementVisitor;
import DnD.Character.Visitor.JSONOutputVisitor;

public class VisitorPatternDemo {
    public static void main(String[] args) {

        Character mainHero;
        JSONOutputVisitor visitor = new JSONOutputVisitor();

        try{

            mainHero = new Character("Aeredil", Gender.MALE, Alignment.CHAOTIC_GOOD, new RaceWoodElf(),
                    new ClassFighter(), new Stats(16, 14, 14, 13, 10, 8));
            Character stranger = new Character("Omira", Gender.FEMALE, Alignment.LAWFUL_NEUTRAL, new RaceDwarfMountain(),
                    new ClassSorcerer(), new Stats(8, 16, 10, 16, 10, 15));

            visitor.changePath("mainHero.json");
            visitor.visit(mainHero);
            visitor.changePath("mainHeroAttributes.json");
            visitor.visit(mainHero.getAttributes());
            visitor.changePath("mainHeroClass.json");
            visitor.visit(mainHero.getCharacterClass());
            visitor.changePath("mainHeroRace.json");
            visitor.visit(mainHero.getCharacterRace());

            visitor.changePath("stranger.json");
            visitor.visit(stranger);
            visitor.changePath("strangerAttributes.json");
            visitor.visit(stranger.getCharacterClass());
            visitor.changePath("strangerClass.json");
            visitor.visit(stranger.getCharacterRace());
            visitor.changePath("strangerRace.json");
            visitor.visit(stranger.getCharacterClass());


        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}