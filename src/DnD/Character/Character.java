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

    public Character(String name, String race, String gender, String alignment, String className, Stats attributes) {
        this.name = name;
        this.race = race;
        this.gender = gender;
        this.alignment = alignment;
        this.attributes = attributes;
        this.characterClass = new ClassFactory().getClass(className);
    }

    public void printSheet() {
        System.out.println("Character Information:");
        System.out.println("Name      : " + name);
        System.out.println("Race      : " + race);
        System.out.println("Gender    : " + gender);
        System.out.println("Alignment : " + alignment);
        System.out.println("Class     : " + characterClass.getClassName());
        attributes.print();
    }

    public void printFeatures() {
        characterClass.
    }

}
