package DnD.Character;


public class Character {
    String name;
    String gender;
    String alignment;
    CharacterRace characterRace;
    CharacterClass characterClass;
    Stats attributes;
    int hp;
    int level = 1;

    public Character(String name, String race, String gender, String alignment, String className, Stats attributes) {
        this.name = name;
        this.gender = gender;
        this.alignment = alignment;
        this.attributes = attributes;
        this.characterClass = new ClassFactory().getClass(className);

        setHp();
    }

    public void printSheet() {
        System.out.println("Character Information");
        System.out.println("Name      : " + name);
        System.out.println("Race      : " + characterRace.getName());
        System.out.println("Gender    : " + gender);
        System.out.println("Alignment : " + alignment);
        System.out.println("Class     : " + characterClass.getName());
        System.out.println("HP        : " + hp);
        attributes.print();

        printFeatures();
    }

    public void printFeatures() {
        System.out.println("Character Features");
        System.out.println("Class Features");
        for(Features feature : characterClass.getClassFeatures()){
            System.out.println(feature.GetName() + " : " + feature.GetDescription());
        }
        System.out.println("Race Features");
        for (Features feature : characterRace.getRaceFeatures()){
            System.out.println(feature.GetName() + " : " + feature.GetDescription());
        }

    }

    void setHp() {
        hp = characterClass.getHp() * level;
    }
}
