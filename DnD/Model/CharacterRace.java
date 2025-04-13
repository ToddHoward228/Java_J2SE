package DnD.Model;

import java.util.ArrayList;
import java.util.Objects;

abstract public class CharacterRace {
    String name;
    Stats bonuses;
    String description;
    ArrayList<IFeature> raceFeatures;

    public CharacterRace() {
        raceFeatures = new ArrayList<>();
        bonuses = new Stats(0, 0, 0, 0, 0, 0);
    }

    public String getName() {
        return name;
    }
    public Stats getBonuses() {
        return bonuses;
    }
    public String getDescription() {
        return description;
    }
    public ArrayList<IFeature> getRaceFeatures() {
        return new ArrayList<>(raceFeatures);
    }

    @Override
    public String toString() {
        return '\'' + name + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CharacterRace that = (CharacterRace) o;
        return Objects.equals(name, that.name) && Objects.equals(bonuses, that.bonuses) && Objects.equals(description, that.description) && Objects.equals(raceFeatures, that.raceFeatures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bonuses, description, raceFeatures);
    }
}