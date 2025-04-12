package DnD.Character;

import DnD.DiceVar;

public class ClassSorcerer extends CharacterClass {
    public ClassSorcerer() {
        name = "Sorcerer";

        hitPointDie = DiceVar.D6;

        classFeatures.add(new FeatureSpell("Meteor", "A devastating 9th-level evocation spell that summons four " +
                "blazing meteors, each exploding on impact. Deals massive fire and bludgeoning damage over a wide " +
                "area—perfect for obliterating armies or leveling strongholds."));

        classFeatures.add(new FeatureSpell("Earthquake", "An 8th-level evocation spell that creates a powerful " +
                "tremor in a massive radius. It can knock creatures prone, open fissures, collapse structures, and " +
                "cause widespread chaos and destruction."));

    }
}
