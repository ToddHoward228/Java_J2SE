package DnD.Character;

import java.util.ArrayList;

abstract public class RaceDwarf extends CharacterRace {

    RaceDwarf() {
        bonuses.constitution += 2;

        raceFeatures.add(new FeaturePerk("Dwarven Resilience", "You have advantage on saving throws against poison, " +
                "and you have resistance against poison damage (explained in the “Combat” section)."));
    }


    public void saySMTH() {
        System.out.println("Я знав, що у вас, гадських ельфів, немає честі! немає поваги! немає пива!");
    }
}
