package DnD.Model;

import DnD.DiceVar;

import java.util.ArrayList;
import java.util.Objects;

abstract public class CharacterClass {
    String name;
    DiceVar hitPointDie;
    ArrayList<IFeature> classFeatures;

    public CharacterClass() {
        classFeatures = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public DiceVar getHitPointDie() {
        return hitPointDie;
    }

    public ArrayList<IFeature> getClassFeatures() {
        return new ArrayList<>(classFeatures);
    }

    @Override
    public String toString() {
        return '\'' + name + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CharacterClass that = (CharacterClass) o;
        return hitPointDie == that.hitPointDie && Objects.equals(name, that.name) && Objects.equals(classFeatures, that.classFeatures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hitPointDie, classFeatures);
    }
}
