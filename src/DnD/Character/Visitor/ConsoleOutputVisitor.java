package DnD.Character.Visitor;

/**
 * Клас візитор для виводу даних в консоль
 */
public class ConsoleOutputVisitor implements IDataElementVisitor {
    public void visit(DnD.Character.Character character) {
        System.out.println("\tCharacter\n" +
                "name='" + character.getName() + '\'' +
                ", gender=" + character.getGender() +
                ", alignment=" + character.getAlignment() +
                ", hp=" + character.getHp()+
                ", level=" + character.getLevel());

        visit(character.getAttributes());
        visit(character.getCharacterClass());
        visit(character.getCharacterRace());
    }

    public void visit(DnD.Character.Stats stats) {
        System.out.println("\tStats\n" +
                "strength=" + stats.getStrength() +
                ", dexterity=" + stats.getDexterity() +
                ", constitution=" + stats.getConstitution() +
                ", intelligence=" + stats.getIntelligence() +
                ", wisdom=" + stats.getWisdom() +
                ", charisma=" + stats.getCharisma() );
    }

    public void visit(DnD.Character.CharacterClass characterClass) {
        System.out.println("\tCharacterClass\n" +
                "name='" + characterClass.getName() + '\'' +
                ", hitPointDie=" + characterClass.getHitPointDie() +
                ", classFeatures=" + characterClass.getClassFeatures());
    }

    public void visit(DnD.Character.CharacterRace race) {
        System.out.println("\tCharacterRace\n" +
                "name='" + race.getName() + '\'' +
                ", description='" + race.getDescription() + '\'' +
                ", raceFeatures=" + race.getRaceFeatures());
    }
}
