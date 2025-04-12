package DnD.Character;

import DnD.Character.Visitor.IDataElementVisitor;
import DnD.Dice;
import java.util.ArrayList;

public class Character implements IDataElement {
    String name;
        Gender gender;
    Alignment alignment;
    CharacterRace characterRace;
    CharacterClass characterClass;
    Stats attributes;
    int hp;
    int level;

    public Character(String name, Gender gender, Alignment alignment, CharacterRace characterRace, CharacterClass characterClass, Stats attributes) {

        if (name == null || gender == null || alignment == null || characterRace == null || characterClass == null || attributes == null)
            throw new IllegalArgumentException("Values cannot be null");

        if (name.isBlank())
            throw new IllegalArgumentException("Name cannot be blank");

        this.name = name;
        this.gender = gender;
        this.alignment = alignment;
        this.characterRace = characterRace;
        this.characterClass = characterClass;
        this.attributes = attributes;

        level = 1;
        hp = characterClass.hitPointDie.getNumValue() + Math.max(attributes.getConstitutionModifier(), 0);
    }

    public void accept(IDataElementVisitor visitor) {

        visitor.visit(this);
    }

    public void levelUp(){

        level++;
        try {
            hp += Dice.roll(1, characterClass.hitPointDie) + Math.max(attributes.getConstitutionModifier(), 0) ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<IFeature> GetFeatures() {

        ArrayList<IFeature> mergedFeatures = characterClass.getClassFeatures();

        mergedFeatures.addAll(characterRace.getRaceFeatures());

        return mergedFeatures;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public CharacterRace getCharacterRace() {
        return characterRace;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public Stats getAttributes() {
        return attributes;
    }

    public int getHp() {
        return hp;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", alignment=" + alignment +
                ", characterRace=" + characterRace +
                ", characterClass=" + characterClass +
                ", attributes=" + attributes +
                ", hp=" + hp +
                ", level=" + level +
                '}';
    }
}
