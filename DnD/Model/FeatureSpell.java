package DnD.Model;

public class FeatureSpell implements IFeature {
    String name;
    String description;

    public FeatureSpell(String name, String description) {
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
