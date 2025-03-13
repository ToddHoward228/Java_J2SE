package DnD.Character;


public class Character {
    String name;
    String race;
    String gender;
    String alignment;
    String className;
    Stats attributes;

    public Character(String name, String race, String gender, String alignment, String className, Stats attributes) {
        this.name = name;
        this.race = race;
        this.gender = gender;
        this.alignment = alignment;
        this.className = className;
        this.attributes = attributes;
    }

    public void printSheet() {
        System.out.println("Character Information:");
        System.out.println("Name      : " + name);
        System.out.println("Race      : " + race);
        System.out.println("Gender    : " + gender);
        System.out.println("Alignment : " + alignment);
        System.out.println("Class     : " + className);
        attributes.print();
    }

}
