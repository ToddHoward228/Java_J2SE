package DnD.Character.Class;

import DnD.Character.Features;
import java.util.ArrayList;

public class CharacterClass {
    String className;
    int HitPointDie;
    ArrayList<Features> features;

    CharacterClass() {
        features = new ArrayList<>();
    }

    public String getClassName() {
        return className;
    }
    public int getHp() {
        return HitPointDie;
    }
    public ArrayList<Features> getFeatures() {
        return features;
    }
}
