package DnD.Character;


import DnD.Character.Class.CharacterClass;
import DnD.Character.Class.ClassFactory;

public class Character {
    String name;
    String gender;
    String alignment;
    CharacterRace characterRace;
    CharacterClass characterClass;
    Stats attributes;
    int hp;
    int level = 1;

    public Character(String name, String gender, String alignment, CharacterRace characterRace, CharacterClass characterClass, Stats attributes) {
        this.name = name;
        this.gender = gender;
        this.alignment = alignment;
        this.characterRace = characterRace;
        this.characterClass = characterClass;
        this.attributes = attributes;

        setHp();
    }

    public void printSheet() {
        System.out.println("\tCharacter Information");
        System.out.println("Name      : " + name);
        System.out.println("Race      : " + characterRace.getName());
        System.out.println("Gender    : " + gender);
        System.out.println("Alignment : " + alignment);
        System.out.println("Class     : " + characterClass.getName());
        System.out.println("HP        : " + hp);
        System.out.println("\n\t" + name + " stats");
        attributes.print();

        printFeatures();
    }

    public void printFeatures() {
        System.out.println("\tCharacter Features");
        System.out.println("Class Features");
        for(Features feature : characterClass.getClassFeatures()){
            System.out.println(feature.GetName() + " : " + feature.GetDescription());
        }
        System.out.println("Race Features");
        for (Features feature : characterRace.getRaceFeatures()){
            System.out.println(feature.GetName() + " : " + feature.GetDescription());
        }

    }

    public CharacterRace getCharacterRace() {
        return characterRace;
    }

    void setHp() {
        hp = characterClass.getHp() * level;
    }
}
