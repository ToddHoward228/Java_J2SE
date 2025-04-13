package DnD.Model;

abstract public class RaceElf extends CharacterRace {

    public RaceElf() {
        bonuses.wisdom += 1;

        description = "Created by the god Corellon, the first elves could change their forms at will. " +
                "They lost this ability when Corellon cursed them for plotting with the deity Lolth, " +
                "who tried and failed to usurp Corellon’s dominion. When Lolth was cast into the Abyss, " +
                "most elves renounced her and earned Corellon’s forgiveness, but that which Corellon had " +
                "taken from them was lost forever.";
    }

    public void saySMTH() {
        System.out.println("Хай удача буде з тобою");
    }
}
