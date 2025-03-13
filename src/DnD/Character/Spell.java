package DnD.Character;

public class Spell implements Features {
    String name;
    String description;

    public Spell(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String GetName() {
        return name;
    }

    @Override
    public String GetDescription() {
        return description;
    }
}
