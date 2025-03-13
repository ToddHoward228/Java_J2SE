package DnD.Character.Class;

public class ClassFactory {
    public CharacterClass getClass(String className) {
        return switch (className) {
            case "Fighter" -> new Fighter();
            case "Sorcerer" -> new Sorcerer();
            default -> null;
        };
    }
}
