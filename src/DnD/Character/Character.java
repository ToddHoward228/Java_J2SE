package DnD.Character;


import DnD.Character.Class.CharacterClass;
import DnD.Character.Class.ClassFactory;

public class Character {
    String name;
    String race;
    String gender;
    String alignment;
    CharacterClass characterClass;
    Stats attributes;
    int hp;
    int level = 1;

    public Character(String name, String race, String gender, String alignment, String className, Stats attributes) {
        this.name = name;
        this.race = race;
        this.gender = gender;
        this.alignment = alignment;
        this.attributes = attributes;
        this.characterClass = new ClassFactory().getClass(className);

        setHp();
    }

    public void printSheet() {
        System.out.println("Character Information:");
        System.out.println("Name      : " + name);
        System.out.println("Race      : " + race);
        System.out.println("Gender    : " + gender);
        System.out.println("Alignment : " + alignment);
        System.out.println("Class     : " + characterClass.getClassName());
        System.out.println("HP        : " + hp);
        attributes.print();

        printFeatures();
    }

    public void printFeatures() {
        for(Features feature : characterClass.getFeatures()){
            System.out.println(feature.GetName() + " : " + feature.GetDescription());

        }
    }

    void setHp() {
        hp = characterClass.getHp() * level;
    }
}
