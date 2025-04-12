package DnD.Character;

public class FeaturePerk implements IFeature {
    String name;
    String description;

    public FeaturePerk(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
