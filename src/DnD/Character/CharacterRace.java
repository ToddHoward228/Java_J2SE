package DnD.Character;

import java.util.ArrayList;

abstract public class CharacterRace {
    String name;
    Stats bonuses;
    String description;
    ArrayList<Features> raceFeatures;

    CharacterRace() { raceFeatures = new ArrayList<>(); }

    public String getName() {
        return name;
    }
    public Stats getBonuses() {
        return bonuses;
    }
    public String getDescription() {
        return description;
    }
    public ArrayList<Features> getRaceFeatures() {
        return raceFeatures;
    }
}
