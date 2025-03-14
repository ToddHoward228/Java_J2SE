package DnD.Character;

import java.util.ArrayList;

public class CharacterClass {
    String name;
    int HitPointDie;
    ArrayList<Features> classFeatures;

    CharacterClass() {
        classFeatures = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public int getHp() {
        return HitPointDie;
    }
    public ArrayList<Features> getClassFeatures() {
        return classFeatures;
    }
}
